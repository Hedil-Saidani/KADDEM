package tn.esprit.firstproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;
import tn.esprit.firstproject.services.IEtudiantServices;

import java.util.List;

@Tag(name = "Gestion des étudiants")
@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {

    private  final IEtudiantServices iEtudiantServices;


    public EtudiantRestController(IEtudiantServices iEtudiantServices) {

        this.iEtudiantServices = iEtudiantServices;
    }


    @Operation(description ="Affichage des étudiants By option")
    @GetMapping("/getByOption/{opt}")
   public List<Etudiant> retrieveByOption(@PathVariable("opt") Option option){
        return  iEtudiantServices.retrieveByOption(option);
    }

    @Operation(description ="Affichage des étudiants By ID departement")
    @GetMapping("/getByDepartement/{idD}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idD") Integer idDepartement) {
        return  iEtudiantServices.getEtudiantsByDepartement(idDepartement);
    }




    @Operation(description ="Ajout d'un étudiant")
    @PostMapping("/add")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {

        return iEtudiantServices.addOrUpdateEtudiant(etudiant);
    }

    @Operation(description ="Suppression d'un étudiant")
    @DeleteMapping("/delete/{id}")
    void deleteEtudiant( @PathVariable("id") Integer idEtudiant){

        iEtudiantServices.removeEtudiant(idEtudiant);
    }

    @Operation(description ="Modification d'un étudiant")
    @PutMapping("/update")
    Etudiant UpdateEtudiant(@RequestBody Etudiant etudiant){

        return iEtudiantServices.addOrUpdateEtudiant(etudiant);
    }

    @Operation(description ="Affichage d'un étudiant selon l'ID")
    @GetMapping("/get/{id}")
    Etudiant getEtudiantByID(@PathVariable("id") Integer idEtudiant) {
        return iEtudiantServices.retrieveEtudiant(idEtudiant);
    }

    @Operation(description ="Affichage de la liste des étudiants")
    @GetMapping("/all")
    List<Etudiant> getEtudiants(){
        return  iEtudiantServices.retrieveAllEtudiants();
    }


    @Operation(description ="Affectation d'un étudiant à un département")
    @PutMapping("/assignEtudToDep/{EtudiantId}/{depId}")
    @ResponseBody
    public void assignEtudToDep(@PathVariable("EtudiantId") Integer idEtudiant, @PathVariable("depId") Integer idDepart) {
      iEtudiantServices.assignEtToDep(idEtudiant, idDepart);
    }

    @Operation(description ="Affectation d'un étudiant à une équipe")
    @PutMapping("/assignEtudToEquipe/{EtudiantId}/{EquipeId}")
    @ResponseBody
    public void assignEtudToEquipe(@PathVariable("EtudiantId") Integer idEtudiant, @PathVariable("EquipeId") Integer idEquipe) {
        iEtudiantServices.assignEtToEquipe(idEtudiant, idEquipe);
    }

   @PutMapping("/addAndAssignEtudToDep")
   public void addAndAssignEtudToDep(@RequestBody Etudiant etudiant){
        iEtudiantServices.addAndAssignEtudToDep(etudiant);
   }


    
    
    








}