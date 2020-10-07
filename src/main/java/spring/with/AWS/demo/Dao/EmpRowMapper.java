package spring.with.AWS.demo.Dao;

import org.springframework.jdbc.core.RowMapper;
import spring.with.AWS.demo.Entity.Emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public final class EmpRowMapper implements RowMapper<Emp> {
    @Override
    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp emp = new Emp();

      emp.setId((resultSet.getInt("id")));
        emp.setFull_name(resultSet.getString("full_name"));
        emp.setSalary(resultSet.getInt("salary"));
        return emp;
    }
}
