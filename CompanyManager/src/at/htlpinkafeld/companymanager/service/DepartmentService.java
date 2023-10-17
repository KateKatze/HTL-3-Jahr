package at.htlpinkafeld.companymanager.service;

import at.htlpinkafeld.companymanager.dao.DepartmentDao;
import at.htlpinkafeld.companymanager.dto.Department;
import at.htlpinkafeld.companymanager.presentation.DaoSysException;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    public static List<Department> departmentList;
    public static DepartmentDao departmentDao;

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public DepartmentService(DepartmentDao deptDao) throws DaoSysException, SQLException {
        departmentDao = deptDao;
        departmentList = departmentDao.doList();
    }

    public void insertDepartment(Department department) throws DaoSysException, SQLException {
        departmentDao.doCreate(department);
        departmentList.add(department);
        departmentList = departmentDao.doList();
    }

    public void updateDepartment(Department department) throws SQLException, DaoSysException {
        departmentDao.doUpdate(department);
        departmentList = departmentDao.doList();
    }

    public void deleteDepartment(int deptno) throws SQLException, DaoSysException {
        departmentDao.doDelete(deptno);
        for (int i=0; i< departmentList.size(); i++) {
            if (departmentList.get(i).getDeptNum() == deptno) {
                departmentList.remove(i);
            }
        }
    }
}
