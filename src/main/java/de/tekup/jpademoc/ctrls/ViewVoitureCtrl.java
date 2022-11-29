package de.tekup.jpademoc.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voitures/ui")
public class ViewVoitureCtrl {

    @GetMapping("/")
    public String diplayVoiture() {
        return "car";
    }
}
