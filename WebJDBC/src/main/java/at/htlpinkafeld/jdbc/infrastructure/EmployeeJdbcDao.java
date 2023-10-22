package at.htlpinkafeld.jdbc.infrastructure;

import at.htlpinkafeld.jdbc.dto.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeJdbcDao implements EmployeeDao{
    @Override
    public List<Employee> list() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM emp";
        try(Statement stmt = ConnectionManager.getInst().getConn().createStatement();
            ResultSet rsEmp = stmt.executeQuery(sql)) {
            while(rsEmp.next()){
                Employee emp = new Employee();
                emp.setEmpNo(rsEmp.getInt("EMPNO"));
                emp.setEmpName(rsEmp.getString("ENAME"));
                emp.setDeptNo(rsEmp.getInt("DEPTNO"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeJdbcDao.class.getName()).log(Level.SEVERE, null, e);
            throw new SQLException(e.getMessage());
        }
        return employees;
    }
}
