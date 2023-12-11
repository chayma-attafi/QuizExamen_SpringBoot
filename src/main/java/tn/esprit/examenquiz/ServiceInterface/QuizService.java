package tn.esprit.examenquiz.ServiceInterface;

import tn.esprit.examenquiz.Entity.Quiz;

public interface QuizService {
    public Quiz ajouterQuiz(Quiz quiz) ;
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) ;
}
