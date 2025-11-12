package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.Medecin;
import com.mycompany.platforme_telemedcine.Models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    RendezVous findRendezVousById(Long id);
    RendezVous findRendezVousByDate(Date date);
    RendezVous findByMedecin(Medecin medecin);
}
