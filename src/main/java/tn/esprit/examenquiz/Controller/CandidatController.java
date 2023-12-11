package tn.esprit.examenquiz.Controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenquiz.Entity.Candidat;
import tn.esprit.examenquiz.Entity.Niveau;
import tn.esprit.examenquiz.ServiceInterface.CandidatService;

import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("Candidat")
public class CandidatController {
    CandidatService candidatService;

    @PostMapping("/addCandidat")
    public Candidat ajouterCandidat(@RequestBody Candidat candidat) {
        return candidatService.ajouterCandidat(candidat);
    }

    @GetMapping("/recupererCandidat/{specialite}/{niveau}")
    public List<Candidat> recupererCandidat(@PathVariable String specialite,
                                            @PathVariable Niveau niveau) {
        return candidatService.recupererCandidat(specialite, niveau);
    }
}
