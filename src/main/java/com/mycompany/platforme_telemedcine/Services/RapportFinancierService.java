package com.mycompany.platforme_telemedcine.Services;

import com.mycompany.platforme_telemedcine.Models.RapportFinancier;

import java.util.List;

public interface RapportFinancierService {
    RapportFinancier createRapportFinancier(RapportFinancier rf);
    RapportFinancier getRapportFinancierById(Long id);
    RapportFinancier updateRapportFinancier(RapportFinancier rf);
    void deleteRapportFinancier(Long id);
    List<RapportFinancier> getAllRapportFinanciers();
}
