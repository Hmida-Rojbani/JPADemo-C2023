package de.tekup.jpademoc.services;

import de.tekup.jpademoc.entites.VoitureEntity;
import de.tekup.jpademoc.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoitureService {
    private VoitureRepository voitureRepository;

    public VoitureEntity addVoiture(VoitureEntity voiture){
        return  voitureRepository.save(voiture);
    }

    public List<VoitureEntity> getAllVoiture(){
        return (List<VoitureEntity>) voitureRepository.findAll();
    }

    public VoitureEntity getVoitureById(int id){
        return voitureRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Voiture Id Not Found"));
    }

}
