package br.com.home.controller;

import br.com.home.TarefaDao;
import br.com.home.domain.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    @RequestMapping
    public String nova() {
        return "tarefa/nova";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String adicione(Tarefa tarefa, HttpServletRequest request) {
        if (tarefa.getDescricao() == null || tarefa.getDescricao().equals("")) {
            return nova();
        }
        Connection connection = (Connection) request.getAttribute("connection");
        TarefaDao dao = new TarefaDao(connection);

        dao.adicione(tarefa);
        return "tarefa/adicionada";
    }
}
