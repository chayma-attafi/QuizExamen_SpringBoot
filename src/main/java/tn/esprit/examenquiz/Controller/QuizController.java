package tn.esprit.examenquiz.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenquiz.Entity.Quiz;
import tn.esprit.examenquiz.ServiceInterface.QuizService;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("Quiz")
public class QuizController {
    QuizService quizService;

    @PostMapping("/ajouterQuiz")
    public Quiz ajouterQuiz(@RequestBody Quiz quiz) {
        return quizService.ajouterQuiz(quiz);
    }

    @PostMapping("/affecterQuizCandidat/{idCandidat}/{titreQuiz}")
    public Quiz affecterQuizCandidat(@PathVariable String titreQuiz,
                                     @PathVariable Integer idCandidat) {
        return quizService.affecterQuizCandidat(titreQuiz, idCandidat);
    }
}
