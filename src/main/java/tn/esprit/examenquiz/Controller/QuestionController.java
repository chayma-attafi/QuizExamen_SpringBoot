package tn.esprit.examenquiz.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenquiz.Entity.Question;
import tn.esprit.examenquiz.ServiceInterface.QuestionService;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("Question")
public class QuestionController {

    QuestionService questionService;

    @PostMapping("/ajouterQuestEtRepEtAffecterQuestAQuiz/{idQuiz}")
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(@RequestBody Question question,
                                                          @PathVariable("idQuiz") Integer idQuiz) {
        return questionService.ajouterQuestEtRepEtAffecterQuestAQuiz(question, idQuiz);
    }
}
