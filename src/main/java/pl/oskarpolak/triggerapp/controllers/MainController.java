package pl.oskarpolak.triggerapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("alerts", alertService.getAllAlerts());
        return "main";
    }

}
