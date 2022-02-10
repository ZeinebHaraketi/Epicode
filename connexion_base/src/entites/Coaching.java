/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author WAEL
 */
public class Coaching {
    private int Id_S;
    private String Date_S;
    private Float Prix;
    private int Id_Co;

    public Coaching() {
    }

    public Coaching(int Id_S, String Date_S, Float Prix, int Id_Co) {
        this.Id_S = Id_S;
        this.Date_S = Date_S;
        this.Prix = Prix;
        this.Id_Co = Id_Co;
    }

    public int getId_S() {
        return Id_S;
    }

    public void setId_S(int Id_S) {
        this.Id_S = Id_S;
    }

    public String getDate_S() {
        return Date_S;
    }

    public void setDate_S(String Date_S) {
        this.Date_S = Date_S;
    }

    public Float getPrix() {
        return Prix;
    }

    public void setPrix(Float Prix) {
        this.Prix = Prix;
    }

    public int getId_Co() {
        return Id_Co;
    }

    public void setId_Co(int Id_Co) {
        this.Id_Co = Id_Co;
    }

    @Override
    public String toString() {
        return "Coaching{" + "Id_S=" + Id_S + ", Date_S=" + Date_S + ", Prix=" + Prix + ", Id_Co=" + Id_Co + '}';
    }
    
    
    
    
}
