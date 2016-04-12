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
public interface CustomerDAO {
    
     /**
     * @return the address
     */
    String getAddress();

    /**
     * @return the fname
     */
    String getFname();

    /**
     * @return the id
     */
    int getId();

    /**
     * @return the lname
     */
    String getLname();

    /**
     * @return the phone
     */
    String getPhone();

    /**
     * @return the uname
     */
    String getUname();

    /**
     * @param address the address to set
     */
    void setAddress(String address);

    /**
     * @param fname the fname to set
     */
    void setFname(String fname);

    /**
     * @param id the id to set
     */
    void setId(int id);

    /**
     * @param lname the lname to set
     */
    void setLname(String lname);

    /**
     * @param phone the phone to set
     */
    void setPhone(String phone);

    /**
     * @param uname the uname to set
     */
    void setUname(String uname);
    
   
    void setPassword(String passwd);
    
    String getPassword();
    
    OrdersDAO getOrders();
    
    void setOrders(OrdersDAO orders);
    
    
    
}
