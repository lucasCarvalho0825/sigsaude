package unfn.imd.sigsaude.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import unfn.imd.sigsaude.model.entity.Professor;
import unfn.imd.sigsaude.service.ProfessorService;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService service;

    @Autowired
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    //Rotas para criar, editar, visualizar e remover.
    @RequestMapping("/listar")
    public String getHome( Model m){
        List<Professor> professorList = service.buscarTodos();
        m.addAttribute("professores", professorList); // revisar conceito atributte
        return "professor/listar";
    }

    @RequestMapping("/cadastrar")
    public String getCadastro(Model m){
        var professor = new Professor();
        m.addAttribute("professor", professor);
        return "professor/cadastrar";
    }

    @PostMapping(value = "/salvar")
    public String getSalvar(@ModelAttribute Professor p , Errors e){

        if(e.hasErrors()){
            return "/professor/cadastrar";
        }else{
            service.saveAndFlush(p);
            return "redirect:/professor/listar";
        }
    }

    @GetMapping("/editar/{id}")
    public ModelAndView getEditar(@PathVariable(name = "id")   Long id){
        var modelAndView = new ModelAndView("professor/editar");
        var professor = service.buscarPorId(id);
        modelAndView.addObject("professor", professor);
        return  modelAndView;
    }


    @GetMapping("/excluir/{id}")
    public String getExcluir(@PathVariable(name = "id") Long id) {
        var professor = service.buscarPorId(id);
        service.deletar(professor);
        return "redirect:/professor/listar";
    }
}
