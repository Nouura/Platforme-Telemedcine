package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.Consultation;
import com.mycompany.platforme_telemedcine.Models.Ordonance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrdonanceRepository extends JpaRepository<Ordonance, Long> {
    Ordonance findOrdonanceById(long id);

    Ordonance findOrdonanceByDateCreation(Date dateCreation);

    Ordonance findByConsultation(Consultation consultation);
}
