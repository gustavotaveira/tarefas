package br.com.home.jpa;

import br.com.home.domain.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class AdicionaTarefa {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager entityManager = factory.createEntityManager();

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("Estudar JPA");
        tarefa.setFinalizado(true);
        tarefa.setDatafinalizacao(new Date());

        entityManager.getTransaction().begin();
        entityManager.persist(tarefa);
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
