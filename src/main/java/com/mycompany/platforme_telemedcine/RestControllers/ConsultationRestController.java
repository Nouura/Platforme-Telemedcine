package com.mycompany.platforme_telemedcine.RestControllers;

import com.mycompany.platforme_telemedcine.Models.Consultation;
import com.mycompany.platforme_telemedcine.Models.Ordonance;
import com.mycompany.platforme_telemedcine.Models.RendezVous;
import com.mycompany.platforme_telemedcine.Services.ConsultationService;
import com.mycompany.platforme_telemedcine.Services.OrdonanceService;
import com.mycompany.platforme_telemedcine.Services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationRestController {

    @Autowired
    ConsultationService consultationService;

    @Autowired
    RendezVousService rendezVousService;

    @Autowired
    OrdonanceService ordonanceService;

    @PostMapping("/add/{rendezvousId}")
    public ResponseEntity<Consultation> addConsultation(
            @RequestBody Consultation consultation,
            @PathVariable Long rendezvousId) {
        RendezVous rendezVous = rendezVousService.getRendezVousById(rendezvousId);
        consultation.setRendezVous(rendezVous);

        Consultation saved = consultationService.createConsultation(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/add2/{ordonanceId}/{rendezvousId}")
    public ResponseEntity<Consultation> addConsultationWithOrdonance(
            @RequestBody Consultation consultation,
            @PathVariable Long ordonanceId,
            @PathVariable Long rendezvousId) {

        Ordonance ordonnance = ordonanceService.findOrdonanceById(ordonanceId);
        RendezVous rendezVous = rendezVousService.getRendezVousById(rendezvousId);

        consultation.setOrdonance(ordonnance);
        consultation.setRendezVous(rendezVous);

        Consultation saved = consultationService.createConsultation(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        List<Consultation> consultations = consultationService.getAllConsultations();
        if (consultations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable Long id) {
        Consultation consultation = consultationService.getConsultationById(id);
        if (consultation != null) {
            return new ResponseEntity<>(consultation, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        Consultation c1 = consultationService.getConsultationById(id);
        if (c1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (consultation.getDate() != null) {
            c1.setDate(consultation.getDate());
        }
        if (consultation.getNotes() != null) {
            c1.setNotes(consultation.getNotes());
        }
        if (consultation.getVideoURL() != null) {
            c1.setVideoURL(consultation.getVideoURL());
        }
        Consultation updated = consultationService.updateConsultation(c1);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteConsultation(@PathVariable Long id) {
        try{
            consultationService.deleteConsultation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
