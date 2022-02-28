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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import Entities.Enfant;
import Services.EnfantServices;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zeine
 */
public class Afficher_EnfantController implements Initializable {

    @FXML
     TableView<Enfant> tab_enf;
    @FXML
    private TableColumn<Enfant, Integer> aff_ide;
    @FXML
    private TableColumn<Enfant, String> aff_nome;
    @FXML
    private TableColumn<Enfant, String> aff_prenom;
    @FXML
    private TableColumn<Enfant, Integer> aff_age;
    @FXML
    private TableColumn<Enfant, String> aff_sexe;
    @FXML
    private TableColumn<Enfant, String> aff_photo;
    @FXML
    private TableColumn<Enfant, Integer> aff_idu;
    @FXML
    private Button del_enf;
    public static String idxx;
    @FXML
    private Button upd_enf;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EnfantServices es = new EnfantServices();
        
        tab_enf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              //aff_ide.setText(String.valueOf(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getId_enfant()));
              aff_ide.setText(String.valueOf(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getId_enfant()));
              aff_nome.setText(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getNom());
              aff_prenom.setText(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getPrenom());
              aff_age.setText(String.valueOf(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getAge()));
              aff_sexe.setText(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getSexe());
              aff_photo.setText(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getPhoto());
              aff_idu.setText(String.valueOf(es.liste2().get(tab_enf.getSelectionModel().getSelectedIndex()).getId_a()));
            };
        });
        
        ObservableList<Enfant> list;
        try{
            list = es.getEnfantList();
            aff_ide.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
            aff_nome.setCellValueFactory(new PropertyValueFactory<>("nom"));
            aff_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            aff_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            aff_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            aff_photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
            aff_idu.setCellValueFactory(new PropertyValueFactory<>("id_a"));
            tab_enf.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_EnfantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void liste_enf(MouseEvent event) {
    }

    //------------------------------------------------ Bouton Supprimer ----------------------------------------------------------------//
     public void delete()
    {
        EnfantServices es = new EnfantServices();
       es.supprimerEnfant(tab_enf.getSelectionModel().getSelectedItem().getId_enfant());
        System.out.println(tab_enf.getSelectionModel().getSelectedItem().getId_enfant());
    }

    @FXML
    private void supprimer_enfant(ActionEvent event) {
         delete();
        tab_enf.getItems().removeAll(tab_enf.getSelectionModel().getSelectedItem());
        System.out.println(tab_enf);
        tab_enf.refresh();
    }

    @FXML
    private void modifier_enfant(ActionEvent event) throws IOException {
        idxx= (Integer.toString(tab_enf.getSelectionModel().getSelectedItem().getId_enfant()));
               
        FXMLLoader loader = new FXMLLoader();
       
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Modifier_Enfant.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.show();
    }
    
}
