package Controller;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import BO.CorpusBO;
import Bean.Corpus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Search", value = "/Search")
public class SearchAll extends HttpServlet {

    private CorpusBO corpusbo = new CorpusBO();
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!Objects.equals(request.getParameter("username"), "Guest")) {
            request.setCharacterEncoding("UTF-8");
            String seachValue = request.getParameter("value");
            ArrayList<Corpus> result = corpusbo.getValueAndReturn(seachValue);
            request.setAttribute("corpusList", result);
            request.setAttribute("username", request.getParameter("username"));
            System.out.println(result);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void destroy() {
    }
}