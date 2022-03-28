/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.BlogService;
import com.twilio.Twilio;
import static com.twilio.example.Example.ACCOUNT_SID;
import com.twilio.rest.api.v2010.account.Message;
import entites.Blog;
import java.awt.Image;
import java.io.File;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ARIJ
 */
public class AjouterBlogController implements Initializable {

    @FXML
    private TextField Id_b;
    @FXML
    private TextField Titre;
    @FXML
    private TextField Auteur;
    @FXML
    private TextField date;
    @FXML
    private TextField image;
    @FXML
    private TextField contenu;
    @FXML
    private TextField categorie;
    @FXML
    private Button ajouter;
    @FXML
    private Button afficher;
    @FXML
    private Button retour;
    @FXML
    private ImageView upload;
    
    
     public static final String ACCOUNT_SID = "ACf8c4371d8c45bf5dbc55d4a677acd8f4";
    public static final String AUTH_TOKEN = "52226b6188420c815a48535eabdeebcb";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_Blog(ActionEvent event) {
        Blog b1=new Blog();
        b1.setId_b(Integer.valueOf(Id_b.getText()));
        b1.setTitre(Titre.getText());
        b1.setContenu(contenu.getText());
        b1.setDate(date.getText());
         b1.setAuteur(Auteur.getText());
         b1.setImage(image.getText());
        b1.setcategorie(categorie.getText());
        BlogService bs = new BlogService();
        bs.ajouterBlog(b1);
        
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();
        
        //SEND SMS START 
        
          Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+216 20072897"),
                new com.twilio.type.PhoneNumber("+17152882584"),
                "Ena yssr mahleni ")
            .create();

        System.out.println(message.getSid());
        
        //SEND SMS END
        
        
        
        
        
        
      ObservableList<Blog> listb;
      FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Blog.fxml"));
      
       try{
           
           Parent root = loader.load();
           Afficher_BlogController ac = loader.getController();
           //ac.loadData();
           //ac.setAff_act(as.afficherActivite().toString());
           Id_b.getScene().setRoot(root);
           
           
       }
       catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }

    @FXML
    private void afficher_Blog(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Blog.fxml"));
        Blog b1=new Blog();
        b1.setId_b(Integer.valueOf(Id_b.getText()));
      
        try{
            Parent root = loader.load();
           Afficher_BlogController bs = loader.getController();
           Id_b.getScene().setRoot(root);
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }

    
}
