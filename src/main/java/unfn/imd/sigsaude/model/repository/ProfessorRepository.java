package unfn.imd.sigsaude.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unfn.imd.sigsaude.model.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
