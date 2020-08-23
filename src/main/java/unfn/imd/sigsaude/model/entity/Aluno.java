package unfn.imd.sigsaude.model.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno extends AbstractEntity<Long> {

    @NotBlank
    @Column(nullable = false, length = 20)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 20, unique = true)
    private String matricula;

    @NotBlank
    @Column(nullable = false, length = 11,  unique = true)
    private String cpf;
}
