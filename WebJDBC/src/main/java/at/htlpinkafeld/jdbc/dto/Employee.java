package at.htlpinkafeld.jdbc.dto;

public class Employee {
    //EMPNO, ENAME, DEPTNO
    private int empNo;
    private String empName;
    private int deptNo;

    public Employee(int empNo, String empName, int deptNo) {
        this.empNo = empNo;
        this.empName = empName;
        this.deptNo = deptNo;
    }

    public Employee() {

    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public int getDeptNo() {
        return deptNo;
    }

    @Override
    public String toString() {
        return "Employee{" + empNo +
                ": '" + empName + '\'' + '}';
    }
}
