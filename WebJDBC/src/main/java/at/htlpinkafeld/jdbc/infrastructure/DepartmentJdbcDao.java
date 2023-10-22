package at.htlpinkafeld.jdbc.infrastructure;

import at.htlpinkafeld.jdbc.dto.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentJdbcDao implements DepartmentDao {
    @Override
    public List<Department> list() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM dept";
        try (Statement stmt = ConnectionManager.getInst().getConn().createStatement();
             ResultSet rsDept = stmt.executeQuery(sql)) {
            while (rsDept.next()) {
                Department dep = new Department();
                dep.setDeptNo(rsDept.getInt("DEPTNO"));
                dep.setDeptName(rsDept.getString("DNAME"));
                dep.setDeptLocation(rsDept.getString("LOC"));
                departments.add(dep);
            }
        } catch (SQLException e) {
            Logger.getLogger(DepartmentJdbcDao.class.getName()).log(Level.SEVERE, null, e);
            throw new SQLException(e.getMessage());
        }
        return departments;
    }
}
