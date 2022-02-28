/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Consultation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Entities.Programme;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import Services.Programmeservices;
import Services.consultationservices;
/**
 * FXML Controller class
 *
 * @author GAMRA
 */
public class Ajouter_programmeController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField date;
    @FXML
    private TextField id_kine;
    @FXML
    private TextArea des;
    @FXML
    private TextField id_c;
    @FXML
    private Button ajouter;
    @FXML
    private Button Afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_programme(ActionEvent event) {
         Programme p= new Programme();
       p.setId(Integer.valueOf(id.getText()));
       p.setNom_p(nom.getText());
       p.setDate_r (date.getText());
       p.setId_kine(Integer.valueOf(id_kine.getText()));
       p.setdescription(des.getText());
       p.setId_c(Integer.valueOf(id_c.getText()));
       
       
         Programmeservices pro = new Programmeservices();
           pro.ajouterProgramme(p);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("afficher_programme.fxml"));
         
       try{
           
           Parent root = loader.load();
            Afficher_programmeController ac = loader.getController();
           id.getScene().setRoot(root);
           
           
       }
       catch(IOException ex){
           System.out.println(ex.getMessage());
       }

    }

    @FXML
    private void afficher_programme(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("afficher_programme.fxml"));
        Programme p=new Programme();
        p.setId(Integer.valueOf(id.getText()));
      
        try{
            Parent root = loader.load();
           Afficher_programmeController bs = loader.getController();
           id.getScene().setRoot(root);
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
