/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feel_the_burn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Entities.Produit;
import Services.ProduitService;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author zeine
 */
public class Ajouter_ProduitController implements Initializable {

    @FXML
    private TextField aj_id;
    @FXML
    private TextField aj_nom;
    @FXML
    private TextField aj_prix;
    @FXML
    private TextField aj_photo;
    @FXML
    private TextField aj_cat;
    @FXML
    private Button ajouter_prod;

    
    @FXML
    private Button afficher_prod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_prod(ActionEvent event) {
        Produit p1= new Produit();
        
        p1.setId_P(Integer.valueOf(aj_id.getText()));
        p1.setNom_P(aj_nom.getText());
        p1.setPrix(Float.valueOf(aj_prix.getText()));
        p1.setPhoto(aj_photo.getText());
        p1.setCategories(aj_cat.getText());
        
        ProduitService ps = new ProduitService();
        ps.ajouterProduit(p1);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Produit.fxml"));
        
        try{
           
           Parent root = loader.load();
           Afficher_ProduitController ac = loader.getController();
           //ac.loadData();
           //ac.setAff_act(as.afficherActivite().toString());
           aj_id.getScene().setRoot(root);
           
           
       }
       catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }

    @FXML
    private void afficher_prod(ActionEvent event) {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Produit.fxml"));
        try{
           
           Parent root = loader.load();
           Afficher_ProduitController ac = loader.getController();
           
           aj_id.getScene().setRoot(root);
           
           
       }
       catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
