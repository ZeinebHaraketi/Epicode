
package Services;
import Entities.Enfant;
import Tools.connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnfantServices {
    Connection mc;
    PreparedStatement ste;

    public EnfantServices() {
         mc=connexion.getInstance().getCnx();
    }
    
    // Fonction AJOUTER
    public void ajouterEnfant(Enfant e)
    {
      //enfant
        String sql ="insert into enfant(nom,prenom,age,sexe,photo,id_a) Values(?,?,?,?,?,?)";
        
        try{
            ste=mc.prepareStatement(sql);
            ste.setString(1, e.getNom());
           ste.setString(2,e.getPrenom());
           ste.setInt(3,e.getAge());
           ste.setString(4,e.getSexe());
           ste.setString(5,e.getPhoto());
           ste.setInt(6,e.getId_a());
           ste.executeUpdate();
           System.out.println("Enfant Ajouté avec succés !");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    public List<Enfant> afficherEnfant()
    {
        List<Enfant> enfants =  new ArrayList<>();
        String sql="select * from enfant";
        
        try{
            ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
          
          while(rs.next()){
                      Enfant e = new Enfant();
                      e.setId_enfant(rs.getInt("id_enfant"));
                      e.setNom(rs.getString("nom"));
                      e.setPrenom(rs.getString("prenom"));
                      e.setAge(rs.getInt("age"));
                      e.setSexe(rs.getString("sexe"));
                      e.setPhoto(rs.getString("photo"));
                      e.setId_a(rs.getInt("id_a"));
                      enfants.add(e);
                      System.out.println("ID_enfant : "+e.getId_enfant()+"\n Nom : "+e.getNom()+"\n Prenom : "+e.getPrenom()+"\n Age : "
                              +e.getAge()+"\n Sexe: "+e.getSexe()+"\n Photo: "+e.getPhoto()+"Id Activité: "+e.getId_a());
                      //System.out.println("Afficher avec succés !");
                  }
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
      return enfants;
    }
    
     public void supprimerEnfant(int id){
        String sql = "DELETE from Enfant where id_enfant= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Enfant supprimé avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
       }
     }
     public void modifierEnfant(int id, String nom,String prenom, int age, String sexe, String image, int ida){
       String sql= "UPDATE enfant SET nom='"+nom+"',prenom= '"+prenom+"' ,age= '"+age+"',sexe='"+sexe+"',photo='"+image+"' ,id_a='"+ida+"' where id_enfant = '"+id+"'";
       try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" enfant modifié avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
     
     
        
}
