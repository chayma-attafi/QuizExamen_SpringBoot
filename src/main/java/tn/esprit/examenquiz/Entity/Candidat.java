package tn.esprit.examenquiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Candidat")
public class Candidat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCandidat")
    Integer idReponse;

    String nom,prenom;
    Integer nbQuiz;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany
    List<Quiz> quizList;
}
