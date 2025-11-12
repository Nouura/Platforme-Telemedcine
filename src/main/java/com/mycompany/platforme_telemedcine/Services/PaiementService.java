package com.mycompany.platforme_telemedcine.Services;

import com.mycompany.platforme_telemedcine.Models.Paiement;

import java.util.List;

public interface PaiementService {
    Paiement getPaiementById(Long id);
    List<Paiement> getAllPaiements();
    Paiement createPaiement(Paiement paiement);
    Paiement updatePaiement(Paiement paiement);
    void deletePaiementById(Long id);
}
