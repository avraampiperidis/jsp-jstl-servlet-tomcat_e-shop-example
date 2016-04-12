/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.CustomerDAO;
import bookstore.model.CustomerDaoHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author abraham
 */
public class CustomerUtilsTest {
    
    private static Session session;
    //check bookstorelog.txt for log results
    private static Logger log = Logger.getLogger(CustomerUtils.class);
    
    public CustomerUtilsTest() {
        
    }
    
    
    @BeforeClass
    public static void setUpClass() {    
        log.info("setting factory hibernate");
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        log.info("closing hiberante session");
        session.close();
    }
    
    
    //insert user for test
    @Before
    public void setUp() {
        
        CustomerDAO customertest = new CustomerDaoHibernate();
        
        customertest.setUname("testuser");
        customertest.setAddress("address");
        customertest.setPassword("1234");
        
        Transaction tx = session.beginTransaction();
        int result = (Integer)session.save(customertest);
        tx.commit();
    }
    
    
    //delete test user
    @After
    public void tearDown() {
        
        log.info("deleting testuser");
        
        Transaction tx = session.beginTransaction();
        
        String hql = "DELETE FROM CustomerDaoHibernate C WHERE C.id = :ID ";
        Query query = session.createQuery(hql);
        query.setParameter("ID", CustomerUtils.getCustomerByUsername("testuser").getId());
        query.executeUpdate();
        tx.commit();
    }
    
    
    @Test
    public void testGetCustomerByUsername() {
        
        log.info("testGetCustomerByUsername");
        
        CustomerDAO customertest = CustomerUtils.getCustomerByUsername("testuser");
        
        assertEquals("testuser",customertest.getUname());
        
    }
    
    
}
