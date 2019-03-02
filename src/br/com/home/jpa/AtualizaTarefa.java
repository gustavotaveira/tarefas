package br.com.home.jpa;

import br.com.home.domain.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class AtualizaTarefa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager entityManager = factory.createEntityManager();
        Tarefa tarefa = new Tarefa();
        tarefa.setId(3);
        tarefa.setDescricao("Estudar JPA e Hibernate");
        tarefa.setDatafinalizacao(new Date());
        tarefa.setFinalizado(true);
        entityManager.getTransaction().begin();
        entityManager.merge(tarefa);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
