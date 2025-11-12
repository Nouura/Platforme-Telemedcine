package com.mycompany.platforme_telemedcine.RestControllers;

import com.mycompany.platforme_telemedcine.Models.Administrateur;
import com.mycompany.platforme_telemedcine.Services.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
public class AdministrateurRestController {

    @Autowired
    AdministrateurService administrateurService;

    @PostMapping
    public ResponseEntity<Administrateur> addAdministrateur(@RequestBody Administrateur administrateur) {
        try {
            Administrateur admin = administrateurService.createAdministrateur(administrateur);
            return new ResponseEntity<>(admin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur administrateur) {
        Administrateur admin = administrateurService.getAdministrateurById(id);
        if (admin != null) {
            administrateur.setId(id);
            administrateurService.updateAdministrateur(admin);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Administrateur> deleteAdministrateur(@PathVariable Long id) {
        try{
            administrateurService.deleteAdministrateurById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
