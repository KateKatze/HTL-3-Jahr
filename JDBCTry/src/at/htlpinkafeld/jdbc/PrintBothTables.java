package at.htlpinkafeld.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintBothTables {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:hsqldb:file:../../_DATABASE/CompanyDB/company;ifexists=true;shutdown=true;hsqldb.lock_file=false";

        Connection connection = DriverManager.getConnection(dbUrl, "db", "");

        //emp
        Statement statementEmp = connection.createStatement();
        ResultSet resultSetEmp = statementEmp.executeQuery("SELECT * FROM EMP");
        List<Employee> employees = new ArrayList<>();
        while (resultSetEmp.next()){
            Employee em = new Employee();
            em.setEmpno(resultSetEmp.getInt("EMPNO"));
            em.setEname(resultSetEmp.getString("ENAME"));
            em.setJob(resultSetEmp.getString("JOB"));
            em.setMgr(resultSetEmp.getInt("MGR"));
            em.setHiredate(resultSetEmp.getString("HIREDATE"));
            em.setSalary(resultSetEmp.getInt("SAL"));
            em.setComm(resultSetEmp.getDouble("COMM"));
            em.setDeptno(resultSetEmp.getInt("DEPTNO"));
            employees.add(em);
        }

        // dept
        Statement statementDept = connection.createStatement();
        ResultSet resultSetDept = statementEmp.executeQuery("SELECT * FROM DEPT");
        List<Department> departments = new ArrayList<>();
        while (resultSetDept.next()){
            Department dep = new Department();
            dep.setDeptno(resultSetDept.getInt("DEPTNO"));
            dep.setDname(resultSetDept.getString("DNAME"));
            dep.setLoc(resultSetDept.getString("LOC"));

            int deptno = dep.getDeptno();
            for (Employee e : employees) {
                if (e.getDeptno() == deptno) {
                    dep.addEmployee(e);
                }
            }
            departments.add(dep);
        }

        resultSetEmp.close();
        statementEmp.close();
        resultSetDept.close();
        statementDept.close();
        connection.close();

        for (Department d : departments) {
            System.out.println(d);
        }
    }
}
