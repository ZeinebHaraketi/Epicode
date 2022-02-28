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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WAEL
 */
public class Afficher_CoursController implements Initializable {

    @FXML
     TableView<Cours> tablecours;
    @FXML
    private TableColumn<Cours, Integer> Afficher_Id_C;
    @FXML
    private TableColumn<Cours, String> Afficher_Nom_C;
    @FXML
    private TableColumn<Cours, String> Afficher_Date_C;
    @FXML
    private TableColumn<Cours, Integer> Afficher_Id_Co;
    @FXML
    private Button Modifier_Cours;
    @FXML
    private TextField filterfield;
    public static String idxx;
    public void delete()
    {
        CoursServices cs=new CoursServices();
       cs.supprimerCours(tablecours.getSelectionModel().getSelectedItem().getId_C());
        System.out.println(tablecours.getSelectionModel().getSelectedItem().getId_C());
    }
    @FXML
    private Button Supprimer_Cours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            // TODO
        
        CoursServices bs= new CoursServices();
        
        tablecours.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
       
                Afficher_Id_C.setText(String.valueOf(bs.liste2().get(tablecours.getSelectionModel().getSelectedIndex()).getId_C()
               ));
               Afficher_Nom_C.setText(bs.liste2().get(tablecours.getSelectionModel().getSelectedIndex()).getNom_C());
               Afficher_Date_C.setText(bs.liste2().get(tablecours.getSelectionModel().getSelectedIndex()).getDate_C() );
               Afficher_Id_Co.setText(String.valueOf(bs.liste2().get(tablecours.getSelectionModel().getSelectedIndex()).getId_Co() ));
               
              
               
               
              
               
            };
        });
        
        
                 ObservableList <Cours> list;
                 try
                 {
                     list = bs.getCoursList();
                     Afficher_Id_C.setCellValueFactory(new PropertyValueFactory<>("Id_C"));
                     Afficher_Nom_C.setCellValueFactory(new PropertyValueFactory<>("Nom_C"));
                     Afficher_Date_C.setCellValueFactory(new PropertyValueFactory<>("Date_C"));
                     Afficher_Id_Co.setCellValueFactory(new PropertyValueFactory<>("Id_Co"));
                                       // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Cours> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Cours -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Cours.getNom_C().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (Cours.getDate_C().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                              
				} 
                                else if (String.valueOf(Cours.getId_C()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Cours> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tablecours.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tablecours.setItems(sortedData);
               
                     
                     
                 } catch (SQLException ex) {
            Logger.getLogger(Afficher_CoachingController.class.getName()).log(Level.SEVERE, null, ex);
        
       
                 }  

        
    }    
        

    @FXML
    private void Supprimer_Cours(ActionEvent event) {
        delete();
        tablecours.getItems().removeAll(tablecours.getSelectionModel().getSelectedItem());
        System.out.println(tablecours);
        tablecours.refresh();
    }

    @FXML
    private void Modifier_Cours(ActionEvent event) throws IOException {
        idxx= (Integer.toString(tablecours.getSelectionModel().getSelectedItem().getId_C()));
               
        FXMLLoader loader = new FXMLLoader();
       
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Update_Cours.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.show();
    }


    
}
