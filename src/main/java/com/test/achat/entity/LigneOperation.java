package com.test.achat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "ligneoperations")
public class LigneOperation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lp", nullable = false, updatable = false)
    private int id;
    //@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name ="id_operation")
    private Operation operation;
    //@JsonBackReference
    @JsonProperty
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client")
    private Client client;


    @Column(name="Status")
    private String status;

    @Column(name="Assignation")
    private String assignation;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignation() {
        return assignation;
    }

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
