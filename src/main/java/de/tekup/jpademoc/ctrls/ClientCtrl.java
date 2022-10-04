package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientCtrl {
    private ClientService clientService ;

    public ClientCtrl(ClientService clientService) {
        this.clientService = clientService;
    }

    //@RequestMapping(path="/clients/save",method = RequestMethod.POST)
    @PostMapping("/clients/save")
    @ResponseBody
    public ClientEntity saveClientToDB(@RequestBody ClientEntity client){
        return clientService.insertInDB(client);
    }
}
