package com.mycompany.platforme_telemedcine.Models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ordonance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medecaments;
    private Date dateCreation;
    private Boolean valideeParIA;

    @OneToOne
    Consultation consultation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedecaments() {
        return medecaments;
    }

    public void setMedecaments(String medecaments) {
        this.medecaments = medecaments;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getValideeParIA() {
        return valideeParIA;
    }

    public void setValideeParIA(Boolean valideeParIA) {
        this.valideeParIA = valideeParIA;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
