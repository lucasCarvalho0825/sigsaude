package unfn.imd.sigsaude.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unfn.imd.sigsaude.model.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
