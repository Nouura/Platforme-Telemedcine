package com.mycompany.platforme_telemedcine.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class RapportFinancier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String priode;
    private double montantTotal;

    @ManyToOne
    private Administrateur administrateur;

    @OneToMany(mappedBy = "rapportFinancier")
    private List<Paiement> paiements;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPriode() { return priode; }
    public void setPriode(String priode) { this.priode = priode; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public Administrateur getAdministrateur() { return administrateur; }
    public void setAdministrateur(Administrateur administrateur) { this.administrateur = administrateur; }

    public List<Paiement> getPaiements() { return paiements; }
    public void setPaiements(List<Paiement> paiements) { this.paiements = paiements; }
}
