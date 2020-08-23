package unfn.imd.sigsaude.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unfn.imd.sigsaude.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
