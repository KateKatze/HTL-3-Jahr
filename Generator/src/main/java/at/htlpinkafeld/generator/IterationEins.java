package at.htlpinkafeld.generator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IterationEins", value = "/IterationEins")
public class IterationEins extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sess = request.getSession();
        PrintWriter out = response.getWriter();
        int min=0;
        int max=0;
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");
        out.println("<title>Iteration 1</title></head>");
        out.println("<body>");
        out.println("<div class=\"card\" style=\"width: 18rem; margin: 0 auto; margin-top: 20px;\">");
        out.println("<div class=\"card-body\">");
        out.println("<h5 class=\"card-title\">Iteration 1</h5>");
        out.println("<form name=\"form\" action=\"IterationEins\" method=\"POST\">");
        out.println("<div class=\"input-group mt-3 mb-3\">");
        out.println("<span class=\"input-group-text\">Min</span>");
        out.println("<input name=\"min\" type=\"number\" class=\"form-control\" aria-label=\"Minimum\">");
        out.println(" </div>");
        out.println("<div class=\"input-group mb-3\">");
        out.println("<span class=\"input-group-text\">Max</span>");
        out.println("<input name=\"max\" type=\"number\" class=\"form-control\" aria-label=\"Maximum\">");
        out.println("</div>");
        out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Generate random number\"/>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();

        int min = Integer.parseInt(request.getParameter("min"));
        int max = Integer.parseInt(request.getParameter("max"));
        int randomNumber = (int) ((Math.random() * (max - min)) + min);
        out.println("<p id=\"result\" class=\"mt-3\"><span>Result: </span>"+randomNumber+"</p>");
        out.println("<a href=\"/Generator/index.html\" class=\"btn btn-success\">Home</a>");
        out.println("</div>");
        out.println("</div>");
        out.println(" </body>");
        out.println(" </html>");
        out.close();
    }
}