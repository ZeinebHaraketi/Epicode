/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CommentaireService;
import entites.Blog;
import entites.Commentaire;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ARIJ
 */
public class Ajouter_CommController implements Initializable {

    @FXML
    private TextField Id_com;
    @FXML
    private TextField Nom_c;
    @FXML
    private TextField Email;
    @FXML
    private TextField Message;
    @FXML
    private TextField Date;
    @FXML
    private TextField Nom_article;
    @FXML
    private TextField Id_b;
    @FXML
    private Button ajouter;
    @FXML
    private Button afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    

    @FXML
    private void ajouter_com(ActionEvent event) {
         Commentaire c1=new Commentaire();
         if(accepterEmail()){
        c1.setId_com(Integer.valueOf(Id_com.getText()));
        c1.setNom_c(Nom_c.getText());
        c1.setEmail(Email.getText());
        c1.setMessage(Message.getText());
        c1.setDate(Date.getText());
        c1.setNom_article(Nom_article.getText());
        c1.setId_b(Integer.valueOf(Id_b.getText()));
        CommentaireService cs = new CommentaireService();
        cs.ajouterCommentaire(c1);
        
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();
        
        
        
        
        
        
      ObservableList<Commentaire> listc;
      FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Commentaire.fxml"));
      
       try{
           
           Parent root = loader.load();
           Afficher_CommentaireController ac = loader.getController();
           //ac.loadData();
           //ac.setAff_act(as.afficherActivite().toString());
           Id_b.getScene().setRoot(root);
           
           
       }
       catch(IOException ex){
           System.out.println(ex.getMessage());
       }}
    }
    @FXML
    private void afficher_com(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Afficher_Commentaire.fxml"));
        Commentaire c1=new Commentaire();
        c1.setId_com(Integer.valueOf(Id_com.getText()));
      
        try{
            Parent root = loader.load();
           Afficher_CommentaireController cs = loader.getController();
           Id_com.getScene().setRoot(root);
        }
        catch(IOException ex){
           System.out.println(ex.getMessage());
       }

    }
    public boolean accepterEmail() {
         boolean ok = false;
         String message = "", tex = Email.getText().trim();
         int posiArrobase = 0, posiPoint = 0, posi2 = 0;
 
        if (tex.contains(" ")) {                          // signaler l'espace
            message = " il y a un espace dans l''adresse email ";
        }
        if (message.length() == 0) {
            posiArrobase = tex.indexOf("@");
            if (posiArrobase < 0) {
                message = " arrobase (@) manque dans l'adresse email ";
            }
            if ((posiArrobase == 0) || (tex.endsWith("@"))) {
                message = " arrobase (@) mal placé dans l'adresse email ";
            }
            if ((posiArrobase > 0) && (posiArrobase < tex.length())) {
                posi2 = tex.indexOf("@",posiArrobase+1);
                if (posi2 > posiArrobase) {
                    message = " double arrobase (@) dans l'adresse email ";
                }
            }
            if (message.length() == 0) {
                posiPoint = tex.indexOf(".");
                if (posiPoint == -1) {
                    message = " on doit trouver au moins un point dans l'adresse email ";
                }
                if ((posiPoint == 0) || (tex.endsWith(".")))  {
                    message = " point mal placé dans l'adresse email ";
                }
            }
            if (message.length() == 0) {
                if (tex.length() == 0) {
                    message = " l'adresse email est vide ";
                }
            }
        }
        if (message.length() == 0) {
            ok = true;
        }
        else {
            JOptionPane.showMessageDialog(null,message);
            //tf_email.requestFocusInWindow();
        }
         return(ok);
     }
}
    


    

    
    
