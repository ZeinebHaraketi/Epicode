/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import tools.Connexion_b;

/**
 * FXML Controller class
 *
 * @author ARIJ
 */
public class Comment_statController implements Initializable {

    @FXML
    private PieChart stat;
    private Statement st;
    private ResultSet rs;
    private Connection cnx;
        ObservableList<PieChart.Data>data=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cnx = Connexion_b.getInstance().getCnx();
        try {
            stat();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(Comment_statController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void stat() throws SQLException {
       try{
           String query = "SELECT COUNT(*),Nom_c FROM commentaire GROUP BY Nom_c" ;
       
             PreparedStatement PreparedStatement = cnx.prepareStatement(query);
             rs = PreparedStatement.executeQuery();  
             while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("Nom_c"),rs.getInt("COUNT(*)")));
            }
       }catch (SQLException ex) {
            Logger.getLogger(Afficher_CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
    }
        stat.setTitle("**Statistiques nombres des Email**");
        stat.setLegendSide(Side.LEFT);
        stat.setData(data);
    }
    
}
