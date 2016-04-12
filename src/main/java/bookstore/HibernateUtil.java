/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;


import org.apache.log4j.Logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author abraham
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            //the default
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
            
            //for junit testing 
            //sessionFactory = new AnnotationConfiguration().configure("hibernate.cfgtest.xml").buildSessionFactory();
            
            log.info("new Session Factory");
            
        } catch (Throwable ex) {
            // Log the exception. 
            log.info("Initial SessionFactory creation failed." + ex.toString());
            System.err.println("" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    
    
    public static SessionFactory getSessionFactory() {
        
        return sessionFactory;
    }
    
    
}
