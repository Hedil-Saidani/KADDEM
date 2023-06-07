package tn.esprit.firstproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.DepartementRepository;
import tn.esprit.firstproject.repositories.UniversiteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UniversiteServicesImp implements  IUniversiteServices {

    @Autowired
    private  final UniversiteRepository universiteRepository;
    private  final DepartementRepository departementRepository;


    @Override
    public Universite addOrUpdateUniversite(Universite universite) {

        return universiteRepository.save(universite);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
         universiteRepository.deleteById(idUniversite);

    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> retrieveAllUniversites() {

        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
            Universite u = universiteRepository.findById(idUniversite).orElse(null);
            Departement d = departementRepository.findById(idDepartement).orElse(null);
            if(u.getDepartements()==null){
            Set<Departement> departements = new HashSet<Departement>();
            departements.add(d);
            u.setDepartements(departements);
            }else {
            u.getDepartements().add(d);
           }
            universiteRepository.save(u);
        }


}
