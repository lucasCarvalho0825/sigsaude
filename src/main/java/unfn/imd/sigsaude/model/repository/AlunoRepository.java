package unfn.imd.sigsaude.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unfn.imd.sigsaude.model.entity.Aluno;
import unfn.imd.sigsaude.model.entity.Turma;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByTurma(Turma t);
}
