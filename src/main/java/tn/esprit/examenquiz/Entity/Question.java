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
@Table(name = "Question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestion")
    Integer idQuestion;

    String libelleQ;

    @Enumerated(EnumType.STRING)
    Complexite complexite;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    //@JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Quiz quiz;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    //@JsonIgnore
    @ToString.Exclude
    @OneToMany
    List<Reponse> reponseList;

}
