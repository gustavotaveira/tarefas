package br.com.home.jpa;

import br.com.home.domain.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BuscaTarefa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createQuery("select t from Tarefa as t where t.finalizado = :paramFinalizado");
        query.setParameter("paramFinalizado", true);
        List resultList = query.getResultList();
        for (Object tarefa : resultList) {
            Tarefa t = (Tarefa) tarefa;
            System.out.println(t);
        }

        entityManager.close();
        factory.close();
    }
}
