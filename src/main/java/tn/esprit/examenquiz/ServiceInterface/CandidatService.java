package tn.esprit.examenquiz.ServiceInterface;

import tn.esprit.examenquiz.Entity.Candidat;
import java.util.List;
import tn.esprit.examenquiz.Entity.Niveau;
public interface CandidatService {
    public Candidat ajouterCandidat(Candidat candidat) ;
    public List<Candidat> recupererCandidat (String specialite, Niveau niveau) ;
}
