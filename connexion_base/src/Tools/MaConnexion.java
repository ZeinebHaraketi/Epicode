/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author WAEL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
       

public class MaConnexion {

    public String url;
/**
     *
     */
        public String user="root";
    public String pwd="";
    public static MaConnexion cn;
    private Connection cnx;
    private MaConnexion(){
        this.url = "jdbc:mysql://localhost:3306/feel_the_burn";
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static MaConnexion getInstance(){
        if(cn==null)
            cn= new MaConnexion();
            return cn;
      
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}