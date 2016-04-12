/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author abraham
 */
@Entity
@Table(name="customer", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class CustomerDaoHibernate implements CustomerDAO , Serializable {
    
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "Fname")
    private String fname;
    
    @Column(name = "Lname")
    private String lname;
    
    @Column(name = "Address")
    private String address;
    
    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "uname")
    private String uname;
    
    @Column(name = "passwd")
    private String password;
    
    @OneToOne(targetEntity = OrdersDaoHibernate.class,fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private OrdersDAO orders;
    
    public CustomerDaoHibernate() { }

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
     * @return the fname
     */
    @Override
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    @Override
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    @Override
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    @Override
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the address
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    @Override
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the uname
     */
    @Override
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the uname to set
     */
    @Override
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String passwd) {
        this.password = passwd;
    }

    @Override
    public OrdersDAO getOrders() {
        return orders;
    }

    @Override
    public void setOrders(OrdersDAO orders) {
        this.orders = orders;
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
        
        final CustomerDaoHibernate other = (CustomerDaoHibernate) obj;
        if (this.id != other.id) {
            return false;
        }
        
        return true;
    }
    
    
}
