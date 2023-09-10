package at.htlpinkafeld.jdbc;
import java.util.ArrayList;
import java.util.List;

public class Department {
    public Department() {

    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    private int deptno;
    private String dname;
    private String loc;
    private List<Employee> emps;

    public Department(int deptno, String dname, String loc, List<Employee> emp) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public void addEmployee(Employee e) {
        if (emps == null) {
            emps = new ArrayList<>();
        }
        emps.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department:\nDepartment number: " + deptno + ", Department name: " + dname + ", Location: " + loc + ";\n");
        if (emps != null) {
            sb.append("Employees:\n");
            for (Employee employee : emps) {
                sb.append(employee.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
