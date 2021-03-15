/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author wagner
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            double valor = Double.parseDouble(request.getParameter("valor"));
            int prazo = Integer.parseInt(request.getParameter("prazo"));
            double juros = Double.parseDouble(request.getParameter("juros"));
            double valorFuturo = valor * ((1 + juros / 100) * prazo);

            out.printf("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <title>Juros Simples Servlet</title>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <header>\n"
                    + "        <h1>Resultado!</h1>\n"
                    + "    </header>\n"
                    + "    <main>\n"
                    + "        <table>\n"
                    + "            <tr>\n"
                    + "                <td>Valor: </td>\n"
                    + "                <td>%.2f</td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td>Meses: </td>\n"
                    + "                <td>%d</td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td>Taxa de juros: </td>\n"
                    + "                <td>%.2f</td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td>Valor futuro: </td>\n"
                    + "                <td>%.2f</td>\n"
                    + "            </tr>\n"
                    + "        </table>\n"
                    + "<div class=\"btn\">\n"
                    + "     <a href=\"index.html\">Voltar!</a>\n"
                    + "</div>"
                    + "    </main>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>", valor, prazo, juros, valorFuturo);
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
