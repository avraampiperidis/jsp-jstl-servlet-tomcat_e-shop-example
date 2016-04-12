/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.cart;

import java.util.List;

/**
 *
 * @author abraham
 */
public interface Cart {

    void addItem(int id);

    Item getItemById(int id);

    List<Item> getItems();

    void removeItem(int id);
    
    void removeAllItems();
    
    int getCartSize();
    
    boolean isItemInCart(int id);
    
    int getItemQuantity(int id);
    
    String toStringJsonArray();
}
