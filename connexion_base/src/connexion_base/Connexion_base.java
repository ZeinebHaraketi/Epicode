/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion_base;

import Services.CoursServices;
import entites.Cours;
import Tools.MaConnexion;
import Services.CoachingServices;
import entites.Coaching;
import java.util.List;

public class Connexion_base {

   
    public static void main(String[] args) {
         MaConnexion m = MaConnexion.getInstance();
              //CoursServices cs= new CoursServices();
       //Cours c =new Cours(10, "arije","ArijeHO",10);  
       //Cours c1 =new Cours(3, "farouha","waoula",16); 
        //cs.ajouterCours(c1);
        // cs.Updatecours(c1);
        //cs.supprimerCours(1);
        //System.out.println(cs.afficherCours());
       //List <Cours> Cours;
            CoachingServices co= new CoachingServices();
            Coaching co1 =new Coaching(6, "01/02/22",20.5f,30);
        // co.ajouterCoaching(co1);
         // System.out.println(co.afficherCoaching());
       // List <Coaching> Coaching;
        //co.Updatecoaching(co1);
           co.supprimerCoaching(6);
            
    }
    
}