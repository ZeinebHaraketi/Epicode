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
import Entities.Produit;
import Services.ProduitService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import  GUI.Ajouter_ProduitController;
import static java.util.Collections.list;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 * FXML Controller class
 *
 * @author zeine
 */
public class Afficher_ProduitController implements Initializable {
    
    @FXML
    private TableView<Produit> tab_prod;
    @FXML
    private TableColumn<Produit, Integer> id_p;
    @FXML
    private TableColumn<Produit, String> nom_p;
    @FXML
    private TableColumn<Produit,Float> prix;
    @FXML
    private TableColumn<Produit, String> photo;
    @FXML
    private TableColumn<Produit, String> cat;
    @FXML
    private Button supp_prod;
    @FXML
    private Button update_prod;
    public static String idxx;

   // Ajouter_ProduitController apc= new Ajouter_ProduitController();
    @FXML
    private TextField recherche;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProduitService ps = new ProduitService();
        
        tab_prod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               id_p.setText(String.valueOf(ps.liste2().get(tab_prod.getSelectionModel().getSelectedIndex()).getId_P()));
               nom_p.setText(ps.liste2().get(tab_prod.getSelectionModel().getSelectedIndex()).getNom_P());
               prix.setText(String.valueOf(ps.liste2().get(tab_prod.getSelectionModel().getFocusedIndex()).getPrix()));
               photo.setText(ps.liste2().get(tab_prod.getSelectionModel().getSelectedIndex()).getPhoto());
               cat.setText(ps.liste2().get(tab_prod.getSelectionModel().getSelectedIndex()).getCategories());
               
            };
        });
        
        ObservableList<Produit> listp;
        try{
            listp = ps.getProduitList();
            id_p.setCellValueFactory(new PropertyValueFactory<>("Id_P"));
            nom_p.setCellValueFactory(new PropertyValueFactory<>("Nom_P"));
            prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
            photo.setCellValueFactory(new PropertyValueFactory<>("Photo"));
            cat.setCellValueFactory(new PropertyValueFactory<>("Categories"));
            
            tab_prod.setItems(listp);
            // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Produit> filteredData = new FilteredList<>(listp, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Produit -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Produit.getNom_P().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (Produit.getCategories().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                              
				} 
                                else if (String.valueOf(Produit.getId_P()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Produit> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tab_prod.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tab_prod.setItems(sortedData);
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_ProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

    @FXML
    private void liste_prod(MouseEvent event) {
    }

    
    //------------------------------------- Bouton Supprimer -----------------------------------------------------------------------//
    
    public void delete()
    {
      ProduitService ps = new ProduitService();
      ps.supprimerProduit(tab_prod.getSelectionModel().getSelectedItem().getId_P());
      System.out.println(tab_prod.getSelectionModel().getSelectedItem().getId_P());
    }
    
    @FXML
    private void supp_prod(ActionEvent event) {
        delete();
        tab_prod.getItems().removeAll(tab_prod.getSelectionModel().getSelectedItem());
        System.out.println(tab_prod);
    }

    @FXML
    private void update_prod(ActionEvent event) throws IOException {
         /*Parent root = FXMLLoader.load(getClass().getResource("update_produit.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();   */         
    idxx= (Integer.toString(tab_prod.getSelectionModel().getSelectedItem().getId_P()));
               
        FXMLLoader loader = new FXMLLoader();
       
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("update_produit.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.show();

    
    
    
}

    @FXML
    private void recherche_p(ActionEvent event) {
    }
}


