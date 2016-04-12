/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.model.CustomerDAO;

/**
 *
 * @author abraham
 */
public class LoginService {
    
    
    
    public boolean authenticate(String username,String password) {
        
        if(username == null || password == null) {
            return false;
        }
        
        CustomerDAO customer = CustomerUtils.getCustomerByUsername(username);
        
        if(customer != null && customer.getPassword().equals(password)) {
            return true;
        }
        
        return false;
                
    }
    
    
    
    
    
}
