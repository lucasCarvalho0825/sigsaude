package unfn.imd.sigsaude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unfn.imd.sigsaude.model.entity.Turma;
import unfn.imd.sigsaude.model.repository.TurmaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private TurmaRepository repository;

    @Autowired
    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    // insert e update
    public Turma saveAndFlush(Turma t){
        return repository.saveAndFlush(t);
    }

    // delete
    public void deletar(Turma t){
        repository.delete(t);
    }

    //buscar por um
    public Turma buscarPorId(Long id){
        return repository.getOne(id);
    }

    public Optional<Turma> buscarPorUm(Long id){
        return repository.findById(id);
    }

    //buscar por todos
    public List<Turma> buscarTodos(){
        return repository.findAll();
    }
}
