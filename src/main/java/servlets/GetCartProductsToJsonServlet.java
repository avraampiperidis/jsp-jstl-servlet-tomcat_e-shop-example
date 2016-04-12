/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.MyCart;
import bookstore.model.ProductDAO;
import bookstore.ProductUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abraham
 */
public class GetCartProductsToJsonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        MyCart cart = (MyCart)request.getSession().getAttribute("cart");
        
        if(cart != null) {
            
            JsonObject jo = null;
            
            JsonArray ja = new JsonArray();
            
            for(int i =0; i < cart.getItems().size(); i++) {
                
                jo = new JsonObject();
                
                ProductDAO product = ProductUtils.getProductById(cart.getItems().get(i).getId());
                
                jo.addProperty("id", product.getId());
                jo.addProperty("title",product.getTitle());
                jo.addProperty("description", product.getDescription());
                jo.addProperty("price", product.getPrice());
                jo.addProperty("quantity", cart.getItemQuantity(product.getId()));
                
                ja.add(jo);
                
            }
           
            JsonObject mainob = new JsonObject();
            
            mainob.add("products", ja);
            
            out.println(mainob.toString());
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
