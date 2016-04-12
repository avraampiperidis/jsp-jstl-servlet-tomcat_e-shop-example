/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "category" , uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class CategoryDaoHibernate implements CategoryDAO, Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID" , unique = true, nullable = false)
    private int id;
    
    @Column(name = "Name")
    private String name;
    
    @OneToMany(targetEntity = ProductDaoHibernate.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "category")
    private Set<ProductDAO> products = new HashSet<ProductDAO>(0);
    
    
    
    public CategoryDaoHibernate() {
        
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
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the products
     */
    @Override
    public Set<ProductDAO> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    
    @Override
    public void setProducts(Set<ProductDAO> products) {
        this.products = products;
    }

    
    
    
    
    
}
