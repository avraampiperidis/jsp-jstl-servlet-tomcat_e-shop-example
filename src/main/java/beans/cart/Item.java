/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.cart;

import bookstore.model.ProductDAO;
import bookstore.ProductUtils;
import com.google.gson.JsonObject;
import java.io.Serializable;


public class Item implements Serializable {
    
    private int id;
    private int quantity = 1;
    
    private String title;
    private float price;
    private String description;
    
    public Item() {}
    
    
    public Item(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    
    public void setId(int i) {
        id = i;
        setValues(i);
    }
    
    
    public int getQuantity() {
        return quantity;
    }
    
    
    public void increateQuantity() {
        quantity++;
    }
    
    
    public void decreaseQuantity() {
        if(quantity > 1) {
            quantity--;
        }
    }
    
    
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setPrice(float p) {
        price = p;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setDescription(String d) {
        description = d;
    }
    
    public String getDescription() {
        return description;
    }
    
    
    @Override
    public int hashCode() {
        return id;
    }

    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Item other = (Item) obj;
        
        return this.id == other.id;
        
    }
    
    
    
    public void setValues(int id) {
        
        if(id >= 0) {
        
            ProductDAO product = ProductUtils.getProductById(id);

            setTitle(product.getTitle());
            setPrice(product.getPrice());
            setDescription(product.getDescription());
        
        }
        
    }
    
    
    
    @Override
    public String toString() {
        return "id:"+id+",quantity:"+quantity+",title:"+title+",price:"+price+",description:"+description;
    }
    
    
    public String toStringJson() {
        JsonObject json = new JsonObject();
        
        json.addProperty("id", id);
        json.addProperty("quantity", quantity);
        json.addProperty("title", title);
        json.addProperty("price", price);
        json.addProperty("description", description);
    
        return json.toString();
    }
    
    
}
