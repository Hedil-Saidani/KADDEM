package tn.esprit.firstproject.services;


import tn.esprit.firstproject.entities.DetailEquipe;

import java.util.List;
import java.util.Optional;

public interface IDetailEquipeServices {
    DetailEquipe addOrUpdateDetailEquipe(DetailEquipe detailEquipe);
    void removeDetailEquipe (Integer idDetailEquipe);
    DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) ;
    List<DetailEquipe> retrieveAllDetailEquipes();
}
