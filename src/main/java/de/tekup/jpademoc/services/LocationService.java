package de.tekup.jpademoc.services;

import de.tekup.jpademoc.entites.ClientEntity;
import de.tekup.jpademoc.entites.Location;
import de.tekup.jpademoc.repos.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;
    private ClientService clientService;

    public Location registerLocation(int idClient, Location location){
        //retrieve client form DB
        ClientEntity client = clientService.getClientByID(idClient);
        //link client to location
        location.setClient(client);
        // insert location in DB
        return locationRepository.save(location);
    }

}
