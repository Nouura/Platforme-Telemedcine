package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.RapportFinancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportFinancierRepository extends JpaRepository<RapportFinancier,Long> {
    RapportFinancier findRapportFinancierById(Long id);
    RapportFinancier findRapportFinancierByAdministrateur(String administrateur);
}
