package tn.esprit.examenquiz.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examenquiz.Entity.Candidat;
import tn.esprit.examenquiz.Entity.Niveau;
import tn.esprit.examenquiz.Repository.CandidatRepository;
import tn.esprit.examenquiz.ServiceInterface.CandidatService;

import java.util.List;

@AllArgsConstructor
@Service
public class CandidatImpl implements CandidatService {
    CandidatRepository candidatRepository;
    @Override
    public Candidat ajouterCandidat(Candidat candidat) {

        return candidatRepository.save(candidat);
    }

    @Override
    public List<Candidat> recupererCandidat(String specialite, Niveau niveau) {
        return candidatRepository.findByQuizListSpecialiteAndNiveau(specialite,niveau);
    }
}
