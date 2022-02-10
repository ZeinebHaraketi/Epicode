/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entites.Coaching;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Tools.MaConnexion;
public class CoachingServices {
    Connection mc;
    PreparedStatement ste;

    public CoachingServices() {
        mc=MaConnexion.getInstance().getCnx();
    }
    public void ajouterCoaching(Coaching co){
        String sql;
        sql = "insert into coaching(Date_S,Prix,Id_Co) Values(?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, co.getDate_S());
            ste.setFloat(2, co.getPrix());
            ste.setInt(3, co.getId_Co());
            
            ste.executeUpdate();
            System.out.println("Coaching Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
       public List<Coaching> afficherCoaching(){
        List<Coaching> coachings = new ArrayList<>();
        String sql="select * from coaching";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Coaching co =new Coaching();
                co.setId_S(rs.getInt("Id_S"));
                co.setDate_S(rs.getString("Date_S"));
                co.setPrix(rs.getFloat("Prix"));
                 co.setId_Co(rs.getInt("Id_Co"));
                 
                 
                coachings.add(co);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return coachings;
    } 
       public void Updatecoaching(Coaching co){
         String sql = "UPDATE coaching SET Date_s=?, Prix=?,Id_Co=? WHERE Id_S=?";
 try{
PreparedStatement statement = mc.prepareStatement(sql);
statement.setString(1, co.getDate_S());
statement.setFloat(2, co.getPrix());
statement.setInt(3, co.getId_Co());
statement.setInt(4, co.getId_S());
 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("COACHING MODIFIE!");
}

 } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
     }
       public void supprimerCoaching(int Id_S){
        String sql = "DELETE from coaching where Id_S= '"+Id_S+"' "; 
        try{

            
                    Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Coaching supprimé avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
}
