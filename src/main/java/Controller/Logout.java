package Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Logout {
    public Logout() {

    }
    protected static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("username") != null){
            response.sendRedirect("Manual");
        }
    }
}
