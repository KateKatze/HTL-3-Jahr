package at.htlpinkafeld.generator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "IterationDrei", value = "/IterationDrei")
public class IterationDrei extends HttpServlet {
    int remainingNum = 6;
    private ArrayList<Log> logs= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sess = request.getSession();
        PrintWriter out = response.getWriter();

        remainingNum--;
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");
        out.println("<title>Iteration 3</title></head>");
        out.println("<body>");
        out.println("<div class=\"card\" style=\"width: 18rem; margin: 0 auto; margin-top: 20px;\">");
        out.println("<div class=\"card-body\">");
        out.println("<h5 class=\"card-title\">Iteration 3</h5>");
        if(remainingNum == -1) {
            out.println("<span>You have ran out of free random numbers, please buy more credits!</span>");
            out.println("<a href=\"/Generator/index.html\" class=\"btn btn-success mt-2\">Home</a>");
            out.close();
            logs.clear();
            remainingNum=6;
        }else{
            out.println("<span>Free random numbers remaining: " + remainingNum + "</span>");
            out.println("<form name=\"form\" action=\"IterationDrei\" method=\"POST\">");
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
            int min = Integer.parseInt(request.getParameter("min"));
            int max = Integer.parseInt(request.getParameter("max"));
            int randomNumber = (int) ((Math.random() * (max - min)) + min);
            out.println("<p id=\"result\" class=\"mt-3\"><span>Result: </span>"+randomNumber+"</p>");
            String ipAddr = (String) InetAddress.getLocalHost().getHostAddress();
            logs.add(new Log(ipAddr, randomNumber));
            if (logs.size() != 0) {
                for (Log log1 : logs)
                    out.println("<ul>" + log1 + "</ul>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();

        out.println("<a href=\"/Generator/index.html\" class=\"btn btn-success\">Home</a>");
        out.println("</div>");
        out.println("</div>");
        out.println(" </body>");
        out.println(" </html>");
        out.close();
    }
}