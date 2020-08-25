package unfn.imd.sigsaude.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import unfn.imd.sigsaude.model.entity.Aluno;
import unfn.imd.sigsaude.model.entity.Professor;
import unfn.imd.sigsaude.model.entity.Turma;
import unfn.imd.sigsaude.service.AlunoService;
import unfn.imd.sigsaude.service.ProfessorService;
import unfn.imd.sigsaude.service.TurmaService;

import java.util.List;

@Controller
@RequestMapping("/turma")
public class TurmaController {

    TurmaService service;
    ProfessorService pService;
    AlunoService aService;

    @Autowired
    public TurmaController(TurmaService service, ProfessorService pService, AlunoService aService) {
        this.service = service;
        this.pService = pService;
        this.aService = aService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listar")
    public String listar( Model m){
        List<Turma> turmaList = service.buscarTodos();
        m.addAttribute("turmas", turmaList);
        return "turma/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastrar")
    public String Cadastrar(Model m){
        var turma = new Turma();
        m.addAttribute("turma", turma);
        return "turma/cadastrar";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    public String Salvar(@ModelAttribute Turma t , Errors e){

        if(e.hasErrors()){
            return "/turma/cadastrar";
        }else{
            service.saveAndFlush(t);
            return "redirect:/turma/listar";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editar/{id}")
    public ModelAndView Editar(@PathVariable(name = "id")   Long id){
        var modelAndView = new ModelAndView("turma/editar");
        var turma = service.buscarPorId(id);
        modelAndView.addObject("turma", turma);
        return  modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/excluir/{id}")
    public String Excluir(@PathVariable(name = "id") Long id){
        var turma = service.buscarPorId(id);
        service.deletar(turma);
        return "redirect:/turma/listar";
    }

    @ModelAttribute("professores")
    public List<Professor> getProfessores(){
        return pService.buscarTodos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/alunos/{id}")
    public String listaluno( @PathVariable(name = "id") Long id, Model m){
        List<Aluno> alunoList = aService.buscarPorTurma(service.buscarPorId(id));
        m.addAttribute("alunos", alunoList);
        return "turma/listaluno";
    }

}
