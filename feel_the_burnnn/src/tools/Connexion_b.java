
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion_b {


    public String url="jdbc:mysql://localhost:3306/feel _the_burn";
    public String user="root";
    public String pwd="";
    public static Connexion_b cn;
    private Connection cnx;
    private Connexion_b(){
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static Connexion_b getInstance(){
        if(cn==null)
            cn= new Connexion_b();
            return cn;
      
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
