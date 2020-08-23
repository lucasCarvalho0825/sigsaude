package unfn.imd.sigsaude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unfn.imd.sigsaude.model.entity.Professor;
import unfn.imd.sigsaude.model.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository repository;

    @Autowired
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    // insert e update
    public Professor saveAndFlush(Professor p){
        return repository.saveAndFlush(p);
    }

    // delete
    public void deletar(Professor p){
        repository.delete(p);
    }

    //buscar por um
    public Professor buscarPorId(Long id){
        return repository.getOne(id);
    }

    public Optional<Professor> buscarPorUm(Long id){
        return repository.findById(id);
    }

    //buscar por todos
    public List<Professor> buscarTodos(){
        return repository.findAll();
    }
}
