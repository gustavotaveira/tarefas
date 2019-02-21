package br.com.home.controller;

import br.com.home.dao.TarefaDao;
import br.com.home.domain.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaDao dao;

    @RequestMapping
    public String nova() {
        return "tarefa/nova";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String adicione(@Valid Tarefa tarefa, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("descricao")) {
            return nova();
        }
        dao.adicione(tarefa);
        return "redirect:tarefa/lista";
    }

    @RequestMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("tarefas", dao.obtenhaTarefas());
        return "tarefa/lista";
    }

    @RequestMapping("/remove")
    public String remove(Integer id) {

        dao.remove(id);
        return "forward:/tarefa/lista";
    }

    @RequestMapping("/altere")
    public String altere(Integer id, Model model) {
        Tarefa tarefa = dao.recupere(id);
        model.addAttribute("tarefa", tarefa);
        return "tarefa/altere";
    }

    @RequestMapping(value = "/alterar", method = RequestMethod.POST)
    public String alterar(Tarefa tarefa) {
        dao.altere(tarefa);
        return "forward:/tarefa/lista";
    }

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public String finalize(Integer id, Model model) {
        dao.finalize(id);
        model.addAttribute("tarefa", dao.recupere(id));
        return "tarefa/finalizada";
    }
}
