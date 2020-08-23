package unfn.imd.sigsaude.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import unfn.imd.sigsaude.model.entity.Aluno;
import unfn.imd.sigsaude.service.AlunoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService service;

    @Autowired
    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listar")
    public String listar( Model m){
        List<Aluno> alunoList = service.buscarTodos();
        m.addAttribute("alunos", alunoList);
        return "aluno/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastrar")
    public String Cadastrar(Model m){
        var aluno = new Aluno();
        m.addAttribute("aluno", aluno);
        return "aluno/cadastrar";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    public String Salvar(@ModelAttribute Aluno a , Errors e){

        if(e.hasErrors()){
            return "/aluno/cadastrar";
        }else{
            service.saveAndFlush(a);
            return "redirect:/aluno/listar";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editar/{id}")
    public ModelAndView Editar(@PathVariable(name = "id")   Long id){
        var modelAndView = new ModelAndView("aluno/editar");
        var aluno = service.buscarPorId(id);
        modelAndView.addObject("aluno", aluno);
        return  modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/excluir/{id}")
    public String Excluir(@PathVariable(name = "id") Long id){
        var aluno = service.buscarPorId(id);
        service.deletar(aluno);
        return "redirect:/aluno/listar";
    }

}
