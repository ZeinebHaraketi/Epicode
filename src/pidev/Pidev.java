
package pidev;

import Entities.Activite;
import Entities.Enfant;
import Services.ActiviteService;
import Services.EnfantServices;
import Tools.connexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pidev {
    /*
    static String url ="jdbc:mysql://localhost:3306/pidev";
    static String user="root";
    static String pwd="";
    public static connexion con;
    private Connection cnx;
    */
    public static void main(String[] args) {
     // con.getCnx();
     
     //-------------------------------- Activité -------------------------------------------------//
        Activite A1= new Activite(1,"Zumba",5,"Sport",1);
        Activite A2= new Activite(2,"Cardio",12,"Sport",2);
        Activite A3= new Activite(3,"Devoir",7,"Education",3);
        Activite A4= new Activite(4,"Devoir",7,"Education",4);
        Activite A5 = new Activite(5,"mmmm", 10, "aaa", 20);
        
        List<Activite> act= new ArrayList<>();
        ActiviteService AS= new ActiviteService();
        //AS.ajouterActivite(A5);
        //act= AS.afficherActivite();
       // AS.updateActivite(11,"aaa", 20, "kkk", 20);
       //AS.supprimerActivite(11);
        //AS.ajouterActivite(A1);
        //AS.ajouterActivite(A2);
        //AS.ajouterActivite(A4);
         //act=AS.afficherActivite();
        //AS.ajouterActivite(A3);
       //AS.updateActivite(8, "Zeineb", 10, "nom", 2); // Ca marche !
       //AS.supprimerActivite(7); //Ca marche !
       //act= AS.afficherActivite(8); //CA MARCHE !
       //act = AS.RechercherActivite(A4); //CA MARCHE PAS !!!
       //act = AS.afficherTrie(); // TRIER MARCHE !!!
       //act= AS.SearchActivite(A4);
       
       
       //------------------------------ Enfant -------------------------------------------------//
       
       Enfant E1 = new Enfant(1,"Farah","Rekik",16,"femme","farah.png",1);
       Enfant E2 = new Enfant(2,"Wael","Belgaied",5,"Homme","willy.png",2);

       EnfantServices ES= new EnfantServices();
       //ES.ajouterEnfant(E1); //Ca marche!
       //ES.ajouterEnfant(E2);
     // List<Enfant> list_enfant= ES.afficherEnfant(); //Ca marche !
     //  ES.supprimerEnfant(2); //Ca marche !
     //ES.modifierEnfant(3, "Wael","Belgaied",21,"Homme","wael.png",2); //Ca marche !
        
      
    }
    
}
