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
        try {
//            em.persist(Customer.sample());
            Customer foundCustomer = em.find(Customer.class, "id001"); //Primary Key로 검색
            foundCustomer.setName("Park"); //data 변경
            em.remove(foundCustomer); //data 삭제
            System.out.println(foundCustomer.toString());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();  //잘못된 경우엔 tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
