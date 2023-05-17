package Controller;

import BO.UserBO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class Login extends HttpServlet {
    private String message;
    private UserBO userbo = new UserBO();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean value = false;
        try {
            value =  userbo.login(username, password);
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
