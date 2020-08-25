package unfn.imd.sigsaude.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(nullable = false, length = 20)
    String sala;

    @OneToOne
    @JoinColumn(name = "professor_id")
    Professor professor;

    @OneToMany
    List<Aluno> aluno;

}