package com.test.achat.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cl", nullable = false, updatable = false)
    private int id;

    @OneToMany(mappedBy ="client" ,cascade={CascadeType.ALL},
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LigneOperation> lp;

    @Column(name="Nom")
    private String nom;
    @Column(name="Prenom")
    private String prenom;
    @Column(name="Email")
    private String email;
    @Column(name="Telephone")
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", numTel=" + numTel +
                '}';
    }
}
