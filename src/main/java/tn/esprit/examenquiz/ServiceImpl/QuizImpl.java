package tn.esprit.examenquiz.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenquiz.Entity.Complexite;
import tn.esprit.examenquiz.Entity.Quiz;
import tn.esprit.examenquiz.Repository.CandidatRepository;
import tn.esprit.examenquiz.Repository.QuizRepository;
import tn.esprit.examenquiz.ServiceInterface.QuizService;
import tn.esprit.examenquiz.Entity.Candidat;

import java.util.List;

@AllArgsConstructor
@Service

public class QuizImpl implements QuizService {
    QuizRepository quizRepository;
    CandidatRepository candidatRepository;
    @Override
    public Quiz ajouterQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Transactional //pour l'affectation
    @Override
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) {
        Candidat c = candidatRepository.findById(idCandidat).orElse(null);
        Quiz q = quizRepository.findByTitleQuizLike(titreQuiz);

        // Set the CandidatList for the Quiz
       // q.getCondidatList().add(c);
        c.getQuizList().add(q);

        //quizRepository.save(q);

        //nbQuiz increment
        Integer nb = c.getNbQuiz();
        c.setNbQuiz(nb+1);
        candidatRepository.save(c);
        return q;
    }



    @Scheduled(fixedRate = 30000) // Scheduled to run every 30 seconds
    @Override
    public void recupererQuizPlusDifficile() {
        Quiz quizPlusDifficile = findMostDifficultQuiz();
        System.out.println("Quiz le plus difficile : " + quizPlusDifficile);
    }

    private Quiz findMostDifficultQuiz() {
        List<Quiz> allQuizzes = quizRepository.findAll();
        Quiz mostDifficultQuiz = null;
        int maxDifficultQuestions = 0;

        for (Quiz quiz : allQuizzes) {
            int difficultQuestionsCount = countDifficultQuestions(quiz);
            if (difficultQuestionsCount > maxDifficultQuestions) {
                maxDifficultQuestions = difficultQuestionsCount;
                mostDifficultQuiz = quiz;
            }
        }

        return mostDifficultQuiz;
    }

    private int countDifficultQuestions(Quiz quiz) {
        return (int) quiz.getQuestuionList().stream()
                .filter(question -> question.getComplexite() == Complexite.DEFFICILE)
                .count();
    }



}
