package com.mycompany.platforme_telemedcine.Services.ImpService;

import com.mycompany.platforme_telemedcine.Models.RapportFinancier;
import com.mycompany.platforme_telemedcine.Repository.RapportFinancierRepository;
import com.mycompany.platforme_telemedcine.Services.RapportFinancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportFinancierServiceImp implements RapportFinancierService {

    @Autowired
    private RapportFinancierRepository rapportFinancierRepository;
    @Override
    public RapportFinancier createRapportFinancier(RapportFinancier rf) {
        return rapportFinancierRepository.save(rf);
    }

    @Override
    public RapportFinancier getRapportFinancierById(Long id) {
        return rapportFinancierRepository.findRapportFinancierById(id);
    }

    @Override
    public RapportFinancier updateRapportFinancier(RapportFinancier rf) {
        return rapportFinancierRepository.save(rf);
    }

    @Override
    public void deleteRapportFinancier(Long id) {
        this.rapportFinancierRepository.deleteById(id);
    }

    @Override
    public List<RapportFinancier> getAllRapportFinanciers() {
        return rapportFinancierRepository.findAll();
    }
}
