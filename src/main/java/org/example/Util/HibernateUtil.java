package org.example.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory emf;
    public static HibernateUtil getInstance() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        emf = Persistence.createEntityManagerFactory("default");
        return hibernateUtil;
    }
    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        entityManager.getTransaction().begin();
        {
            EntityManager entityManager1 = HibernateUtil.getInstance().createEntityManager();
            entityManager1.getTransaction().begin();


            entityManager1.getTransaction().commit();
        }


        entityManager.getTransaction().commit();
    }
}
