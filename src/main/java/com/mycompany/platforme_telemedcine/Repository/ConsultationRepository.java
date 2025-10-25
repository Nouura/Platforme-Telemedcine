package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    Consultation findConsultationById(long id);
    Consultation findConsultationByDate(String date);
    Consultation findConsultationByRendezVous(String rendezVous);
    Consultation findConsultationByOrdonance(String ordonance);
}
