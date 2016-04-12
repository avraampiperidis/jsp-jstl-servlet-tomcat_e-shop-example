/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author abraham
 */
public interface ProductDAO {
    
    public int getId();
    
    public void setId(int id);
    
    public void setTitle(String title);
    
    public String getTitle();
    
    public void setCategory(CategoryDAO category);
    
    public CategoryDAO getCategory();
    
    public void setDescription(String description);
    
    public String getDescription();
    
    public void setPrice(float price);
    
    public float getPrice();
    
    
}
