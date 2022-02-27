/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CoursServices;
import Entities.Cours;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WAEL
 */
public class AjouterCoursController implements Initializable {

    @FXML
    private Button Ajouter_Cours;
    @FXML
    private Button Afficher_Cours;
    @FXML
    private TextField Add_Nom_Co;
    @FXML
    private TextField Add_Id_C;
    @FXML
    private TextField Add_Date_Co;
    @FXML
    private TextField Add_Id_Co;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter_Cours(ActionEvent event) {
        Cours c= new Cours();
        c.setId_C(Integer.valueOf(Add_Id_C.getText()));
        c.setNom_C(Add_Nom_Co.getText());
        c.setDate_C(Add_Date_Co.getText());
        c.setId_Co(Integer.valueOf(Add_Id_Co.getText()));
        
        CoursServices acs = new CoursServices();
        acs.ajouterCours(c);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();
        
   
        
      //ObservableList<Cours> lista;
      FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Cours.fxml"));
      
       try{
           
           Parent root = loader.load();
           Afficher_CoursController ac = loader.getController();
           //ac.loadData();
           //ac.setAff_act(as.afficherActivite().toString());
           Add_Id_C.getScene().setRoot(root);
           
           
       }
       catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }

    @FXML
    private void Afficher_Cours(ActionEvent event) {
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Cours.fxml"));
        Cours a2= new Cours();
        a2.setId_C(Integer.valueOf(Add_Id_C.getText()));
      
        try{
            Parent root = loader.load();
           Afficher_CoursController ac = loader.getController();
           Add_Id_C.getScene().setRoot(root);
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }
    }
    

