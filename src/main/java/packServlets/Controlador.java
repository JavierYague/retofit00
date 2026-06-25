/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package packServlets;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import utils.BD;
/**
 *
 * @author Nerea
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static Connection con;
    @Override
    public void init(ServletConfig cfg){
        con=BD.getConexion();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pEmail=request.getParameter("txtEmail");
        String nombre="";
        boolean correcto=false;
        
        try(
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(
                    "Select * from usuarios where emailU= '"+pEmail+"'"
                            );
        )   {
                    if(rs.next()){
                        correcto=true;
                        nombre=rs.getString("nombreU");
                    }else{
                        try(
                            Statement st2=con.createStatement();
                            ResultSet rs2=st2.executeQuery("Select * from usuarios where emailU= '"+pEmail+"'");
                                ){
                                    if(rs2.next()){
                                        correcto=true;
                                        nombre=rs2.getString("nombreE");
                                    }
                        }catch(SQLException sqle1){
                            System.out.println("No ha leido de la tabla de Entrenadores. "+ sqle1.getMessage());
                        }
                    }
                        
            }catch(SQLException sqle2){
                System.out.println("No ha leído la tabla de Usuarios"+sqle2.getMessage());    
            }
            if(correcto){
                HttpSession s=request.getSession(true);
                s.setAttribute("sPerfil",request.getParameter("sPerfil"));
                s.setAttribute("sEmail", pEmail);
                s.setAttribute("sNombre", nombre);
                
                request.getRequestDispatcher("Gestion.jsp").forward(request, response);
                
            }else{
                response.sendRedirect("Inicio.jsp?error=Email no existe como Usuario o como Entrenador");
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
