package br.com.home.domain.builder;

import br.com.home.domain.Tarefa;

import java.util.Date;

public class TarefaBuilder {

    private Tarefa tarefa;

    private TarefaBuilder() {
        tarefa = new Tarefa();
    }

    public static TarefaBuilder novaTarefa() {
        return new TarefaBuilder();
    }

    public TarefaBuilder comId(Integer id) {
        this.tarefa.setId(id);
        return this;
    }

    public TarefaBuilder comDescricao(String descricao) {
        this.tarefa.setDescricao(descricao);
        return this;
    }

    public TarefaBuilder estaFinalizada(Boolean finalizada) {
        this.tarefa.setFinalizado(finalizada);
        return this;
    }

    public TarefaBuilder comDataFinalizacao(Date finalizacao) {
        this.tarefa.setDatafinalizacao(finalizacao);
        return this;
    }

    public Tarefa construir() {
        return this.tarefa;
    }
}
