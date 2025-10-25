package com.mycompany.platforme_telemedcine.Controller;
import com.mycompany.platforme_telemedcine.Models.RendezVous;
import com.mycompany.platforme_telemedcine.Services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RendezVousController {
    @Autowired
    RendezVousService rendezVousService;

    @RequestMapping("/addRendezVous")
    public String addRendezVous(Model model) {
        RendezVous rendezVous = new RendezVous();
        model.addAttribute("rendezVousForm", rendezVous);
        return "add_RendezVous";
    }

    @RequestMapping(value = "/saveRendezVous", method = RequestMethod.POST)
    public String saveRendezVous(@ModelAttribute("rendezvousForm") RendezVous rendezVous, Model model) {
        rendezVousService.createRendezvous(rendezVous);
        return "redirect:/allRendezVous";
    }

    @RequestMapping("/allRendezVous")
    public String listRendezVous(Model model) {
        List<RendezVous> rendezVous = rendezVousService.getAllRendezVous();
        model.addAttribute("rendezVous", rendezVous);
        return "all_RendezVous";
    }

    @GetMapping("/editRendezVous/{id}")
    public String showupdateRendezVous(@PathVariable("id") Long id, Model model) {
        RendezVous rendezVous = rendezVousService.getRendezVousById(id);
        model.addAttribute("rendezVous", rendezVous);
        return "update_RendezVous";
    }

    @PostMapping("/updateRendezVous/{id}")
    public String updateRendezVous(@PathVariable("id") Long id, RendezVous rendezVous, BindingResult result, Model model) {
        if (result.hasErrors()) {
            rendezVous.setId(id);
            return "update_RendezVous";
        }
        rendezVousService.updateRendezVous(rendezVous);
        return "redirect:/all_RendezVous";
    }

    @GetMapping("/deleteRendezVous/{id}")
    public String deleteRendezVous(@PathVariable("id") Long id) {
        rendezVousService.deleteRendezVous(id);
        return "redirect:/all_RendezVous";
    }
}
