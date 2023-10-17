package at.htlpinkafeld.companymanager.dao;

import at.htlpinkafeld.companymanager.dto.Department;
import at.htlpinkafeld.companymanager.presentation.DaoSysException;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    List<Department> doList() throws DaoSysException, SQLException;
    void doDelete(int id) throws DaoSysException, SQLException;
    void doCreate(Department dept) throws DaoSysException, SQLException;
    void doUpdate(Department dept) throws DaoSysException;
}
