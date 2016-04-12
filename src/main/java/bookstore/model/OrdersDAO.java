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
public interface OrdersDAO {
    
    /**
     * @return the customers
     */
    CustomerDAO getCustomer();

    /**
     * @return the date
     */
    String getDate();

    /**
     * @return the id
     */
    int getId();

    /**
     * @param customer
     */
    void setCustomer(CustomerDAO customer);

    /**
     * @param date the date to set
     */
    void setDate(String date);

    /**
     * @param id the id to set
     */
    void setId(int id);
    
    Set<OrderDetailDAO> getOrderdetails();
    
    
    void setOrderdetails(Set<OrderDetailDAO> orderdetails);
    
    
}
