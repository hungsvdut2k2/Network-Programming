package Controller;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import BO.CorpusBO;
import Bean.Corpus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SearchId", value = "/Search-Id")
public class SearchId extends HttpServlet {

    private CorpusBO corpusbo = new CorpusBO();
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.setCharacterEncoding("UTF-8");
            String seachValue = request.getParameter("id");
            Corpus result = corpusbo.getCorpusById(Integer.parseInt(seachValue));
            request.setAttribute("corpus", result);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/detail.jsp");
            dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void destroy() {
    }
}