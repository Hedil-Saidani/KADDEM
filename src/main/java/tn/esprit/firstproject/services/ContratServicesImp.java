package tn.esprit.firstproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.repositories.ContratRepository;
import tn.esprit.firstproject.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContratServicesImp implements  IContratServices{

    private  final ContratRepository contratRepository;
    private  final EtudiantRepository etudiantRepository;


    @Override
    public Contrat addOrUpdateContrat(Contrat contrat) {

        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(Integer idContrat) {

        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {

        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {

        return (List<Contrat>) contratRepository.findAll();
    }


    @Override
    @Scheduled(cron = "0 0 1 ? * *")
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> contrat = retrieveAllContrats();
        LocalDate localDate = LocalDate.now();
        for (int d = 0; d < contrat.size(); d++) {
            Contrat S = contrat.get(d);
            long diff = localDate.getDayOfMonth() - S.getDateFinContrat().getTime();
            long diffs = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (diffs <= 0) {
                log.info("Contrat " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
                S.setArchive(true);
                contratRepository.save(S);
            } else if (diffs <= 15) {
                log.info("Contrat expiré " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
            }
        }
    }

    @Override
    public Integer countByArchiveIsFalseAndDateDebutContratBetween(Date startDate, Date endDate) {
        return contratRepository.countByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);
    }


}
