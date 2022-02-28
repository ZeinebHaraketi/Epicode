/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Panier;
import Entities.Produit;
import Services.PanierService;
import Services.ProduitService;
import static GUI.Afficher_ProduitController.idxx;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 

/**
 *
 * @author rekik
 */
public class Afficher_PanierController implements Initializable {
 @FXML
    private TableView<Panier> tab_pan;
    @FXML
    private TableColumn<Panier,Integer > aj_id_pa;
    @FXML
    private TableColumn<Panier,Integer > aj_q;
    @FXML
    private TableColumn<Panier, String> aj_coupon;
    @FXML
    private TableColumn<Panier, Integer> aj_id_p;
   
    @FXML
    private Button update_pan;
    @FXML
    private Button supp_pan;
     public static String idxx;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        PanierService ps= new PanierService();
        
        tab_pan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aj_id_pa.setText(String.valueOf(ps.liste2().get(tab_pan.getSelectionModel().getSelectedIndex()).getId_Pa()
            ));
            aj_q.setText(String.valueOf(ps.liste2().get(tab_pan.getSelectionModel().getSelectedIndex()).getQuantite() ));
            aj_coupon.setText( ps.liste2().get(tab_pan.getSelectionModel().getSelectedIndex()).getCoupon());
            aj_id_p.setText(String.valueOf(ps.liste2().get(tab_pan.getSelectionModel().getSelectedIndex()).getId_P() ));
               
            };
        });
        
        
                 ObservableList<Panier> list;
                 try
                 {
                     list = ps.getPanierList();
                     System.out.println(list);
                     aj_id_pa.setCellValueFactory(new PropertyValueFactory<>("Id_Pa"));
                     aj_q.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
                     aj_coupon.setCellValueFactory(new PropertyValueFactory<>("Coupon"));
                     aj_id_p.setCellValueFactory(new PropertyValueFactory<>("Id_P"));
                     
                    tab_pan.setItems(list);
                 } catch (SQLException ex) {
            Logger.getLogger(Afficher_PanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   


       
  

    @FXML
    private void update_pan(ActionEvent event) throws IOException {
        idxx= (Integer.toString(tab_pan.getSelectionModel().getSelectedItem().getId_Pa()));
               
        FXMLLoader loader = new FXMLLoader();
       
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("update_panier.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.show();
    }
public void delete()
    {
      PanierService pa = new PanierService();
      pa.supprimerPanier(tab_pan.getSelectionModel().getSelectedItem().getId_Pa());
      System.out.println(tab_pan.getSelectionModel().getSelectedItem().getId_Pa());
    }
    @FXML
    private void supp_pan(ActionEvent event) {
        delete();
        tab_pan.getItems().removeAll(tab_pan.getSelectionModel().getSelectedItem());
        System.out.println(tab_pan);
        
        
    }

    @FXML
    private void list_pan(MouseEvent event) {
    }
    
}
