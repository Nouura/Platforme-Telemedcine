package com.mycompany.platforme_telemedcine.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Administrateur extends User {
    @OneToMany(mappedBy = "administrateur")
    List<RapportFinancier> rapportFinanciers;

    public List<RapportFinancier> getRapportFinanciers() {
        return rapportFinanciers;
    }

    public void setRapportFinanciers(List<RapportFinancier> rapportFinanciers) {
        this.rapportFinanciers = rapportFinanciers;
    }
}
