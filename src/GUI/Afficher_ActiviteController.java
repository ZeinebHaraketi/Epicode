
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import Entities.Activite;
import Services.ActiviteService;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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


public class Afficher_ActiviteController implements Initializable {

    private TextField aff_act;
    @FXML
    private VBox vbox_act;
    @FXML
    private TableView<Activite> tab_act;
    @FXML
    private TableColumn<Activite,Integer> aff_id_a;
    @FXML
    private TableColumn<Activite, String> aff_nom_a;
    @FXML
    private TableColumn<Activite,Integer> aff_cat;
    @FXML
    private TableColumn<Activite,String> aff_type;
    @FXML
    private TableColumn<Activite, Integer> aff_id_e;
    @FXML
    private Button del_act;
    @FXML
    private Button upd_act;
    @FXML
    private Button sort_act;
    @FXML
    private Button refresh_act;
    @FXML
    private Button search_act;

    ObservableList<Activite> act;
    String query = null;
    PreparedStatement ste = null;
    ResultSet rs = null;
    Activite a= null;
    Connection connection;
    @FXML
    private Button fermer;
    private TextField upd_id;
    private TextField upd_nom;
    private TextField upd_cat;
    private TextField upd_type;
    private TextField upd_ide;
    
    public static String idxx;
    @FXML
    private TextField rech_act;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TO DO
        //loadData();
        
        ActiviteService as= new ActiviteService();
        
        tab_act.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
               aff_id_a.setText(String.valueOf(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getId_a()
               ));
               aff_nom_a.setText( as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getNom_a());
               aff_cat.setText(String.valueOf(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getCat_age()));
               aff_type.setText(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getType());
               aff_id_e.setText(String.valueOf(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getId_enfant() ));
               
            };
        });
        
        
                 ObservableList<Activite> list;
                 try
                 {
                     list = as.getActiviteList();
                     aff_id_a.setCellValueFactory(new PropertyValueFactory<>("id_a"));
                     aff_nom_a.setCellValueFactory(new PropertyValueFactory<>("nom_a"));
                     aff_cat.setCellValueFactory(new PropertyValueFactory<>("cat_age"));
                     aff_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                     aff_id_e.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
                     tab_act.setItems(list);
                     // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Activite> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rech_act.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Activite -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Activite.getNom_a().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (Activite.getType().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                              
				} 
                                else if (String.valueOf(Activite.getCat_age()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Activite> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tab_act.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tab_act.setItems(sortedData);
                     
                 } catch (SQLException ex) {
            Logger.getLogger(Afficher_ActiviteController.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
     
    }
    
    //------------------------ Afficher -----------------------------------------------//
    

    public void setAff_act(String aff_act) {
        this.aff_act.setText(aff_act);
    }

    Activite at = new Activite();
    ActiviteService as = new ActiviteService();
    
    
    //----------------------------- Bouton supprimer -----------------------------------//
    
    @FXML
    private void supprimer_act(ActionEvent event) {
        delete();
        tab_act.getItems().removeAll(tab_act.getSelectionModel().getSelectedItem());
        System.out.println(tab_act);
    }
    
    public void delete()
    {
       as.supprimerActivite(tab_act.getSelectionModel().getSelectedItem().getId_a());
        System.out.println(tab_act.getSelectionModel().getSelectedItem().getId_a());
    }

    
   
    @FXML
    private void sort_act(ActionEvent event) {
        tab_act.sort();
    }

    @FXML
    private void refresh_act(ActionEvent event) {
       
        tab_act.refresh();
    }

    @FXML
    private void search_act(ActionEvent event) {
        ActiviteService as = new ActiviteService();
        as.displayByID(a.getId_a());
        
        aff_id_a.setText(String.valueOf(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getId_a()
        ));
        aff_nom_a.setText( as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getNom_a());
        aff_cat.setText(String.valueOf(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getCat_age()));
        aff_type.setText(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getType());
        aff_id_e.setText(String.valueOf(as.liste2().get(tab_act.getSelectionModel().getSelectedIndex()).getId_enfant() ));
        
        
    }
    
    void setlist(String aff_act){
        this.aff_act.setText(aff_act);
        
        
        
    }

    @FXML
    private void liste_act(MouseEvent event) {
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void update_act(ActionEvent event) throws SQLException {
        
        Activite a = new Activite();
        ActiviteService as = new ActiviteService();
        if (!upd_id.getText().equals("") && !upd_nom.getText().equals("") && !upd_cat.getText().equals("") && !upd_type.getText().equals("") && !upd_ide.getText().equals("")){
          a.setId_a(Integer.parseInt(upd_id.getText()));
        a.setNom_a(upd_nom.getText());
        a.setCat_age(Integer.parseInt(upd_cat.getText()));
        a.setType(upd_type.getText());
        a.setId_enfant(Integer.parseInt(upd_ide.getText()));  
        
        as.update2(a);
            System.out.println(a.toString());
            
            upd_id.setText("");
            upd_nom.setText("");
            upd_cat.setText(null);
            upd_type.setText("");
            upd_ide.setText(null);
            
            tab_act.setItems(as.getActiviteslistnew());
            System.out.println(as.getActiviteslistnew());
        }
        
        
    }

    @FXML
    private void modifier_act(ActionEvent event) throws IOException {
     //idxx=tab_act.getSelectionModel().getSelectedItem().getId_a().toString();
    
     idxx= (Integer.toString(tab_act.getSelectionModel().getSelectedItem().getId_a()));
               
        FXMLLoader loader = new FXMLLoader();
       
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Modifier_Activite.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.show();
                tab_act.refresh();
    }

           

    
    
    
}
