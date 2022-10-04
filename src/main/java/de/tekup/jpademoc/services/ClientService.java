package de.tekup.jpademoc.services;

import de.tekup.jpademoc.ctrls.ClientCtrl;
import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity insertInDB(ClientEntity client){
        return clientRepository.save(client);
    }

    public List<ClientEntity> getAllClients(){
        return (List<ClientEntity>) clientRepository.findAll();
    }

    public ClientEntity getClientByID(int id){
      Optional<ClientEntity> opt = clientRepository.findById(id);
      ClientEntity client = opt.
              orElseThrow(() -> new IllegalArgumentException("Client ID not found"));
      //opt.isPresent()? opt.get():throw new new IllegalArgumentException("Client ID not found");
        return client;
    }

    @PostConstruct
    public void init(){
        ClientEntity entity = new ClientEntity();
        entity.setNom("John");
        entity.setCin(160515264);
        this.insertInDB(entity);
    }
}
