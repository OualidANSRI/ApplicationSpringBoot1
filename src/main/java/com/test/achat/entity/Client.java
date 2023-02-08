package com.test.achat.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cl", nullable = false)
    private int id;

    @OneToMany(mappedBy ="client" ,cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<LigneOperation> lp;

    @Column(name="Nom", nullable = false)
    private String nom;
    @Column(name="Prenom", nullable = false)
    private String prenom;
    @Column(name="Email", nullable = false)
    private String email;
    @Column(name="Telephone",nullable = false)
    private String numTel;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public String getNumTel() {
        return numTel;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

}
