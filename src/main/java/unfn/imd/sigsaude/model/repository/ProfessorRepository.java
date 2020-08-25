package unfn.imd.sigsaude.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unfn.imd.sigsaude.model.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
