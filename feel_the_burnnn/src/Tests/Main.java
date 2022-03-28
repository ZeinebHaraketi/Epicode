
package Tests;

import entites.Blog;
import Services.BlogService;
import java.util.List;
import tools.Connexion_b;
import entites.Commentaire;
import Services.CommentaireService;


public class Main {

    
    public static void main(String[] args) {
        Connexion_b m = Connexion_b.getInstance();
        Blog b1=new Blog(21, "re", "Aziz","Date","Arije","Taswira","aa");
        Blog b2=new Blog(2,"r", "Azz","ate","Arije","Taswira","aa");
        Blog b3=new Blog(2,"aiiij", "ije","grissiaa","Aa","Taswira","bb");
        BlogService bs= new BlogService();
        int a=0;
      //  a=bs.calculer_nbblog("Aa");
        System.out.println("le nombre de blog de cet auteur est :");
        System.out.println(a);
        
       //bs.ajouterBlog(b3);
       //System.out.println(bs.afficherBlog());
        //List <Blog> Blogs= bs.afficherBlog();
        //bs.supprimerBlog(55);
        //bs.updateBlog(55,"k","a","z","e","r",13);
        
        
     
       
       //bs.ajouterBlog(b1);
       // bs.updateBlog(53,"k","a","z","e","r",13);
        //System.out.println(bs.afficherBlog());
        //List <Blog> Blogs= bs.afficherBlog();
        //bs.supprimerBlog(2);
        CommentaireService cs= new CommentaireService();
        Commentaire c=new Commentaire(10,"arije","grissiaa","hshhd","dddd","arije",56);
         Commentaire c1=new Commentaire(10,"krije","grissiaa","hshhd","dddd","arije",57);
         Commentaire c5=new Commentaire(10,"j","grissiaa","hshhd","dddd","arije",56);
          Commentaire c2=new Commentaire(10,"lrije","grissiaa","hshhd","dddd","arije",7);
         
        
       // cs.ajouterCommentaire(c5);
        //cs.updateCommentaire(6, "j", "kk", "grisiaa", "aaa", "eee");
       // System.out.println(cs.afficherCommentaire());
        //List <Commentaire> Commentaires= cs.afficherCommentaire();
        //System.out.println(cs.afficherCommentairerecherche(2));
        //List <Commentaire> Commentaires= cs.afficherCommentaire1();
       // cs.supprimerCommentaire(6);
        
    }
}


