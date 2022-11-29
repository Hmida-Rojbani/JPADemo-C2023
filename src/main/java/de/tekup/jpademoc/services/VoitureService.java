package de.tekup.jpademoc.services;

import de.tekup.jpademoc.entites.VoitureEntity;
import de.tekup.jpademoc.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VoitureService {
    private VoitureRepository voitureRepository;

    public VoitureEntity addVoiture(VoitureEntity voiture){
        return  voitureRepository.save(voiture);
    }

    public List<VoitureEntity> getAllVoiture(){
        return (List<VoitureEntity>) voitureRepository
                .findAll();
    }

    public VoitureEntity getVoitureById(int id){
        return voitureRepository.findById(id)
        .orElseThrow(()->
        new IllegalArgumentException("Voiture Id Not Found"));
    }

    public List<VoitureEntity> getAllByModel(String model){
        return voitureRepository.findByModel(model);
    }

    public List<VoitureEntity> getVoituresByDateInterval(LocalDate dateDebut
            , LocalDate dateFin){
        return voitureRepository.locateByInterval(dateDebut,dateFin);
    }


}
