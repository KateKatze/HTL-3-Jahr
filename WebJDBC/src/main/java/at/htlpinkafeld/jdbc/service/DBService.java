package at.htlpinkafeld.jdbc.service;

import at.htlpinkafeld.jdbc.dto.Department;
import at.htlpinkafeld.jdbc.dto.Employee;
import at.htlpinkafeld.jdbc.infrastructure.DepartmentDao;
import at.htlpinkafeld.jdbc.infrastructure.DepartmentJdbcDao;
import at.htlpinkafeld.jdbc.infrastructure.EmployeeDao;
import at.htlpinkafeld.jdbc.infrastructure.EmployeeJdbcDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {
    DepartmentDao departmentDao;
    List<Department> departments;
    EmployeeDao employeeDao;
    List<Employee> employees;

    public DBService() throws SQLException {
        this.departmentDao = new DepartmentJdbcDao();
        this.departments = departmentDao.list();
        this.employeeDao = new EmployeeJdbcDao();
        this.employees = employeeDao.list();
    }

    public List<Department> list(){
        return departments;
    }

    public List<Employee> getEmpFromDept(Department department){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee : employees){
            if(employee.getDeptNo() == department.getDeptNo()){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}
