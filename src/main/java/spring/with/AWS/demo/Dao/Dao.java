package spring.with.AWS.demo.Dao;

import org.springframework.stereotype.Repository;
import spring.with.AWS.demo.Entity.Emp;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public interface Dao {
    Emp insert(Emp emp);
    List<Emp> findAll();
    Optional<Emp>  findById(int id);
    Emp update(Emp emp,int id);
    void deleteById(int ID);

}
