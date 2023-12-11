package tn.esprit.examenquiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examenquiz.Entity.Candidat;
import java.util.List;
import tn.esprit.examenquiz.Entity.Niveau;
@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Integer> {
    List<Candidat> findByQuizListSpecialiteAndNiveau(String specialite, Niveau niveau);

}
