/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author WAEL
 */
import entites.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Tools.MaConnexion;






public class CoursServices {
    Connection mc;
    PreparedStatement ste;

    public CoursServices() {
        mc=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterCours(Cours c){
        String sql;
        sql = "insert into cours(Nom_C,Date_C,Id_Co) Values(?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, c.getNom_C());
            ste.setString(2, c.getDate_C());
            ste.setInt(3, c.getId_Co());
            
            ste.executeUpdate();
            System.out.println("Cours Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
       public List<Cours> afficherCours(){
        List<Cours> courss = new ArrayList<>();
        String sql="select * from cours";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Cours c =new Cours();
                c.setId_C(rs.getInt("Id_C"));
                c.setNom_C(rs.getString("Nom_C"));
                c.setDate_C(rs.getString("Date_C"));
                 c.setId_Co(rs.getInt("Id_Co"));
                 
                 
                courss.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return courss;
    }    

   
     public void supprimerCours(int id){
        String sql = "DELETE from Cours where Id_C= '"+id+"' "; 
        try{

            
                    Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Cours supprimé avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
     
     public void Updatecours(Cours c){
         String sql = "UPDATE cours SET Nom_C=?, Date_C=?,Id_Co=? WHERE Id_C=?";
 try{
PreparedStatement statement = mc.prepareStatement(sql);
statement.setString(1, c.getNom_C());
statement.setString(2, c.getDate_C());
statement.setInt(3, c.getId_Co());
statement.setInt(4,c.getId_C());

 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("COURS MODIFIE!");
}

 } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
     }
     
 

}
