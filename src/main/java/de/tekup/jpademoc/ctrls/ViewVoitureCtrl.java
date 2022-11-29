package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voitures/ui")
@AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;

    @GetMapping("/")
    public String diplayVoiture(Model model) {
        model.addAttribute("cars",voitureService.getAllVoiture());
        return "car";
    }
}
