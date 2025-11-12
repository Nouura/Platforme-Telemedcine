package com.mycompany.platforme_telemedcine.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;
    private Date datePaiement;
    private String status;
    private String factureURL;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private RapportFinancier rapportFinancier;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public Date getDatePaiement() { return datePaiement; }
    public void setDatePaiement(Date datePaiement) { this.datePaiement = datePaiement; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFactureURL() { return factureURL; }
    public void setFactureURL(String factureURL) { this.factureURL = factureURL; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public RapportFinancier getRapportFinancier() { return rapportFinancier; }
    public void setRapportFinancier(RapportFinancier rapportFinancier) { this.rapportFinancier = rapportFinancier; }
}
