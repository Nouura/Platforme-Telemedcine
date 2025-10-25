package com.mycompany.platforme_telemedcine.Controller;

import com.mycompany.platforme_telemedcine.Models.RapportFinancier;
import com.mycompany.platforme_telemedcine.Services.RapportFinancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RapportFinancierController {
    @Autowired
    private RapportFinancierService rapportFinancierService;

    @RequestMapping("/addRapportFinancier")
    public String addRapportFinancier(Model model) {
        RapportFinancier rapportFinancier = new RapportFinancier();
        model.addAttribute("rapportFinancierForm", rapportFinancier);
        return "add_RapportFinancier";
    }

    @RequestMapping(value = "/saveRapportFinancier", method = RequestMethod.POST)
    public String saveRapportFinancier(@ModelAttribute("rapportFinancierForm") RapportFinancier rapportFinancierForm, Model model) {
        rapportFinancierService.createRapportFinancier(rapportFinancierForm);
        return "redirect:/allrapportFinancier";
    }

    @RequestMapping("/allrapportFinancier")
    public  String listAllRapportFinancier(Model model) {
        List<RapportFinancier> rapportFinanciers = rapportFinancierService.getAllRapportFinanciers();
        model.addAttribute("rapportFinanciers", rapportFinanciers);
        return "allrapportFinancier";
    }

    @GetMapping("editRapportFinancier/{id}")
    public String showeditRapportFinancier(@PathVariable("id") Long id, Model model) {
        RapportFinancier rapportFinancier = rapportFinancierService.getRapportFinancierById(id);
        model.addAttribute("rapportFinancier", rapportFinancier);
        return "edit_RapportFinancier";
    }

    @PostMapping("/updateRapportFinancier/{id}")
    public String updateRapportFinancier(@PathVariable("id") Long id, Model model, RapportFinancier rapportFinancierForm, BindingResult result) {
        if (result.hasErrors()) {
            rapportFinancierForm.setId(id);
            return "edit_RapportFinancier";
        }
        rapportFinancierService.updateRapportFinancier(rapportFinancierForm);
        return "redirect:/allrapportFinancier";
    }

    @GetMapping("/deleteRapportFinanacier/{id}")
    public String deleteRapportFinancier(@PathVariable("id") Long id) {
        rapportFinancierService.deleteRapportFinancier(id);
        return "redirect:/allrapportFinancier";
    }

}
