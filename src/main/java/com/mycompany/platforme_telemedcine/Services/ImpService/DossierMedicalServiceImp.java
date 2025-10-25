package com.mycompany.platforme_telemedcine.Services.ImpService;

import com.mycompany.platforme_telemedcine.Models.DossierMedical;
import com.mycompany.platforme_telemedcine.Repository.DossierMedicalRepository;
import com.mycompany.platforme_telemedcine.Services.DossierMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierMedicalServiceImp implements DossierMedicalService {
    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;


    @Override
    public DossierMedical createDossierMedical(DossierMedical dossierMedical) {
        return dossierMedicalRepository.save(dossierMedical);
    }

    @Override
    public List<DossierMedical> getAllDossierMedical() {
        return dossierMedicalRepository.findAll();
    }

    @Override
    public DossierMedical getDossierMedicalById(Long id) {
        return dossierMedicalRepository.findDossierMedicalById(id);
    }

    @Override
    public void deleteDossierMedical(Long id) {
        this.dossierMedicalRepository.deleteById(id);
    }

    @Override
    public DossierMedical updateDossierMedical(DossierMedical dossierMedical) {
        return dossierMedicalRepository.save(dossierMedical);
    }
}
