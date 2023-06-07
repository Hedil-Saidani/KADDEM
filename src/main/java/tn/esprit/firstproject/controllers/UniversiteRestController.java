package tn.esprit.firstproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.services.IUniversiteServices;

import java.util.List;

@Tag(name = "Gestion des universités")
@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteRestController {

    private  IUniversiteServices iUniversiteServices;

    @Operation(description ="Ajout d'une université")
    @PostMapping("/add")
    Universite addUniversite(@RequestBody Universite universite) {
        return iUniversiteServices.addOrUpdateUniversite(universite);
    }

    @Operation(description ="Suppression d'une université")
    @DeleteMapping("/delete/{id}")
    void deleteUniversite( @PathVariable("id") Integer idUniversite){

        iUniversiteServices.removeUniversite(idUniversite);
    }

    @Operation(description ="Modification d'une université")
    @PutMapping("/update")
    Universite UpdateUniversite(@RequestBody Universite universite){

        return iUniversiteServices.addOrUpdateUniversite(universite);
    }

    @Operation(description ="Affichage d'une université selon l'ID")
    @GetMapping("/get/{id}")
    Universite getUniversiteByID(@PathVariable("id") Integer idUniversite) {
        return iUniversiteServices.retrieveUniversite(idUniversite);
    }

    @Operation(description ="Affichage de la liste des universités")
    @GetMapping("/all")
    List<Universite> getUniversites(){
        return  iUniversiteServices.retrieveAllUniversites();
    }



    @Operation(description ="Affectation d'une université à un département")
    @PutMapping("/assignUnivToDep/{UniversiteId}/{DepartementId}")
    public void assignUniversiteToDepartement(@PathVariable ("UniversiteId")Integer idUniversite, @PathVariable("DepartementId") Integer idDepartement) {
        iUniversiteServices.assignUniversiteToDepartement(idUniversite, idDepartement);

    }

}
