
package bookstore;

import beans.MyCart;
import beans.cart.Item;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class MyCartTest {
        
    
    public MyCartTest() {
        
    }
    
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * id's is set to - minus to avoid database interaction
     */
    @Test
    public void testMyCart() {
        
        final int itemId = -5;
        
        MyCart cart = new MyCart();
        
        Item item = new Item();
        item.setId(itemId);
                
        cart.addItem(item.getId());
        
        assertEquals(itemId,cart.getItemById(item.getId()).getId());
        assertEquals(1,cart.getCartSize());
        assertEquals(1,cart.getItemQuantity(itemId));
        assertEquals(itemId,cart.getItemById(itemId).hashCode());
        
        System.out.println(cart.toString());
        System.out.println(cart.toStringJsonArray());
        
        for(int i =-1; i > -10; i--) {
            item = new Item();
            item.setId(i);
            cart.addItem(item.getId());
        }
        
        
        assertEquals(9,cart.getCartSize());
        
        assertEquals(2,cart.getItemQuantity(-5));
        
        cart.addItem(-5);      
        assertEquals(3,cart.getItemQuantity(-5));
        
        cart.removeItem(-5);
        assertEquals(2,cart.getItemQuantity(-5));
        
        cart.removeItem(-5);
        cart.removeItem(-5);
        
        assertEquals(-1,cart.getItemQuantity(-5));
        
        cart.removeAllItems();
        
        assertEquals(0,cart.getCartSize());
        assertEquals(null,cart.getItemById(-3));
        
        
    }
    
    
    
}