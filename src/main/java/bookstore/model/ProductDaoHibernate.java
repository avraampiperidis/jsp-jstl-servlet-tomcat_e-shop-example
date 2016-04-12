/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class ProductDaoHibernate implements ProductDAO, Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    
    @ManyToOne(targetEntity = CategoryDaoHibernate.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Category", nullable = false)
    private CategoryDAO category;
    
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "Price")
    private float price;
    
    
    public ProductDaoHibernate() {
        
    }
    
   
    /**
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the category
     */
    @Override
    public CategoryDAO getCategory() {
        return  category;
    }

    /**
     * @param category the category to set
     */
    @Override
    public void setCategory(CategoryDAO category) {
        this.category = category;
    }

    /**
     * @return the title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    @Override
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    @Override
    public void setPrice(float price) {
        this.price = price;
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
        
        final ProductDaoHibernate other = (ProductDaoHibernate) obj;
        if (this.id != other.id) {
            return false;
        }
        
        return true;
    }
    
    
}
