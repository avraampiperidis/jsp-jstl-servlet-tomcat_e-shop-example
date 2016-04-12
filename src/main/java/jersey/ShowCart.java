/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jersey;

import beans.MyCart;
import bookstore.ProductUtils;
import bookstore.model.ProductDAO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author abraham
 */
@Path("/showcart")
public class ShowCart {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showCartJsonGet(@Context HttpServletRequest request) {
        return getCartInfo(request);      
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String showCartJsonPost(@Context HttpServletRequest request) {
        return getCartInfo(request);
    }
    
    
    
    private String getCartInfo(HttpServletRequest request) {
        
        MyCart cart = (MyCart)request.getSession().getAttribute("cart");
        
        if(cart != null) {
            
            JsonObject jo = null;
            
            JsonArray ja = new JsonArray();
            
            for(int i =0; i < cart.getItems().size(); i++) {
                
                jo = new JsonObject();
                
                ProductDAO product = ProductUtils.getProductById(cart.getItems().get(i).getId());
                
                jo.addProperty("id", product.getId());
                jo.addProperty("title",product.getTitle());
                jo.addProperty("description", product.getDescription());
                jo.addProperty("price", product.getPrice());
                jo.addProperty("quantity", cart.getItemQuantity(product.getId()));
                
                ja.add(jo);
                
            }
           
            JsonObject mainob = new JsonObject();
            
            mainob.add("products", ja);
            
            return mainob.toString();
            
        }
        
        return "";
    }
    
    
}
