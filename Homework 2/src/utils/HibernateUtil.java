package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class HibernateUtil {
    @PersistenceContext
    static EntityManagerFactory emf = null;

    public static EntityManager buildSF() {
        emf = Persistence.createEntityManagerFactory("mysqlPU");
        return emf.createEntityManager();
    }

    public static void closeEM(EntityManager em){
        em.clear();
        em.close();
        emf.close();
    }
}
