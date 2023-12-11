package tn.esprit.examenquiz.ServiceInterface;

import tn.esprit.examenquiz.Entity.Question;

public interface QuestionService {
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question, Integer idQuiz) ;
}
