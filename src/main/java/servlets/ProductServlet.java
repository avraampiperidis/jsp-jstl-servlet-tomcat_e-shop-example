/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bookstore.CategoryUtils;
import bookstore.model.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abraham
 */
public class ProductServlet extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
       
        int cat = Integer.valueOf(request.getParameter("cat"));
        
        if(cat != 0) {
            
            Set<ProductDAO> products = new HashSet();
            products = CategoryUtils.getCategoryById(cat).getProducts();
            
                    out.println("<table border='1'>");
                    
                    out.println("<tr>");
                    out.println("<th>Add To cart</th>");
                    out.println("<th>Title</th>");
                    out.println("<th>Description</th>");
                    out.println("<th>Price</th>");
                    out.println("</tr>");
                    
                    for(ProductDAO p : products) {               
                        out.println("<tr>");

                        out.println("<td>");
                        out.println("<button class='button-action' type='button' onClick='addToCart("+p.getId()+")' >add to cart </button> ");
                        out.println("</td>");

                        out.println("<td>");
                        out.println(p.getTitle());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(p.getDescription());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(p.getPrice());
                        out.println("</td>");

                        out.println("</tr>");
                    }
                    out.println("</table>");
           
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
