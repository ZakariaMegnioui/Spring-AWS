package spring.with.AWS.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.with.AWS.demo.Dao.Dao;
import spring.with.AWS.demo.Entity.Emp;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class EmpServices {
    
    @Autowired
    @Qualifier("mysql")
    private Dao dao;
    public List<Emp> findAll(){

        return dao.findAll();
    }

    public void insert(Emp emp){
       // emp.setId(getId()); * this method for Fakedb*
        dao.insert(emp);

    }
    public Optional<Emp> findById(int id){
        try {
            return dao.findById(id);
        }catch (Exception exception){
            return null;
        }

    }
    public void deleteById(int id ){

        dao.deleteById(id);
    }
    public void update(Emp emp,int id){
        dao.update(emp,id);
    }
    //* this method for Fakedb*
    public int getId(){
        Random random = new Random();
        int id = random.nextInt(100);
        Optional<Emp> em = findAll().stream().filter(emp -> emp.getId().equals(id)).findFirst();
        if (em.isPresent()){
            return getId();
        }else {
            return  id;
        }
    }
}
