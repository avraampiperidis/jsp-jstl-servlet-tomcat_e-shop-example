/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.cart.Item;
import beans.cart.Cart;
import beans.cart.SimpleCart;
import java.util.List;

/**
 *
 * @author abraham
 */
public class MyCart implements Cart {
    
    private Cart cart;
    
    
    public MyCart() {
        cart = new SimpleCart();
    }
    
    
    public void setCart(Cart c) {
        cart = c;
    }
    
    public Cart getCart() {
        return cart;
    }
    
    @Override
    public void addItem(int id) {
        cart.addItem(id);
    }
    
    @Override
    public Item getItemById(int id) {
       return cart.getItemById(id);
    }
    
    @Override
    public List<Item> getItems() {
        return cart.getItems();
    }
    
    
    @Override
    public void removeItem(int id) {
        cart.removeItem(id);
    }
    
    @Override
    public void removeAllItems() {
        cart.removeAllItems();
    }
    
    @Override
    public int getCartSize() {
        return cart.getCartSize();
    }
    
    @Override
    public boolean isItemInCart(int id) {
        return cart.isItemInCart(id);
    }
    
    @Override
    public int getItemQuantity(int id) {
        return cart.getItemQuantity(id);
    }
    
    
    
    @Override
    public String toString() {
        return cart.toString();
    }
    
    
    @Override
    public String toStringJsonArray() {
        return cart.toString();
    }
    
    
}
