package br.com.home.jpa;

import br.com.home.domain.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarregaTarefa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager entityManager = factory.createEntityManager();
        Tarefa tarefa = entityManager.find(Tarefa.class, 2);
        System.out.print(tarefa);

    }
}
