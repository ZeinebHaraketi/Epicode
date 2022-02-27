/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Entities.Enfant;
import Services.EnfantServices;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author zeine
 */
public class Ajouter_EnfantController implements Initializable {

    @FXML
    private TextField add_ide;
    @FXML
    private TextField add_nome;
    @FXML
    private TextField add_prenom;
    @FXML
    private TextField add_age;
    @FXML
    private TextField add_sexe;
    @FXML
    private TextField add_photo;
    @FXML
    private TextField add_idu;
    @FXML
    private Button add_enf;
    @FXML
    private Button aff_enf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_enfant(ActionEvent event) {
        Enfant e1 = new Enfant();
        
        e1.setId_enfant(Integer.valueOf(add_ide.getText()));
        e1.setNom(add_nome.getText());
        e1.setPrenom(add_prenom.getText());
        e1.setAge(Integer.valueOf(add_age.getText()));
        e1.setSexe(add_sexe.getText());
        e1.setPhoto(add_photo.getText());
        e1.setId_a(Integer.valueOf(add_idu.getText()));
        
        EnfantServices es = new EnfantServices();
        es.ajouterEnfant(e1);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();
        
         FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Enfant.fxml"));
         
         try
         {
           Parent root = loader.load();
           Afficher_EnfantController ec = loader.getController();  
            add_ide.getScene().setRoot(root);
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }
    }

    @FXML
    private void afficher_enfant(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Enfant.fxml"));
        Enfant a2= new Enfant();
        a2.setId_a(Integer.valueOf(add_ide.getText()));
      
        try{
            Parent root = loader.load();
           Afficher_EnfantController ec = loader.getController();
           add_ide.getScene().setRoot(root);
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
