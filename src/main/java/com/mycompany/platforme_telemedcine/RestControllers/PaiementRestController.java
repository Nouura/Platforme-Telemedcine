package com.mycompany.platforme_telemedcine.RestControllers;

import com.mycompany.platforme_telemedcine.Models.Paiement;
import com.mycompany.platforme_telemedcine.Models.Patient;
import com.mycompany.platforme_telemedcine.Models.RapportFinancier;
import com.mycompany.platforme_telemedcine.Services.PaiementService;
import com.mycompany.platforme_telemedcine.Services.PatientService;
import com.mycompany.platforme_telemedcine.Services.RapportFinancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiement")
public class PaiementRestController {

    @Autowired
    PaiementService paiementService;

    @Autowired
    PatientService patientService;

    @Autowired
    RapportFinancierService rapportFinancierService;


    @PostMapping("/add/{patientId}")
    public ResponseEntity<Paiement> addPaiement(@PathVariable Long patientId, @RequestBody Paiement paiement) {
        try {
            Patient p1 = patientService.getPatientById(patientId);
            paiement.setPatient(p1);
            Paiement paiement1 = paiementService.createPaiement(paiement);
            return new ResponseEntity<>(paiement1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add2/{patientId}/{RapportFinanicierId}")
    public ResponseEntity<Paiement> addPaiement2(@PathVariable Long patientId, @PathVariable Long RapportFinanicierId, @RequestBody Paiement paiement) {
        try {
            Patient p1 = patientService.getPatientById(patientId);
            RapportFinancier f1 = rapportFinancierService.getRapportFinancierById(RapportFinanicierId);
            paiement.setRapportFinancier(f1);
            paiement.setPatient(p1);
            Paiement paiement1 = paiementService.createPaiement(paiement);
            return new ResponseEntity<>(paiement1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        List<Paiement> paiements = paiementService.getAllPaiements();
        if (paiements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paiements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        Paiement paiement = paiementService.getPaiementById(id);
        if (paiement!=null) {
            return new ResponseEntity<>(paiement, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        Paiement p1 = paiementService.getPaiementById(id);
        if (p1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } if (paiement.getMontant()!= null){
            p1.setMontant(paiement.getMontant());
        }
        if (paiement.getDatePaiement() != null) {
            p1.setDatePaiement(paiement.getDatePaiement());
        }
        if(paiement.getStatus()!= null){
            p1.setStatus(paiement.getStatus());
        }
        if(paiement.getFactureURL()!= null){
            p1.setFactureURL(paiement.getFactureURL());
        }

        Paiement updated = paiementService.updatePaiement(p1);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paiement> deletePaiement(@PathVariable Long id) {
        try{
            paiementService.deletePaiementById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
