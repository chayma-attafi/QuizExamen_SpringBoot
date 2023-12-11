package tn.esprit.examenquiz.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examenquiz.Entity.Quiz;
import tn.esprit.examenquiz.Repository.CandidatRepository;
import tn.esprit.examenquiz.Repository.QuizRepository;
import tn.esprit.examenquiz.ServiceInterface.QuizService;
import tn.esprit.examenquiz.Entity.Candidat;
@AllArgsConstructor
@Service
public class QuizImpl implements QuizService {
    QuizRepository quizRepository;
    CandidatRepository candidatRepository;
    @Override
    public Quiz ajouterQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) {
        Candidat c = candidatRepository.findById(idCandidat).orElse(null);
        Quiz q = quizRepository.findByTitleQuizLike(titreQuiz);

        // Set the CandidatList for the Quiz
        q.getCondidatList().add(c);

        //nbQuiz increment
        int nb = c.getNbQuiz()+1;
        c.setNbQuiz(nb);
        candidatRepository.save(c);

        return quizRepository.save(q);
    }


}
