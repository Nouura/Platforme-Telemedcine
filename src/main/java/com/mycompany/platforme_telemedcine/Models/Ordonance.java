package com.mycompany.platforme_telemedcine.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Ordonance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> medicaments;
    private Date dateCreation;
    private Boolean valideeParIA;

    @JsonIgnore
    @OneToOne
    Consultation consultation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<String> medicaments) {
        this.medicaments = medicaments;
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
