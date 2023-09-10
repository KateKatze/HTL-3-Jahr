package at.htlpinkafeld.jdbc;

public class Employee {
    public Employee() {

    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private double salary;
    private double comm;
    private int deptno;
    public Employee(int empno, String ename, String job, int mgr, String hiredate, double salary, double comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.salary = salary;
        this.comm = comm;
        this.deptno = deptno;
    }

   @Override
    public String toString() {
        return "Employee: " +
                "Employee number: " + empno +
                ", Surname: '" + ename + '\'' +
                ", Job: '" + job + '\'' +
                ", Manager: " + mgr +
                ", Hiredate: '" + hiredate + '\'' +
                ", Salary: " + salary +
                ", Commission: " + comm +
                ", Department number: " + deptno +
                ';';
    }
}
