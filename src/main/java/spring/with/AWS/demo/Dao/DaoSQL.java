package spring.with.AWS.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.with.AWS.demo.Entity.Emp;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("mysql")
public class DaoSQL implements Dao {
    @Autowired
    private  JdbcTemplate jdbcTemplate;


    @Override
    public Emp insert(Emp emp) {

    String  sql = "insert into emp( full_name , salary) "
            +"values('"+emp.getFull_name()+"',"+emp.getSalary()+")";
       jdbcTemplate.update(sql);
          return emp;
    }

    @Override
    public List<Emp> findAll() {

            String sql = "SELECT id , full_name , salary from emp";
        List<Emp>    empList = jdbcTemplate.query(sql, new EmpRowMapper());
            return empList;

    }

    @Override
    public Optional<Emp> findById(int id) {
        String sql = "select *from emp where id ="+id;
        Emp emp = jdbcTemplate.queryForObject(sql,new EmpRowMapper());
        return Optional.ofNullable(emp);
    }

    @Override
    public Emp update(Emp emp, int id) {
        String sql = "update emp" +
                " set full_name ='"+emp.getFull_name()+"',"+
                " salary ="+emp.getSalary()+
                " where id ="+id;
                jdbcTemplate.update(sql);
                return  findById(id).get();
    }

    @Override
    public void deleteById(int id) {
      String sql = "delete from emp where id = "+id;
      jdbcTemplate.update(sql);
    }
}
