package at.htlpinkafeld.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintCompany {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:hsqldb:file:../../_DATABASE/CompanyDB/company;ifexists=true;shutdown=true;hsqldb.lock_file=false";

        Connection con = DriverManager.getConnection(dbUrl, "db", "");

        Statement stmt = con.createStatement();

        List<Employee> empList = getAllEmp(con);
        List<Department> deptList = getAllDept(con);
        showAll(empList); //use wildcard and for-each loop
        showAll(deptList);

        con.close();
    }

    private static List<Employee> getAllEmp(Connection con) throws SQLException {
        List<Employee> empList = new ArrayList<>();
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM EMP");
        while (rs.next()){
            Employee e = new Employee();
            e.setEmpno(rs.getInt("EMPNO"));
            e.setEname(rs.getString("ENAME"));
            e.setJob(rs.getString("JOB"));
            e.setMgr(rs.getInt("MGR"));
            e.setHiredate(rs.getString("HIREDATE"));
            e.setSalary(rs.getInt("SAL"));
            e.setComm(rs.getDouble("COMM"));
            e.setDeptno(rs.getInt("DEPTNO"));
            empList.add(e);
        }
        rs.close();
        stat.close();
        return empList;
    }

    private static List<Department> getAllDept(Connection con) throws SQLException {
        List<Department> deptList = new ArrayList<>();
        Statement stat1 = con.createStatement();
        ResultSet rs1 = stat1.executeQuery("SELECT * FROM DEPT");
        while (rs1.next()){
            Department d = new Department();
            d.setDeptno(rs1.getInt("DEPTNO"));
            d.setDname(rs1.getString("DNAME"));
            d.setLoc(rs1.getString("LOC"));
            deptList.add(d);
        }
        rs1.close();
        stat1.close();
        return deptList;
    }

    private static <T> void showAll(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}
