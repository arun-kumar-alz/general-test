package arun.snyk.scan.repository;

import arun.snyk.scan.domain.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeRepo {

    private DataSource dataSource;

    public ResultSet getEmployeeByAddress(String address) throws SQLException {
        String sql = "select * from employee where employee_address = '"+address+"'";
        Connection c = dataSource.getConnection();
        ResultSet rs = c.prepareStatement(sql).executeQuery();
        return rs;
    }
}
