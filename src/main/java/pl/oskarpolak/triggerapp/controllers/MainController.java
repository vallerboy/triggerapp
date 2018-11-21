package pl.oskarpolak.triggerapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.triggerapp.models.entities.AlertEntity;
import pl.oskarpolak.triggerapp.models.forms.AlertForm;
import pl.oskarpolak.triggerapp.models.services.AlertService;

@Controller
public class MainController {

    final AlertService alertService;

    @Autowired
    public MainController(AlertService alertService) {
        this.alertService = alertService;
    }


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("formAlert", new AlertForm());

        model.addAttribute("alerts", alertService.getAllAlerts());
        return "main";
    }

    @PostMapping("/")
    public String index(@ModelAttribute AlertForm alertForm){
        System.out.println(alertForm);
        return "redirect:/";
    }

}
