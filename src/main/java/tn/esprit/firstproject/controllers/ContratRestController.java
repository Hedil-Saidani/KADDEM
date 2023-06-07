package tn.esprit.firstproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.services.IContratServices;

import java.util.Date;
import java.util.List;

@Tag(name = "Gestion des contrats")
@RestController
@RequestMapping("/contrat")
@RequiredArgsConstructor
public class ContratRestController {


    private final IContratServices  iContratServices;

    @Operation(description ="Ajout d'un contrat")
    @PostMapping("/add")
    Contrat addContart(@RequestBody Contrat contrat) {
        return iContratServices.addOrUpdateContrat(contrat);
    }

    @Operation(description ="Suppression d'un contrat")
    @DeleteMapping("/delete/{id}")
    void deleteContrat( @PathVariable("id") Integer idContrat){

        iContratServices.removeContrat(idContrat);
    }

    @Operation(description ="Modification d'un contrat")
    @PutMapping("/update")
    Contrat UpdateContrat(@RequestBody Contrat contrat){

        return iContratServices.addOrUpdateContrat(contrat);
    }

    @Operation(description ="Affichage d'un contrat selon l'ID")
    @GetMapping("/get/{id}")
    Contrat getContratByID(@PathVariable("id") Integer idContrat) {
        return iContratServices.retrieveContrat(idContrat);
    }

    @Operation(description ="Affichage de la liste des contrats")
    @GetMapping("/all")
    List<Contrat> getContrats(){
        return  iContratServices.retrieveAllContrats();
    }


    @GetMapping("/nbContratsValides/{dateDebutContrat}/{dateFinContrat}")

    Integer nbContratsValides(@PathVariable("d1")    Date date1, @PathVariable("d2")  Date date2){
        return iContratServices.countByArchiveIsFalseAndDateDebutContratBetween(date1,date2);
    }




}




