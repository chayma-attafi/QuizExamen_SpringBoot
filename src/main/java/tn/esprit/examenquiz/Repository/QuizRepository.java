package tn.esprit.examenquiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examenquiz.Entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    Quiz findByTitleQuizLike(String titleQuiz);

}
