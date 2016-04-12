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
public interface OrderDetailDAO {
    
    
    /**
     * @return the id
     */
    int getId();

    /**
     * @return the orders
     */
    OrdersDAO getOrderDetails();

    /**
     * @return the product
     */
    int getProduct();

    /**
     * @return the quantity
     */
    int getQuantity();

    /**
     * @param id the id to set
     */
    void setId(int id);

    /**
     * @param orders the orders to set
     */
    void setOrderDetails(OrdersDAO orders);

    /**
     * @param product the product to set
     */
    void setProduct(int product);

    /**
     * @param quantity the quantity to set
     */
    void setQuantity(int quantity);
    
}
