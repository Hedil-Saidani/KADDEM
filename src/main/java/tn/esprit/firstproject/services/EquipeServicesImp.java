package tn.esprit.firstproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Niveau;
import tn.esprit.firstproject.repositories.DetailEquipeRepository;
import tn.esprit.firstproject.repositories.EquipeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class EquipeServicesImp implements  IEquipeServices {

    @Autowired
    private  final EquipeRepository equipeRepository;
    private  final DetailEquipeRepository detailEquipeRepository;


    @Override
    public Equipe addOrUpdateEquipe(Equipe equipe) {

        return equipeRepository.save(equipe);

    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) equipeRepository.findAll();
    }


    @Override
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void Evoluer_Equipes() {
            List<Equipe> Equipe = retrieveAllEquipes();
            LocalDate localDate = LocalDate.now();
            for (int d = 0; d < Equipe.size(); d++) {
                int c = 0;
                Equipe eq = Equipe.get(d);
                List<Etudiant> etudiant = (List<Etudiant>) eq.getEtudiants();
                for (int j = 0; d < Equipe.size(); j++) {
                    Etudiant t = etudiant.get(j);
                    List<Contrat> ctr = (List<Contrat>) t.getContrats();
                    for (int k = 0; d < ctr.size(); k++) {
                        Contrat contrat = ctr.get(k);

                        long difference = localDate.getDayOfMonth() - contrat.getDateFinContrat().getTime();
                        long diffs = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
                        if (diffs >= 0) {
                            c++;
                        }
                    }
                    if (c > 3) {

                        if (eq.getNiveau() == Niveau.SENIOR) {
                            eq.setNiveau(Niveau.EXPERT);
                        }
                        if (eq.getNiveau() == Niveau.JUNIOR) {
                            eq.setNiveau(Niveau.SENIOR);
                        }
                    }
                }
            }
    }



    }




