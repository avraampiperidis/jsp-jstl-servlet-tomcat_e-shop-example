/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.CategoryDAO;
import bookstore.model.CategoryDaoHibernate;
import bookstore.model.ProductDAO;
import bookstore.model.ProductDaoHibernate;
import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author abraham
 */
public class CategoryUtilsTest {
    
    private static Session session;
    //check bookstorelog.txt for log results
    private static Logger log = Logger.getLogger(CustomerUtils.class);
    
    private static  int catid;
    
    public CategoryUtilsTest() {
        
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        log.info("setting up test factory session");
        session = HibernateUtil.getSessionFactory().openSession();
           
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        log.info("Closing hibernate session");
        session.close();
    }
    
    
    
    @Test
    public void testCreateCategory() {
        log.info("testCreateCategory");
        
        CategoryDAO cat = new CategoryDaoHibernate();  
        cat.setName("testcategory");
       
        catid = CategoryUtils.createCategory(cat);
                
        int expected = CategoryUtils.getCategoryById(catid).getId();
        
        assertEquals(expected,catid);
        
    }
    
    
    
    @Test
    public void testDeleteCategory() {
        log.info("testDeleteCategory");
        
        CategoryUtils.deleteCategory(catid);      
        CategoryDAO cat = CategoryUtils.getCategoryById(catid);
        
        assertEquals(null,cat);
        
    }
    
    
    @Test
    public void testAddProductIntoCategory() {
        log.info("testAddProductIntoCategory");
        
        ProductDAO product = new ProductDaoHibernate();
        product.setTitle("testtitle");
        product.setDescription("testdescription");
        
        CategoryDAO cat = new CategoryDaoHibernate();
        cat.setName("testcategory");
        
        int id = CategoryUtils.createCategory(cat);
       
        
        CategoryUtils.addProductIntoCategory(product, id);
        
        cat = CategoryUtils.getCategoryById(id);
        
        assertEquals(id,cat.getId());
        
        for(ProductDAO p : cat.getProducts()) {
            if((p.getCategory().getId() == id) && p.getTitle().equals(product.getTitle()) && p.getDescription().equals(product.getDescription()) ) {
                product = p;
                break;
            }
        }
        
        assertEquals(product.getCategory().getId(),id);
        assertEquals(product.getCategory().getId(),cat.getId());
        assertEquals(product.getTitle(),"testtitle");
        
        ProductUtils.deleteProductFromCategory(product.getId(), id);
        CategoryUtils.deleteCategory(id);
        
    }
    
    
}
