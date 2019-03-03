package br.com.home.dao;

import br.com.home.domain.Tarefa;

import java.util.List;

public interface TarefaDao {


    void adicione(Tarefa tarefa);

    List<Tarefa> obtenhaTarefas();

    void remove(Integer id);

    Tarefa recupere(Integer id);

    void altere(Tarefa tarefa);

    void finalize(Integer id);


}
