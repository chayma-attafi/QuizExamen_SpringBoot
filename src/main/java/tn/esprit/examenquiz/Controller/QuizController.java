package tn.esprit.examenquiz.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenquiz.Entity.Quiz;
import tn.esprit.examenquiz.ServiceInterface.QuizService;

@AllArgsConstructor
@RestController
@RequestMapping("Quiz")
public class QuizController {
    QuizService quizService;

    @PostMapping("/ajouterQuiz")
    public Quiz ajouterQuiz(@RequestBody Quiz quiz) {
        return quizService.ajouterQuiz(quiz);
    }

    @PutMapping("/affecterQuizCandidat/{idCandidat}/{titreQuiz}")
    public Quiz affecterQuizCandidat(@PathVariable("titreQuiz") String titreQuiz,
                                     @PathVariable("idCandidat") Integer idCandidat) {
        return quizService.affecterQuizCandidat(titreQuiz, idCandidat);
    }

    @GetMapping("/recupererQuizPlusDifficile")
    public void recupererQuizPlusDifficile() {
        quizService.recupererQuizPlusDifficile();
    }
}
