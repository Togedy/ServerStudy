package io.arkchive.jpa;

import io.arkchive.jpa.entity.Customer;
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

        try {
//            데이터 넣기
//            em.persist(Customer.sample());

//             데이터 불러오기
            Customer foundCustomer = em.find(Customer.class, "ID0001");

//            불러온 데이터 수정하기
//            foundCustomer.setName("Park");

//            데이터 삭제하기
            em.remove(foundCustomer);

            System.out.println(foundCustomer.toString());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
