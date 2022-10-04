package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping ("/clients")
    @ResponseBody
    public List<ClientEntity> getFormDB(){
        return clientService.getAllClients();
    }

    @GetMapping ("/clients/{clientId}")
    @ResponseBody
    public ClientEntity getFormDBByID(@PathVariable("clientId") int id){
           return clientService.getClientByID(id);
     }

     @ExceptionHandler(IllegalArgumentException.class)
     @ResponseBody
    public String handleIllArgException(IllegalArgumentException e){
        return "Error in get form DB : "+e.getMessage();
    }
}
