package at.htlpinkafeld.companymanager.presentation;

import at.htlpinkafeld.companymanager.dao.ConnectionManager;
import at.htlpinkafeld.companymanager.dao.DepartmentDao;
import at.htlpinkafeld.companymanager.dto.Department;
import at.htlpinkafeld.companymanager.service.DepartmentService;

import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentUI {
    public static void main(String[] args) throws DaoSysException, SQLException {
        DepartmentDao dao = new DepartmentJdbcDao();
        DepartmentService deptService = new DepartmentService(dao);
        DepartmentUI deptUi = new DepartmentUI(deptService);
        deptUi.startApp();
    }
    private DepartmentService deptService;
    private Scanner scanner = new Scanner(System.in);
    public DepartmentUI(DepartmentService deptService){
        this.deptService = deptService;
    }

    private void doCreate() throws DaoSysException, SQLException {
        System.out.println("Enter the name of the department: ");
        String deptName = scanner.next();
        System.out.println("Enter the location of the department: ");
        String deptLoc = scanner.next();
        Department newDept = new Department();
        newDept.setDeptName(deptName);
        newDept.setLoc(deptLoc);
        this.deptService.insertDepartment(newDept);
        System.out.println("New DB entry has been created.");
    }

    private void doList() {
        for(Department dept: this.deptService.getDepartmentList()){
            System.out.println(dept);
        }
    }

    private void doUpdate() throws SQLException, DaoSysException {
        System.out.println("Enter the number of the department: ");
        int deptNum = scanner.nextInt();
        System.out.println("Enter the name of the department: ");
        String deptName = scanner.next();
        System.out.println("Enter the location of the department: ");
        String deptLoc = scanner.next();
        Department updateDept = new Department();
        updateDept.setDeptNum(deptNum);
        updateDept.setDeptName(deptName);
        updateDept.setLoc(deptLoc);
        this.deptService.updateDepartment(updateDept);
        System.out.println("The entry has been updated.");
    }

    private void doDelete() throws DaoSysException, SQLException {
        System.out.println("Enter the department number to be deleted: ");
        int deptno = scanner.nextInt();
        this.deptService.deleteDepartment(deptno);
        System.out.println("Department #" + deptno + " had been deleted.");
    }

    public void startApp(){
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Company Manager, DB connected");
        do {
            System.out.println("DB navigation (CRUD):  \n Press '1' to create the entry \n Press '2' to show the datatable \n Press '3' to update the entry \n Press '4' to delete the entry \n To exit the DB management, press '5'");
            input = scanner.nextInt();
            try {
                switch (input) {
                    case 1:
                        doCreate();
                        break;
                    case 2:
                        doList();
                        break;
                    case 3:
                        doUpdate();
                        break;
                    case 4:
                        doDelete();
                        break;
                    case 5:
                        System.out.println("DB management is closed");
                        ConnectionManager.closeConnection();
                        break;
                    default:
                        System.out.println("Please, enter number in the range 1-5.");
                }
            } catch( Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        } while(input != 0);
    }
}

