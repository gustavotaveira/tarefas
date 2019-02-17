package br.com.home.controller;

import br.com.home.TarefaDao;
import br.com.home.domain.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Connection;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    @RequestMapping
    public String nova() {
        return "tarefa/nova";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String adicione(@Valid Tarefa tarefa, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasFieldErrors("descricao")) {
            return nova();
        }
        Connection connection = (Connection) request.getAttribute("connection");
        TarefaDao dao = new TarefaDao(connection);

        dao.adicione(tarefa);
        return "redirect:tarefa/lista";
    }

    @RequestMapping("/lista")
    public String lista(Model model) {
        TarefaDao dao = new TarefaDao();
        model.addAttribute("tarefas", dao.obtenhaTarefas());
        return "tarefa/lista";
    }

    @RequestMapping("/remove")
    public String remove(Integer id) {
        TarefaDao dao = new TarefaDao();
        dao.remove(id);
        return "forward:/tarefa/lista";
    }

    @RequestMapping("/altere")
    public String altere(Integer id, Model model) {
        TarefaDao dao = new TarefaDao();
        Tarefa tarefa = dao.recupere(id);
        model.addAttribute("tarefa", tarefa);
        return "tarefa/altere";
    }

    @RequestMapping(value = "/alterar", method = RequestMethod.POST)
    public String alterar(Tarefa tarefa, HttpServletRequest request) {
        Connection connection = (Connection) request.getAttribute("connection");
        TarefaDao dao = new TarefaDao(connection);
        dao.altere(tarefa);
        return "forward:/tarefa/lista";
    }

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public String finalize(Integer id, Model model, HttpServletResponse response) {
        TarefaDao dao = new TarefaDao();
        dao.finalize(id);
        model.addAttribute("tarefa", dao.recupere(id));
        return "tarefa/finalizada";
    }
}
