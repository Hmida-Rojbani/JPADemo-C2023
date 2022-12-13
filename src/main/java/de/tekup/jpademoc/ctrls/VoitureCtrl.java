package de.tekup.jpademoc.ctrls;


import de.tekup.jpademoc.entites.VoitureEntity;
import de.tekup.jpademoc.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class VoitureCtrl {

    private VoitureService voitureService;
    @PostMapping("/voitures/save")
    public VoitureEntity saveVoiture(@RequestBody VoitureEntity voiture){
        return voitureService.addVoiture(voiture);
    }
    @GetMapping("/voitures")
    public List<VoitureEntity> getAllVoitures(){
        return voitureService.getAllVoiture();
    }

    @GetMapping("/voitures/{id}")
    public VoitureEntity getVoitureById(@PathVariable("id") int voitureId){
        return voitureService.getVoitureById(voitureId);
    }

    @GetMapping("/voitures/model/{model}")
    public List<VoitureEntity> getVoitureByModel(@PathVariable("model") String model){
        return voitureService.getAllByModel(model);
    }

    @GetMapping("/voitures/date/{dateD}/{dateF}")
    @ResponseBody
    public List<VoitureEntity> getVoitureByDateInterval(@PathVariable("dateD") String dateD
    ,@PathVariable("dateF") String dateF){
        LocalDate dateDebut = LocalDate.parse(dateD);
        LocalDate dateFin = LocalDate.parse(dateF);
        return voitureService.getVoituresByDateInterval(dateDebut,dateFin);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }
}
