package de.tekup.jpademoc.ctrls;

import de.tekup.jpademoc.entites.Location;
import de.tekup.jpademoc.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class LocationCtrl {
    private LocationService locationService;
    @PostMapping("/locations/add/client/{clientId}/voiture/{voitureId}")
    @ResponseBody
    public Location saveLocation(@RequestBody Location location,
                     @PathVariable("clientId") int idClient
                    , @PathVariable("voitureId") int idVoiture){
        return locationService.registerLocation(idClient,idVoiture,location);
    }

}
