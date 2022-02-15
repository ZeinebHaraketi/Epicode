
package Entities;


public class Activite {
    private int id_a;
    private String nom_a;
    private int cat_age;
    private String type;
    private int id_enfant;

    public Activite() {
    }

    public Activite(int id_a, String nom_a, int cat_age, String type, int id_enfant) {
        this.id_a = id_a;
        this.nom_a = nom_a;
        this.cat_age = cat_age;
        this.type = type;
        this.id_enfant = id_enfant;
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getNom_a() {
        return nom_a;
    }

    public void setNom_a(String nom_a) {
        this.nom_a = nom_a;
    }

    public int getCat_age() {
        return cat_age;
    }

    public void setCat_age(int cat_age) {
        this.cat_age = cat_age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    @Override
    public String toString() {
        return "Activite{" + "id_a=" + id_a + ", nom_a=" + nom_a + ", cat_age=" + cat_age + ", type=" + type + ", id_enfant=" + id_enfant + '}';
    }

    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
