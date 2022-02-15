
package Services;
import Entities.Activite;
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

public class ActiviteService {
    Connection mc;
    PreparedStatement ste;

    public ActiviteService() {
         mc=connexion.getInstance().getCnx();
    }
    
    // Fonction AJOUTER
    public void ajouterActivite(Activite a)
    {
        String sql ="insert into activite(nom_a,cat_age,type,id_enfant) Values(?,?,?,?)";
        
        try
        {
           ste=mc.prepareStatement(sql);
           ste.setString(1, a.getNom_a());
           ste.setInt(2,a.getCat_age());
           ste.setString(3,a.getType());
           ste.setInt(4, a.getId_enfant());
           ste.executeUpdate();
           System.out.println("Activite Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    public List<Activite> afficherActivite()
    {
      List<Activite> activites =  new ArrayList<>();
      String sql="select * from activite";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Activite a = new Activite();
                      a.setId_a(rs.getInt("id_a"));
                      a.setNom_a(rs.getString("nom_a"));
                      a.setCat_age(rs.getInt("cat_age"));
                      a.setType(rs.getString("type"));
                      a.setId_enfant(rs.getInt("id_enfant"));
                      activites.add(a);
                      System.out.println("ID : "+a.getId_a()+"\n Nom : "+a.getNom_a()+"\n catégorie d'age : "+a.getCat_age()+"\n Type: "+a.getType()+"Id Enfant: "+a.getId_enfant());
                      //System.out.println("Afficher avec succés !");
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return activites;
    }
    
  
    
    public void updateActivite(int id, String nom, int idC, String typ, int ide){
       String sql= "UPDATE activite SET nom_a='"+nom+"',cat_age= '"+idC+"',type='"+typ+"',id_enfant='"+ide+"' where id_a = '"+id+"'";
       try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" activité modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    public void supprimerActivite(int id){
        String sql = "DELETE from Activite where id_a= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Activité supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    /*
    public List<Activite> afficherActivite(int id)
    {
      List<Activite> activites =  new ArrayList<>();
      String sql="select * from activite where id_a= '"+id+"' ";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Activite a = new Activite();
                      a.setId_a(rs.getInt("id_a"));
                      a.setNom_a(rs.getString("nom_a"));
                      a.setCat_age(rs.getInt("cat_age"));
                      a.setType(rs.getString("type"));
                      a.setId_enfant(rs.getInt("id_enfant"));
                      activites.add(a);
                      System.out.println("Recherche réussie ! ");
                      System.out.println("ID : "+a.getId_a()+"\n Nom : "+a.getNom_a()+"\n catégorie d'age : "+a.getCat_age()+"\n Type: "+a.getType()+"Id Enfant: "+a.getId_enfant());
                      //System.out.println("Afficher avec succés !");
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return activites;
    }*/
    
    /*
        public List<Activite> RechercherActivite(Activite A)
    {
        List<Activite> activites =  new ArrayList<>();
        String sql="select * from activite";
        if (activites.contains(A))
        {
           
           ActiviteService AS= new ActiviteService();
           AS.afficherActivite();
            System.out.println("Rechercher avec succés !");
        }
        else{
            System.out.println("Recherche échoué !");
        }
        
        return activites;
    }*/
    
    public List<Activite> afficherTrie()
    {
      List<Activite> activites =  new ArrayList<>();
      String sql="select * from activite order by cat_age desc";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Activite a = new Activite();
                      a.setId_a(rs.getInt("id_a"));
                      a.setNom_a(rs.getString("nom_a"));
                      a.setCat_age(rs.getInt("cat_age"));
                      a.setType(rs.getString("type"));
                      a.setId_enfant(rs.getInt("id_enfant"));
                      activites.add(a);
                      System.out.println("ID : "+a.getId_a()+"\n Nom : "+a.getNom_a()+"\n catégorie d'age : "+a.getCat_age()+"\n Type: "+a.getType()+"Id Enfant: "+a.getId_enfant());
                      //System.out.println("Afficher avec succés !");
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return activites;  
    }
    
    public List<Activite> SearchActivite(Activite A)
    {
        List<Activite> activites =  new ArrayList<>();
        
        for (Activite i : activites){
            if (i.equals(A))
            {
                activites.add(i);
                System.out.println(" Recherche avec succés !");
            }
            else {
               System.out.println(" Recherche échouée !"); 
            }
        }
        return activites; 
    }
}
