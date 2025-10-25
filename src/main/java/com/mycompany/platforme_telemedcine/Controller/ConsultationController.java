package com.mycompany.platforme_telemedcine.Controller;

import com.mycompany.platforme_telemedcine.Models.Consultation;
import com.mycompany.platforme_telemedcine.Services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @RequestMapping("/addConsultation")
    public String addConsultation(Model model) {
        Consultation consultation = new Consultation();
        model.addAttribute("consultationForm", consultation);
        return "add_Consultation";
    }

    @RequestMapping(value = "/saveConsultation", method = RequestMethod.POST)
    public String saveConsultation(@ModelAttribute("consultationForm") Consultation consultation) {
        consultationService.createConsultation(consultation);
        return "redirect:/allConsultation";
    }

    @RequestMapping("/allConsultation")
    public String listConsultation(Model model) {
        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultations", consultations);
        return "all_Consultation";
    }

    @GetMapping("/editConsultation/{id}")
    public String showeditConsultation(@PathVariable("id") Long id, Model model) {
        Consultation consultation = consultationService.getConsultationById(id);
        model.addAttribute("consultationForm", consultation);
        return "edit_Consultation";
    }

    @PostMapping("/updateConsultation/{id}")
    public String updateConsultation(@PathVariable("id") Long id, Consultation consultation, Model model, BindingResult result) {
        if (result.hasErrors()) {
            consultation.setId(id);
            return "edit_Consultation";
        }
        consultationService.updateConsultation(consultation);
        return "redirect:/all_Consultation";
    }

    @GetMapping("/deleteConsultation")
    public String deleteConsultation(@RequestParam("id") Long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/allConsultation";
    }
}
