package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Equipe;

import java.util.List;
import java.util.Optional;

public interface IEquipeServices {

    Equipe addOrUpdateEquipe(Equipe equipe);
    void removeEquipe (Integer idEquipe);
    Equipe retrieveEquipe(Integer idEquipe) ;
    List<Equipe> retrieveAllEquipes();



    void Evoluer_Equipes();




}
