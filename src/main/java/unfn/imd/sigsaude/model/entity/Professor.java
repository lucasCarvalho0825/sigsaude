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
public class Professor extends AbstractEntity<Long>{

    @NotBlank
    @Column(nullable = false, length = 20)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String disciplina;

    @NotBlank
    @Column(nullable = false, length = 11)
    private String cpf;
}
