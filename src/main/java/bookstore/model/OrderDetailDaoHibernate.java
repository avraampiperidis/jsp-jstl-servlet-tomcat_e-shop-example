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
@Table(name = "orderdetails", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class OrderDetailDaoHibernate implements OrderDetailDAO, Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    
    @ManyToOne(targetEntity = OrdersDaoHibernate.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Orders", nullable = false)
    private OrdersDAO orderdetails;
    
    @Column(name = "Quantity")
    private int quantity;
    
    @Column(name = "Product")
    private int product;

    
    public OrderDetailDaoHibernate() {
        
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
     * @return the orders
     */
    @Override
    public OrdersDAO getOrderDetails() {
        return orderdetails;
    }

    /**
     * @param orders the orders to set
     */
    @Override
    public void setOrderDetails(OrdersDAO orders) {
        this.orderdetails = orders;
    }

    /**
     * @return the quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    @Override
    public int getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    @Override
    public void setProduct(int product) {
        this.product = product;
    }
    
    
    
    
}
