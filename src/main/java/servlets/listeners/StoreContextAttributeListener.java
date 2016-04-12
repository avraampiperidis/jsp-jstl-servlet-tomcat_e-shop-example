/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import org.apache.log4j.Logger;

/**
 *
 * @author abraham
 */

public class StoreContextAttributeListener implements ServletContextAttributeListener  {

    private Logger log = Logger.getLogger(StoreContextAttributeListener.class);
    
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        log.info("ServletContext attribute added:"+scae.getName()+",Value:"+scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        log.info("ServletContext attribute removed:"+scae.getName()+",Value:"+scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        log.info("ServletContext attribute replaced:"+scae.getName()+",Value:"+scae.getValue());
    }
    
    
    
}
