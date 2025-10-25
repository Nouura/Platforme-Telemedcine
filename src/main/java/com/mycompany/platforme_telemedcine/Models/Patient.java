package com.mycompany.platforme_telemedcine.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;

@Entity
public class Patient extends User{
    private Date dataNaissance;
    private String adresse;
    private String antecedentsMedicaux;
    @OneToMany(mappedBy = "patient")
    List<Chatbot> chatbots;
    @OneToMany(mappedBy = "patient")
    List<RendezVous> rendezVous;
    @OneToMany(mappedBy = "patient")
    List<DossierMedical> dossierMedicals;
    @OneToMany(mappedBy = "patient")
    List<Paiement> paiements;

    // lezmni nes2el
    @OneToOne
    ModuleIA moduleIA;


    public ModuleIA getModuleIA() {
        return moduleIA;
    }

    public void setModuleIA(ModuleIA moduleIA) {
        this.moduleIA = moduleIA;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public List<DossierMedical> getDossierMedicals() {
        return dossierMedicals;
    }

    public void setDossierMedicals(List<DossierMedical> dossierMedicals) {
        this.dossierMedicals = dossierMedicals;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Date getDataNaissance() {
        return dataNaissance;
    }

    public void setDataNaissance(Date dataNaissance) {
        this.dataNaissance = dataNaissance;
    }

    public List<Chatbot> getChatbots() {
        return chatbots;
    }

    public void setChatbots(List<Chatbot> chatbots) {
        this.chatbots = chatbots;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }
}
