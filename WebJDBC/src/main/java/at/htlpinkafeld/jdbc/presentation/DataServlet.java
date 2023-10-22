package at.htlpinkafeld.jdbc.presentation;

import at.htlpinkafeld.jdbc.service.DBService;
import at.htlpinkafeld.jdbc.dto.Department;
import at.htlpinkafeld.jdbc.dto.Employee;
import at.htlpinkafeld.jdbc.infrastructure.EmployeeJdbcDao;
import at.htlpinkafeld.jdbc.infrastructure.DepartmentJdbcDao;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DataServlet", value = "/DataServlet")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        PrintWriter out = response.getWriter();
        HttpSession sess = request.getSession();
        //wir lesen den service objekt
        DBService serv = (DBService) sess.getAttribute("service");
        //verwenden service klasse, um liste zu lesen
        if(serv == null){
            serv = new DBService();
            sess.setAttribute("service", serv);
        }
        for (Department d: serv.list()) {
            out.println(d);
            for (Employee e : serv.getEmpFromDept(d)) {
                out.println("     " + e);
            }
        }
    }
}