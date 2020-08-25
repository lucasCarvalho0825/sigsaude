package unfn.imd.sigsaude.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(nullable = false, length = 20)
    String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    String disciplina;

    @NotBlank
    @Column(nullable = false, length = 11)
    String cpf;
}
