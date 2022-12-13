package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.entites.Location;
import de.tekup.jpademoc.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LocationCtrl {
    private LocationService locationService;
    @PostMapping("/locations/add/client/{clientId}/voiture/{voitureId}")
    public Location saveLocation(@RequestBody Location location,
                     @PathVariable("clientId") int idClient
                    , @PathVariable("voitureId") int idVoiture){
        return locationService.registerLocation(idClient,idVoiture,location);
    }

}
