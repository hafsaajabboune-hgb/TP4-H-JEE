package com.example.classes;

import java.util.Date;
import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "findBetweenDateNative", query = "select * from machine where dateAchat between :d1 and :d2", resultClass = Machine.class)
@NamedQuery(name = "findBetweenDate", query = "from Machine where dateAchat between :d1 and :d2")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    private Salle salle;

    // Constructeur par défaut
    public Machine() {
        super();
    }

    // Constructeur avec paramètres (sans ID car auto-généré)
    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }

    // Constructeur avec tous les paramètres
    public Machine(int id, String ref, Date dateAchat, Salle salle) {
        this.id = id;
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    // Méthode toString() pour un affichage facile
    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", dateAchat=" + dateAchat +
                ", salle=" + (salle != null ? salle.getId() : "null") +
                '}';
    }

    // Méthode hashCode() et equals() pour la comparaison d'objets
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Machine other = (Machine) obj;
        if (id != other.id)
            return false;
        return true;
    }
}