package tn.esprit.firstproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.repositories.DetailEquipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailEquipeServicesImp  implements  IDetailEquipeServices{
    @Autowired
    private  final DetailEquipeRepository detailEquipeRepository;

    @Override
    public DetailEquipe addOrUpdateDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).orElse(null);

    }

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipes() {
        return (List<DetailEquipe>) detailEquipeRepository.findAll();
    }
}
