package br.com.home.jpa;

import br.com.home.domain.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveTarefa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager entityManager = factory.createEntityManager();
        Tarefa tarefa = entityManager.find(Tarefa.class, 2);
        entityManager.getTransaction().begin();
        entityManager.remove(tarefa);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
