/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.util.Set;

/**
 *
 * @author abraham
 */
public interface CategoryDAO {
    
    public void setProducts(Set<ProductDAO> products);
    
    public Set<ProductDAO> getProducts();
    
    public int getId();
    
    public void setId(int id);
    
    public void setName(String name);
    
    public String getName();
    
    
}
