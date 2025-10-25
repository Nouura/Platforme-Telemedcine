package com.mycompany.platforme_telemedcine.Models;

import jakarta.persistence.*;

@Entity
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String historique;
    private String resultatExamens;
    @ManyToOne
    Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    public String getResultatExamens() {
        return resultatExamens;
    }

    public void setResultatExamens(String resultatExamens) {
        this.resultatExamens = resultatExamens;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
