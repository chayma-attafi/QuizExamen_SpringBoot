package tn.esprit.examenquiz.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examenquiz.Entity.Question;
import tn.esprit.examenquiz.Repository.QuestionRepository;
import tn.esprit.examenquiz.Repository.QuizRepository;
import tn.esprit.examenquiz.ServiceInterface.QuestionService;
import tn.esprit.examenquiz.Entity.Quiz;
@AllArgsConstructor
@Service
public class QuestionImpl implements QuestionService {
    QuestionRepository questionRepository;
    QuizRepository quizRepository;
    @Override
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question, Integer idQuiz) {
        Quiz q = quizRepository.findById(idQuiz).orElse(null);
        return null;
    }

}
