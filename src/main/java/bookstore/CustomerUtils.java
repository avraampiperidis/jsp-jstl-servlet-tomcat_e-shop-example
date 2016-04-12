/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.CustomerDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author abraham
 */
public class CustomerUtils {
    
        
    
    
    public static CustomerDAO getCustomerByUsername(String username) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
                
        CustomerDAO customer = null;
        
                                                                                 //class    //db
            Query query = session.createQuery("from CustomerDaoHibernate C where C.uname = :uname ");
                                //:uname
            query.setParameter("uname",username);
            List list = query.list();
            

            if(list != null && !list.isEmpty()) {
               return customer =  (CustomerDAO) list.get(0);
            } 
            
            return null;
         
    }
    
    
    public static int createCustomer(CustomerDAO customer) {
        int id = -1;
                
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        id = (Integer) session.save(customer);
        tx.commit();
        
        return id;
        
    }
    
    
     public static void deleteCustomer(int customerId) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM CustomerDaoHibernate C WHERE C.id = :ID";
        Query query = session.createQuery(hql);
        query.setParameter("ID", customerId);
        
        query.executeUpdate();
        tx.commit();
        
    }
    
    
}
