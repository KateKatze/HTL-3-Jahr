package at.htlpinkafeld.companymanager.dto;

public class Department {
    private int deptNum;
    private String deptName;
    private String loc;

    public int getDeptNum() {
            return deptNum;
    }

    public void setDeptNum(int deptNo) {
        this.deptNum = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Department number: " + deptNum +", Name: " + deptName + '\'' + ", Location: '" + loc + '\'';
    }
}
