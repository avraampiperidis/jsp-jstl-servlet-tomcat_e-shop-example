/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.CategoryDAO;
import bookstore.model.ProductDAO;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author abraham
 */
public class CategoryUtils {
    
    private static Session session;
    
    public static List<CategoryDAO> getCategories() {
        
        List<CategoryDAO> categories = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("from CategoryDaoHibernate");
        categories = query.list();
        
        
        return categories;
        
    }
    
    
    public static CategoryDAO getCategoryById(int catId) {
        
        List<CategoryDAO> categories = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("from CategoryDaoHibernate C where C.id = :ID");
        query.setParameter("ID", catId);
        
        categories = query.list();
        
        if(categories != null && !categories.isEmpty()) {
            return categories.get(0);
        } 
        
        return null;
    }
    
    
    /**
     * 
     * @param category
     * @return the id of the new created category
     * 
     */
    public static int createCategory(CategoryDAO category) {
        
        int id = -1;
        
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        id = (Integer) session.save(category);
        tx.commit();
        
        return id;
     
    }
    
    
    public static void addProductIntoCategory(ProductDAO product,int catid) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        
        CategoryDAO category = getCategoryById(catid);
        product.setCategory(category);
        
        Set<ProductDAO> products = category.getProducts();
        products.add(product);
        category.setProducts(products);
        
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(category);
        tx.commit();
        
    }
    
    
    public static void deleteCategory(int catId) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM CategoryDaoHibernate C WHERE C.id = :ID";
        Query query = session.createQuery(hql);
        query.setParameter("ID", catId);
        
        query.executeUpdate();
        tx.commit();
        
    }
    
    
    
    
    
    
}
