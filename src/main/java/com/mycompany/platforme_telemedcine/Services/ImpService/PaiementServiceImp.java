package com.mycompany.platforme_telemedcine.Services.ImpService;

import com.mycompany.platforme_telemedcine.Models.Paiement;
import com.mycompany.platforme_telemedcine.Repository.PaiementRepository;
import com.mycompany.platforme_telemedcine.Services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImp implements PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement getPaiementById(Long id) {
        return paiementRepository.findPaiementById(id);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        this.paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiementById(Long id) {
        this.paiementRepository.deleteById(id);
    }
}
