package com.mycompany.platforme_telemedcine.Repository;

import com.mycompany.platforme_telemedcine.Models.ModuleIA;
import com.mycompany.platforme_telemedcine.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleIARepository extends JpaRepository<ModuleIA, Long> {
    ModuleIA findModuleIAById(long id);

    ModuleIA findByPatient(Patient patient);

}
