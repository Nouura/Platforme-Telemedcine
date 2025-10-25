package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.Paiement;
import com.mycompany.platforme_telemedcine.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Paiement findPaiementById(long id);
    Paiement findPaiementByDatePaiement(Date datePaiement);
    Paiement findPaiementByPatient(Patient patient);

}
