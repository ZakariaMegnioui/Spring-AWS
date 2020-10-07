package spring.with.AWS.demo.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring.with.AWS.demo.Entity.Emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@Qualifier("Fakedb")
public class DaoFakeDb implements  Dao{
   public List<Emp> db = new ArrayList<>();

    @Override
    public List<Emp> findAll() {
        return db;
    }
    @Override
    public Emp insert(Emp emp){
       db.add(emp);
       return emp;
    }


    @Override
    public Optional<Emp> findById(int id) {

     Optional<Emp> empOptional= db.stream()
            .filter(emp ->  emp.getId().equals(id)
             ).findFirst();
        return empOptional;
    }

    @Override
    public Emp update(Emp updated,int id) {
     findById(id)
             .map(oldEmp -> {int index = db.indexOf(oldEmp);
             if(index>=0){
                 updated.setId(id);
              db.set(index,updated);}
               return updated;
             });

      return null;

    }

    @Override
    public void deleteById(int id) {
       findById(id).ifPresent(emp -> db.remove(emp));

    }
}
