package br.com.home.dao.impl;

import br.com.home.dao.TarefaDao;
import br.com.home.domain.Tarefa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class JpaTarefaDao implements TarefaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void adicione(Tarefa tarefa) {
        entityManager.persist(tarefa);
    }

    @Override
    public List<Tarefa> obtenhaTarefas() {
        List resultList = entityManager.createQuery("select t from Tarefa as t").getResultList();
        List<Tarefa> lista = new ArrayList<>();
        for (Object tarefa : resultList) {
            lista.add((Tarefa) tarefa);
        }
        return lista;
    }

    @Override
    public void remove(Integer id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        entityManager.remove(tarefa);

    }

    @Override
    public Tarefa recupere(Integer id) {
        return entityManager.find(Tarefa.class, id);
    }

    @Override
    public void altere(Tarefa tarefa) {
        entityManager.merge(tarefa);
    }

    @Override
    public void finalize(Integer id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        tarefa.setFinalizado(true);
        tarefa.setDatafinalizacao(new Date());
        entityManager.merge(tarefa);
    }
}
