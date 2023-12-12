package tn.esprit.examenquiz.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examenquiz.Entity.Question;
import tn.esprit.examenquiz.Repository.QuestionRepository;
import tn.esprit.examenquiz.Repository.QuizRepository;
import tn.esprit.examenquiz.ServiceInterface.QuestionService;
import tn.esprit.examenquiz.Entity.Quiz;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionImpl implements QuestionService {
    QuestionRepository questionRepository;
    QuizRepository quizRepository;

    @Transactional
    @Override
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question, Integer idQuiz) {
        Quiz quiz = quizRepository.findById(idQuiz).orElse(null);
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }


}
