package com.example.classes;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
    private List<Machine> machines;

    // Constructeur par défaut
    public Salle() {
        super();
    }

    // Constructeur avec paramètres (sans ID car auto-généré)
    public Salle(String code) {
        this.code = code;
    }

    // Constructeur avec paramètres (sans la liste des machines)
    public Salle(int id, String code) {
        this.id = id;
        this.code = code;
    }

    // Constructeur avec tous les paramètres
    public Salle(int id, String code, List<Machine> machines) {
        this.id = id;
        this.code = code;
        this.machines = machines;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    // Méthodes utilitaires pour gérer la relation bidirectionnelle
    public void addMachine(Machine machine) {
        this.machines.add(machine);
        machine.setSalle(this);
    }

    public void removeMachine(Machine machine) {
        this.machines.remove(machine);
        machine.setSalle(null);
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nombreMachines=" + (machines != null ? machines.size() : 0) +
                '}';
    }

    // Méthode hashCode()
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    // Méthode equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Salle other = (Salle) obj;
        if (id != other.id)
            return false;
        return true;
    }
}