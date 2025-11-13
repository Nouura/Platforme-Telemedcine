package com.mycompany.platforme_telemedcine.RestControllers;

import com.mycompany.platforme_telemedcine.Models.Medecin;
import com.mycompany.platforme_telemedcine.Services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecins")
public class MedecinRestController {

    @Autowired
    MedecinService medecinService;

    @PostMapping
    public ResponseEntity<Medecin> addMedecin(@RequestBody Medecin medecin) {
        try{
            Medecin med = medecinService.createMedecin(medecin);
            return new ResponseEntity<>(med, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Medecin>> getAllMedecins() {
        List<Medecin> meds = medecinService.getAllMedecin();
        if (meds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }return  new ResponseEntity<>(meds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable Long id) {
        Medecin med = medecinService.getMedecinById(id);
        if (med != null) {
            return new ResponseEntity<>(med, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medecin> updateMedecin(@PathVariable Long id, @RequestBody Medecin medecin) {
        Medecin med = medecinService.getMedecinById(id);
        if (med != null) {
            medecin.setId(id);
            medecinService.updateMedecin(medecin);
            return new ResponseEntity<>(medecin, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<HttpStatus> deleteMedecin(@PathVariable Long id) {
        try{
            medecinService.deleteMedecinById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
