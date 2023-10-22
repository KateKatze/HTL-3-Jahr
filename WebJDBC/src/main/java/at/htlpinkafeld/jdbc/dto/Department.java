package at.htlpinkafeld.jdbc.dto;

import java.util.ArrayList;
import java.util.List;

public class Department {
    //dto / pojo
    // id; deptName...
    private int deptNo;
    private String deptName;
    private String deptLocation;
    public Department() {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }
    public int getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "\n Department{" + deptNo +
                ": " + deptName + " in " + deptLocation + "} \n";
    }
}
