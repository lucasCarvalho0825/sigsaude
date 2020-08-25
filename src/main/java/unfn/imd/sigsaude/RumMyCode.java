package unfn.imd.sigsaude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import unfn.imd.sigsaude.model.entity.Aluno;
import unfn.imd.sigsaude.model.entity.Professor;
import unfn.imd.sigsaude.model.entity.Turma;
import unfn.imd.sigsaude.model.repository.AlunoRepository;
import unfn.imd.sigsaude.model.repository.ProfessorRepository;
import unfn.imd.sigsaude.model.repository.TurmaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class RumMyCode implements ApplicationRunner {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    TurmaRepository turmaRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Professor p1 = new Professor();
        p1.setNome("p1");
        p1.setDisciplina("programação");
        p1.setCpf("11111111111");

        Professor p2 = new Professor();
        p2.setNome("p2");
        p2.setDisciplina("algebra");
        p2.setCpf("22222222222");

        Turma t1 = new Turma();
        t1.setSala("t1");
        t1.setProfessor(p1);

        Turma t2 = new Turma();
        t2.setSala("t2");
        t2.setProfessor(p2);

        Aluno a1 = new Aluno();
        a1.setNome("a1");
        a1.setMatricula("123456");
        a1.setCpf("11111111111");
        a1.setTurma(t1);

        Aluno a2 = new Aluno();
        a2.setNome("a2");
        a2.setMatricula("238751");
        a2.setCpf("22222222222");
        a2.setTurma(t2);

        Aluno a3 = new Aluno();
        a3.setNome("a3");
        a3.setMatricula("9378362");
        a3.setCpf("3333333333");
        a3.setTurma(t2);

        Aluno a4 = new Aluno();
        a4.setNome("a4");
        a4.setMatricula("9874632");
        a4.setCpf("44444444444");
        a4.setTurma(t2);

       /* alunoRepository.save(a1);
        alunoRepository.save(a2);
        alunoRepository.save(a3);
        alunoRepository.save(a4);
        professorRepository.save(p1);
        professorRepository.save(p2);
        turmaRepository.save(t1);
        turmaRepository.save(t2);*/




    }
}
