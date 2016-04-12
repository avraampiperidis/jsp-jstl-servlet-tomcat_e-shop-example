/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.ProductDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author abraham
 */
public class ProductUtils {
    
    
    public static ProductDAO getProductById(int id) {
        
        List<ProductDAO> products = null;
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("from ProductDaoHibernate P where P.id = :ID");
        query.setParameter("ID", id);
        
        products = query.list();
        
        return products.get(0);
    }
    
    
    public static void deleteProductFromCategory(int productid,int catid) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM ProductDaoHibernate P WHERE P.id = :ID";
        Query query = session.createQuery(hql);
        query.setParameter("ID", productid);
        
        query.executeUpdate();
        tx.commit();
        
    }
    
}
