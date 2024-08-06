package org.example;

import jakarta.persistence.EntityManager;
import org.example.Util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
    }
}
