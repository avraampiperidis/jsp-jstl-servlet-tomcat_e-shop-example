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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "orders",uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class OrdersDaoHibernate implements OrdersDAO, Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @OneToOne(targetEntity = CustomerDaoHibernate.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "orders")   
    private CustomerDAO customer;
    
    @Column(name = "oDate")
    private String date;
    
    @OneToMany(targetEntity = OrderDetailDaoHibernate.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "orderdetails")
    @PrimaryKeyJoinColumn
    private Set<OrderDetailDAO> orderdetails = new HashSet<OrderDetailDAO>(0);
    
    
    public OrdersDaoHibernate() {
        
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
     * @return the customers
     */
    @Override
    public CustomerDAO getCustomer() {
        return customer;
    }

    /**
     * @param customer the customers to set
     */
    @Override
    public void setCustomer(CustomerDAO customer) {
        this.customer = customer;
    }

    /**
     * @return the date
     */
    @Override
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    @Override
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the orderdetails
     */
    @Override
    public Set<OrderDetailDAO> getOrderdetails() {
        return orderdetails;
    }

    /**
     * @param orderdetails the orderdetails to set
     */
    @Override
    public void setOrderdetails(Set<OrderDetailDAO> orderdetails) {
        this.orderdetails = orderdetails;
    }
    
    
   
    
}
