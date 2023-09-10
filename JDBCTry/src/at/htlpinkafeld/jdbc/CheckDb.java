package at.htlpinkafeld.jdbc;

import java.sql.*;

public class CheckDb {
    public static void main(String[] args) throws SQLException {
        //jdbc dbname file oder anderer typ name von db relatives pfad und shutdown und lock_file
        String dbUrl = "jdbc:hsqldb:file:../../_DATABASE/CompanyDB/company;ifexists=true;shutdown=true;hsqldb.lock_file=false";
        //brauchen connection und statement und behandeln sql exception
        Connection con = DriverManager.getConnection(dbUrl, "db", "");

        Statement stmt = con.createStatement();

        System.out.println("Departments: ");

        ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT");
        while(rs.next()) {
            System.out.println(rs.getString("DNAME"));
        }

        System.out.println("\nEmployees: ");

        ResultSet rs1 = stmt.executeQuery("SELECT * FROM EMP");
        while(rs1.next()) {
            System.out.println(rs1.getString("ENAME"));
        }

        System.out.println("\nSalary grades: ");

        ResultSet rs2 = stmt.executeQuery("SELECT * FROM SALGRADE");
        while(rs2.next()) {
            System.out.println(rs2.getInt("GRADE"));
        }

        con.close();

        // employee - ename, empno, salary
        // alle dept
        // alle emp
        // jav klassen wo ein objekt eine tabelle angezeigt / brauchen toString / Collection

        // hü: dept: sales, new york

        // statement schliessen
    }
}
