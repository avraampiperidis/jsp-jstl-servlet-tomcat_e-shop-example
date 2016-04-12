/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.CustomerDAO;
import bookstore.model.CustomerDaoHibernate;
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
public class LoginServiceTest {
    
    
    public LoginServiceTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    @Test
    public void testAuthenticate() {
        
        CustomerDAO newCustomer = new CustomerDaoHibernate();
        
        newCustomer.setUname("username1234");
        newCustomer.setPassword("passwd123456");
        
        int id = CustomerUtils.createCustomer(newCustomer);
        
        LoginService login = new LoginService();
        
        boolean auth = login.authenticate(newCustomer.getUname(), newCustomer.getPassword());
        
        assertEquals(auth,true);
        
        auth = login.authenticate((newCustomer.getUname()+"1"), newCustomer.getPassword());
        assertEquals(auth,false);
        
        auth = login.authenticate(null, null);
        assertEquals(auth,false);
        
        CustomerUtils.deleteCustomer(id);
        
    }
    
    
    
}
