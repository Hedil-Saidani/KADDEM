package tn.esprit.firstproject.services;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.*;

import tn.esprit.firstproject.repositories.ContratRepository;
import tn.esprit.firstproject.repositories.DepartementRepository;
import tn.esprit.firstproject.repositories.EquipeRepository;
import tn.esprit.firstproject.repositories.EtudiantRepository;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class EtudiantServicesImp  implements  IEtudiantServices{

    private  final  EtudiantRepository  etudiantRepository;
    private final DepartementRepository  departementRepository;

    private final EquipeRepository equipeRepository;

    private  final ContratRepository contratRepository;

    @Override
    public List<Etudiant> retrieveByOption(Option option) {
        return etudiantRepository.findByOption(option);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.getEtudiantsByDepartement_IdDepart(idDepartement);
    }




    @Override
     public Etudiant addOrUpdateEtudiant(Etudiant etudiant) {

         return etudiantRepository.save(etudiant);
     }

     @Override
     public void removeEtudiant(Integer idEtudiant) {

          etudiantRepository.deleteById(idEtudiant);
     }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }


    @Override
     public List<Etudiant> retrieveAllEtudiants() {
         List <Etudiant>  etudiants = new ArrayList<>();
         etudiantRepository.findAll().forEach(etudiants::add);
         return  etudiants;
     }

    public Etudiant assignEtToDep(Integer idE,Integer idDep){
        Etudiant e = etudiantRepository.findById(idE).orElse(null);
        Departement d =departementRepository.findById(idE).orElse(null);
        e.setDepartement(d);
        return  etudiantRepository.save(e);
    }


    public Etudiant assignEtToEquipe(Integer idE,Integer idEquipe){
        Etudiant e = etudiantRepository.findById(idE).orElse(null);
        Equipe eq  = equipeRepository.findById(idEquipe).orElse(null);
        if(e.getEquipes()==null){
            Set<Equipe> equipes = new HashSet<Equipe>();
            equipes.add(eq);
            e.setEquipes(equipes);
        }else {
            e.getEquipes().add(eq);
        }
        return  etudiantRepository.save(e);
    }

    @Override
    public void addAndAssignEtudToDep(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }


    //@Scheduled(cron ="*/15 * * * * *")

    public void hello(){
        log.debug("message debug");
        log.info("message info");
        log.error("error message");
        log.warn("warn message");



    }









}
