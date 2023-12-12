package tn.esprit.examenquiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examenquiz.Entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
