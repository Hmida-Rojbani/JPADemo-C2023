package de.tekup.jpademoc.services;

import de.tekup.jpademoc.ctrls.ClientCtrl;
import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity insertInDB(ClientEntity client){
        return clientRepository.save(client);
    }
    @PostConstruct
    public void init(){
        ClientEntity entity = new ClientEntity();
        entity.setNom("John");
        entity.setCin(160515264);
        this.insertInDB(entity);
    }
}
