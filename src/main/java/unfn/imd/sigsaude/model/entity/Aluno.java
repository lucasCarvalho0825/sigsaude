package unfn.imd.sigsaude.model.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(nullable = false, length = 20)
    String nome;

    @NotBlank
    @Column(nullable = false, length = 20, unique = true)
     String matricula;

    @NotBlank
    @Column(nullable = false, length = 11,  unique = true)
    String cpf;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    Turma turma;
}
