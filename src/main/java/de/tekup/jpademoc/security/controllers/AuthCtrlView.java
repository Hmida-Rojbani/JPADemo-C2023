package de.tekup.jpademoc.security.controllers;

import de.tekup.jpademoc.security.services.UserService;
import de.tekup.jpademoc.security.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AuthCtrlView {

    private UserService userService;

    @GetMapping("/signup")
    public String registerUser(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }



    @PostMapping("/signup")
    public String registerUserPost(@Valid @ModelAttribute("user") User user
            , BindingResult result){
        if(result.hasErrors())
            return "signup";
        userService.registerUser(user);
        return "redirect:/";
    }

    @GetMapping("/signin")
    public String loginUser(){
        return "signin";
    }
}
