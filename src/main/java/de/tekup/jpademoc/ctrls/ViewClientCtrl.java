package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients/ui")
@AllArgsConstructor
public class ViewClientCtrl {
    private ClientService clientService;

    @GetMapping("/display")
    public String displayClients(Model model){
        model.addAttribute("clients",clientService.getAllClients());
        return "clients-display";
    }

    @GetMapping("/add")
    public String addClients(Model model){
        model.addAttribute("client",new ClientEntity());
        return "clients-add";
    }

    @PostMapping("/add")
    public String addClientsPost(@Valid @ModelAttribute("client") ClientEntity client,
                                 BindingResult result){
        if (result.hasErrors()){
            return "clients-add";
        }
        System.out.println(client);
        clientService.insertInDB(client);

        return "redirect:/clients/ui/display";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
        return "redirect:/clients/ui/display";
    }

    @GetMapping("/update/{id}")
    public String updateClient(@PathVariable("id") int id, Model model){
        model.addAttribute("client",clientService.getClientByID(id));
        return "clients-add";
    }
}
