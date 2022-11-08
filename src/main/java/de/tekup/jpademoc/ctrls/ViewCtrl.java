package de.tekup.jpademoc.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ViewCtrl {

    @GetMapping({"/","/welcome/index"})
    public String landingPage(Model model){
        String today = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        model.addAttribute("date",today);
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
}
