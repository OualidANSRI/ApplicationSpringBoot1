package com.test.achat.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_op", nullable = false, updatable = false)
    private int id;


    @OneToMany(mappedBy ="operation" ,cascade={CascadeType.ALL},
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LigneOperation> lp;

    @Column(name ="Libelle")
    private String libelle;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

}
