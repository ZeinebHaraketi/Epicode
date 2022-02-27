
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Entities.Activite;
import Services.ActiviteService;
import GUI.Afficher_ActiviteController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Modifier_ActiviteController implements Initializable {

    @FXML
    private TextField mod_ida;
    @FXML
    private TextField mod_nom;
    @FXML
    private TextField mod_cat;
    @FXML
    private TextField mod_type;
    @FXML
    private TextField mod_ide;
    @FXML
    private Button mod_act;
    @FXML
    private Button afficher_act;
    @FXML
    private TableView<Activite> aff_mod_act;
    @FXML
    private TableColumn<Activite,Integer> aff_ida1;
    @FXML
    private TableColumn<Activite, String> aff_noma1;
    @FXML
    private TableColumn<Activite, Integer> aff_cat1;
    @FXML
    private TableColumn<Activite, String> aff_type1;
    @FXML
    private TableColumn<Activite, Integer> aff_ide1;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ActiviteService as = new ActiviteService();
        
        
        try
        {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("Afficher_Activite.fxml"));
          Stage prStage = new Stage();
            Parent root= loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            Afficher_ActiviteController ac = loader.getController();
           int id = Integer.parseInt(Afficher_ActiviteController.idxx);
            System.out.println(id);
            
           mod_nom.setText(as.getNombyID(id));
           mod_cat.setText(as.getCatAgebyId(id).toString());
           mod_type.setText(as.getTypebyID(id));
           mod_ide.setText(as.getID_EnfantbyId(id).toString());
           
         
        } catch (IOException ex) {
            Logger.getLogger(Modifier_ActiviteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void modifier_act(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Afficher_Activite.fxml"));
            Stage prStage = new Stage();
            Parent root= loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            
            Afficher_ActiviteController ac = loader.getController();
            ActiviteService as = new ActiviteService();
            Activite a = new Activite();
            
            int id= Integer.parseInt(Afficher_ActiviteController.idxx);
            System.out.println(id);
            a.setNom_a(mod_nom.getText());
            a.setCat_age(Integer.parseInt(mod_cat.getText()));
            a.setType(mod_type.getText());
            a.setId_enfant(Integer.parseInt(mod_ide.getText()));
            
            as.modifier(a, id);
             Alert alert = new Alert (Alert.AlertType.INFORMATION);
             alert.setTitle("succes");
             alert.setHeaderText("!!! Modification effectuer avec suucces !!!");
             alert.setContentText("succes");
             alert.showAndWait();
            
             
       
    }

    @FXML
    private void afficher_act(ActionEvent event) {
    }
    
}
