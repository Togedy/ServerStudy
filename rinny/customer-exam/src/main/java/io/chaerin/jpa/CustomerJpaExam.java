package io.chaerin.jpa;

import io.chaerin.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //data 관련 처리
        em.persist(Customer.sample());
        //
        tx.commit(); //잘못된 경우엔 tx.rollback();
        em.close();
        emf.close();
    }
}
