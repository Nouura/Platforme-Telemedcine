package com.mycompany.platforme_telemedcine.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ModuleIA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeAnalyse;
    private Long probabilityMaladie;
    private String resultat;

    // lahne lezmni nes2el
    @JsonIgnore
    @OneToOne
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeAnalyse() {
        return typeAnalyse;
    }

    public void setTypeAnalyse(String typeAnalyse) {
        this.typeAnalyse = typeAnalyse;
    }

    public Long getProbabilityMaladie() {
        return probabilityMaladie;
    }

    public void setProbabilityMaladie(Long probabilityMaladie) {
        this.probabilityMaladie = probabilityMaladie;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
