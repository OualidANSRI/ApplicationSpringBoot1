package com.test.achat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ligneoperations")
public class LigneOperation{

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_lp", nullable = false)
    private int id;


    //@JsonBackReference
    //@JsonProperty("op")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name ="id_operation", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Operation operation;

    //@JsonBackReference
    //@JsonProperty("cl")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="id_client", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;


    //@JsonProperty("statut")
    @Column(name="statut", nullable = false)
    private String statut;

    //@JsonProperty("assign")
    @Column(name="Assignation", nullable = false)
    private String assignation;


    public LigneOperation() {
    }
    public LigneOperation(Operation operation, Client client, String statut, String assignation)
    {
        this.operation = operation;
        this.client = client;
        this.statut = statut;
        this.assignation = assignation;
    }


    //@ModelAttribute("op")
    public Operation getOperation() {
        return operation;
    }

    //@ModelAttribute("op")
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    //@JsonProperty("cl")
    public Client getClient() {
        return client;
    }

    //@ModelAttribute("cl")
    public void setClient(Client client) {
        this.client = client;
    }

    //@ModelAttribute("st")
    public String getStatut() {
        return statut;
    }

    //@ModelAttribute("st")
    public void setStatut(String statut) {
        this.statut = statut;
    }
    //@ModelAttribute("assign")
    public String getAssignation() {
        return assignation;
    }

    //@ModelAttribute("assign")
    public void setAssignation(String assignation) {
        this.assignation = assignation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
