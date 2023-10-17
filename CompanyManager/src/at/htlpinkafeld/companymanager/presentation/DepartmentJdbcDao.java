package at.htlpinkafeld.companymanager.presentation;

import at.htlpinkafeld.companymanager.dao.DepartmentDao;
import at.htlpinkafeld.companymanager.dto.Department;
import at.htlpinkafeld.companymanager.dao.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentJdbcDao implements DepartmentDao {
        @Override
        public List<Department> doList() throws DaoSysException {
            List<Department> results = new ArrayList<>();
            String sql = "SELECT * FROM dept";
            try (Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
                ResultSet rsDept = stmt.executeQuery(sql)){
                    while (rsDept.next()) {
                        Department dep = new Department();
                        dep.setDeptNum(rsDept.getInt("DEPTNO"));
                        dep.setDeptName(rsDept.getString("DNAME"));
                        dep.setLoc(rsDept.getString("LOC"));
                        results.add(dep);
                    }
            } catch (SQLException e) {
                Logger.getLogger(DepartmentJdbcDao.class.getName()).log(Level.SEVERE, null, e);
                throw new DaoSysException(e.getMessage());
            }
            return results;
        }

        @Override
        public void doDelete(int id) throws DaoSysException, SQLException {
            int delId = id;
            String sqlDelete = "DELETE FROM DEPT WHERE DEPTNO =" + delId;
                try (PreparedStatement stmt = ConnectionManager.getInstance().getConnection().prepareStatement(sqlDelete);) {
                    int result = stmt.executeUpdate();
                    System.out.println("Changed table rows (amount): " + result);
                } catch (SQLException e) {
                    Logger.getLogger(DepartmentJdbcDao.class.getName()).log(Level.SEVERE, null, e);
                    throw new DaoSysException(e.getMessage());
                }
            sqlCommit();
        }
        @Override
        public void doCreate(Department dept) throws DaoSysException, SQLException {
            String sqlCreate = "INSERT INTO DEPT (DNAME, LOC) VALUES "+ " (" + "'" + dept.getDeptName() + "'" + " " +  "," + " "+ "'" + dept.getLoc() + "'" + ")";
            try (PreparedStatement stmt = ConnectionManager.getInstance().getConnection().prepareStatement(sqlCreate);) {
                int result = stmt.executeUpdate();
                System.out.println("Changed table rows (amount): " + result);
            } catch (SQLException e) {
                Logger.getLogger(DepartmentJdbcDao.class.getName()).log(Level.SEVERE, null, e);
                throw new DaoSysException(e.getMessage());
            }
            sqlCommit();
        }

        @Override
        public void doUpdate(Department dept) throws DaoSysException {
            String sqlUpdate = "UPDATE DEPT SET DNAME = " + "'" + dept.getDeptName() + "'" + "," + " " + "LOC = " + "'" + dept.getLoc() + "'" + " " + "WHERE DEPTNO = " + dept.getDeptNum() + ";";
            try (PreparedStatement stmt = ConnectionManager.getInstance().getConnection().prepareStatement(sqlUpdate);) {
                int result = stmt.executeUpdate();
                System.out.println("Changed table rows (amount): " + result);
            } catch (SQLException e) {
                Logger.getLogger(DepartmentJdbcDao.class.getName()).log(Level.SEVERE, null, e);
                throw new DaoSysException(e.getMessage());
            }
            sqlCommit();
        }

        public void sqlCommit() throws DaoSysException {
            String sqlCommit = "COMMIT;";
            try (PreparedStatement stmt = ConnectionManager.getInstance().getConnection().prepareStatement(sqlCommit);) {
                int result = stmt.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(DepartmentJdbcDao.class.getName()).log(Level.SEVERE, null, e);
                throw new DaoSysException(e.getMessage());
            }
        }
}
