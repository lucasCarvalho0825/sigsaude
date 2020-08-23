package unfn.imd.sigsaude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import unfn.imd.sigsaude.model.entity.Aluno;
import unfn.imd.sigsaude.model.entity.Professor;
import unfn.imd.sigsaude.model.repository.AlunoRepository;
import unfn.imd.sigsaude.model.repository.ProfessorRepository;

import javax.transaction.Transactional;

@Component
public class RumMyCode implements ApplicationRunner {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    ProfessorRepository professorRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Aluno a1 = new Aluno();
        a1.setNome("a1");
        a1.setMatricula("123456");
        a1.setCpf("11111111111");

        Aluno a2 = new Aluno();
        a2.setNome("a2");
        a2.setMatricula("238751");
        a2.setCpf("22222222222");

        Aluno a3 = new Aluno();
        a3.setNome("a3");
        a3.setMatricula("9378362");
        a3.setCpf("3333333333");

        Professor p1 = new Professor();
        p1.setNome("p1");
        p1.setDisciplina("programação");
        p1.setCpf("11111111111");

        Professor p2 = new Professor();
        p2.setNome("p2");
        p2.setDisciplina("algebra");
        p2.setCpf("22222222222");

        //alunoRepository.save(a1);
        //alunoRepository.save(a2);
        //alunoRepository.save(a3);
       // professorRepository.save(p1);
       // professorRepository.save(p2);

    }
}
