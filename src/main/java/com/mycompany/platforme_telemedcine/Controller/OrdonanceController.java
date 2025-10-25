package com.mycompany.platforme_telemedcine.Controller;
import com.mycompany.platforme_telemedcine.Models.Ordonance;
import com.mycompany.platforme_telemedcine.Services.OrdonanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrdonanceController {

    @Autowired
    OrdonanceService ordonanceService;

    @RequestMapping("/addOrdonance")
    public String addOrdonance(Model model) {
        Ordonance ordonance = new Ordonance();
        model.addAttribute("ordonanceForm", ordonance);
        return "addOrdonance";
    }

    @RequestMapping(value = "/saveOrdonance", method = RequestMethod.POST)
    public String saveOrdonance(@ModelAttribute("ordonanceForm") Model model, Ordonance ordonance) {
        ordonanceService.createOrdonance(ordonance);
        return "redirect:/allOrdonance";
    }

    @RequestMapping("allOrdonance")
    public String listOrdonance(Model model) {
        List<Ordonance> ordonances = ordonanceService.getAllOrdonance();
        model.addAttribute("ordonances", ordonances);
        return "all_Ordonance";
    }

    @GetMapping("/editOrdodnance/{id}")
    public String showupdateOrdonance(@PathVariable("id") Long id, Model model) {
        Ordonance ordonance = ordonanceService.findOrdonanceById(id);
        model.addAttribute("ordonance", ordonance);
        return "update_Ordonance";
    }

    @PostMapping("/updateOrdonance")
    public String updateOrdonance(@PathVariable("id") Long id, Model model, Ordonance ordonance, BindingResult result) {
        if (result.hasErrors()) {
            ordonance.setId(id);
            return "update_Ordonance";
        }
        ordonanceService.updateOrdonance(ordonance);
        return "redirect:/allOrdonance";
    }

    @GetMapping("/deleteOrdonance/{id}")
    public String deleteOrdonance(@PathVariable("id") Long id) {
        ordonanceService.deleteOrdonance(id);
        return "redirect:/allOrdonance";
    }
}
