package Controller;

import BO.UserBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private UserBO userbo = new UserBO();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getAttribute("username") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean value = false;
        try {
            value =  userbo.login(username, password);
            System.out.println(value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(value){
            request.setAttribute("username", username);
        }
//        request.setAttribute("Value", value);
        doGet(request, response);
    }

    public void destroy() {
    }
}
