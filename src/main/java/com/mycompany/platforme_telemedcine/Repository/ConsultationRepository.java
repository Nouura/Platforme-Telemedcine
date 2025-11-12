package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.Consultation;
import com.mycompany.platforme_telemedcine.Models.Ordonance;
import com.mycompany.platforme_telemedcine.Models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    Consultation findConsultationById(long id);
    Consultation findConsultationByRendezVous(RendezVous rendezVous);
    Consultation findConsultationByOrdonance(Ordonance ordonance);
}
