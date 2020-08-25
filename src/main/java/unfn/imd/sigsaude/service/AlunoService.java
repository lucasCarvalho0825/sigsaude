package unfn.imd.sigsaude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unfn.imd.sigsaude.model.entity.Aluno;
import unfn.imd.sigsaude.model.entity.Turma;
import unfn.imd.sigsaude.model.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository repository;

    @Autowired
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // insert e update
    public Aluno saveAndFlush(Aluno a){
        return repository.saveAndFlush(a);
    }

    // delete
    public void deletar(Aluno a){
        repository.delete(a);
    }

    //buscar por um
    public Aluno buscarPorId(Long id){
        return repository.getOne(id);
    }

    public Optional<Aluno> buscarPorUm(Long id){
        return repository.findById(id);
    }

    //buscar por todos
    public List<Aluno> buscarTodos(){
        return repository.findAll();
    }

    public List<Aluno> buscarPorTurma(Turma t){
        return repository.findByTurma(t);
    }
}
