/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author abraham
 */
@Path("/test")
public class Test {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlTest() {
        return "<html><title></title><body><h1>hello</h1></body></html>";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayJsonTest() {
        return "";
    }
    
}
