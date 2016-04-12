/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.cart;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SimpleCart implements Serializable, Cart {
    
    
    private List<Item> items;
    
    
    public SimpleCart() {
        items = Collections.synchronizedList(new ArrayList());
    }
    
    
    
    @Override
    public void addItem(int id) {
        
        synchronized(items) {
            
            Item it = getItemById(id);

            if(it != null) {

                for(int i =0; i < items.size(); i++) {

                    if(items.get(i).getId() == it.getId()) {

                        Item tempItem = items.get(i);
                        tempItem.increateQuantity();
                        items.set(i, tempItem);

                        break;
                    }
                }
            } else {
                Item item = new Item();
                item.setId(id);
                items.add(item);
            }
            
        }
    }
    
    
    @Override
    public List<Item> getItems() {
        return items;
    }
    
    
    
    @Override
    public Item getItemById(int id) {
        for(Item item : items) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
    
    
    @Override
    public void removeItem(int id) {
        
        synchronized(items) {
        
            Item item = getItemById(id);

            if(item != null) {
                if(item.getQuantity() > 1) {
                    item.decreaseQuantity();
                } else {
                    removeItemById(item.getId());
                }
            }
        
        }
        
    }
    
    
    private void removeItemById(int id) {
        
        //classic old for loop and not for each because we gona have ConcurrentException...
        for(int i =0; i < items.size(); i++) {
            if(items.get(i).getId() == id) {
                items.remove(i);
                break;
            }
        }
        
    }

    
    @Override
    public void removeAllItems() {
        items.clear();
    }

    
    @Override
    public int getCartSize() {
        return items.size();
    }

    
    @Override
    public boolean isItemInCart(int id) {
        for(Item i : items) {
            if(i.getId() == id) {
                return true;
            }
        }
        return false;
    }

    
    @Override
    public int getItemQuantity(int id) {
        if(isItemInCart(id)) {
            Item item = getItemById(id);
            return item.getQuantity();
        }
        return -1;
    }

    
    
    
    @Override
    public String toString() {
        return items.toString();
    }
   
    
    @Override
    public String toStringJsonArray() {
        
        JsonArray jsonarr = new JsonArray();
        
        JsonObject job;
        for(Item item : items) {
            job = new JsonObject();
            job.addProperty("item", item.toStringJson());
            jsonarr.add(job);
        }
        
        return jsonarr.toString();
    }
    
    
}
