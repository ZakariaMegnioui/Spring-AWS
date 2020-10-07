package spring.with.AWS.demo.Entity;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

public class Emp {

   private int id;
   private String full_name;
   private int salary;

    public Emp() {
    }

    public Emp(int id, String full_name, int salary) {
        this.id = id;
        this.full_name = full_name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public Integer getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }


}
