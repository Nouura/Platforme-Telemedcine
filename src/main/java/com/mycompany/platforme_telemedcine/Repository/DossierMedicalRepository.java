package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.DossierMedical;
import com.mycompany.platforme_telemedcine.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    DossierMedical findDossierMedicalById(Long id);
    DossierMedical findDossierMedicalByPatient(Patient patient);
}
