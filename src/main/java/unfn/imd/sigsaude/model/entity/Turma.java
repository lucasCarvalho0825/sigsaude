package unfn.imd.sigsaude.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma extends AbstractEntity<Long>{

    @NotBlank
    @Column(nullable = false, length = 20)
    private String sala;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @JoinColumn(name = "professor_id")
    Professor professor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "aluno_id")
    private List<Aluno> aluno;
}