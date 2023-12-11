package tn.esprit.examenquiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Quiz")
public class Quiz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuiz")
    Integer idQuiz;

    String titleQuiz,specialite;
    LocalDate dateQuiz;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "quiz")
    List<Question> questuionList;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy ="quizList")
    List<Candidat> condidatList;

}
