package hackerrank;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import persistent.Item;

public final class HibernateSessionHelper {
    public static HibernateSessionHelper hibernateSession = new HibernateSessionHelper();
    
    static SessionFactory sessionFactory = null;
    static Session session = null;
    static Transaction transaction = null;
    
    static {
        try {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.driver", "org.sqlite.JDBC");
            properties.setProperty("hibernate.connection.url", "jdbc:sqlite:inventory.db");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
        
            sessionFactory = new Configuration()
                    .addProperties(properties)
                    .addAnnotatedClass(Item.class)
                    .buildSessionFactory();
            
            openSession();
            beginTransaction();
        } catch (HibernateException e) {
            System.out.println(e.getLocalizedMessage());
            
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * 
     * @throws HibernateException 
     */
    private static void openSession() throws HibernateException {  
        session = sessionFactory.openSession();
    }
    
    /**
     * 
     * @throws HibernateException 
     */
    private static void beginTransaction() throws HibernateException {  
        transaction = session.beginTransaction();
    }
    
    public static void reopenSession() {
        if (!session.isConnected()) {
            openSession();
            beginTransaction();
        }
    }
    
    /**
     * 
     * @return sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * 
     * @return session
     */
    public Session getSession() {
        return session;
    }
    
    public void closeSession() {
        if (session != null) {
            if (transaction != null) {
                transaction.rollback();
            }
                
            session.close();
        }
    }
}
