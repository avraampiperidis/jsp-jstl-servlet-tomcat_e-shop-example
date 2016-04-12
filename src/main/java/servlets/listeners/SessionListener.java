/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;

/**
 *
 * @author abraham
 */
public class SessionListener implements HttpSessionListener {
    
    private static Logger log = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        log.info("Session Created:"+hse.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        log.info("Session destroyed:"+hse.getSession().getId());
    }
    
}
