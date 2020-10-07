package spring.with.AWS.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.with.AWS.demo.Entity.Emp;
import spring.with.AWS.demo.Services.EmpServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Emp")
public class EmpController {
    @Autowired
    private EmpServices empServices;
    @RequestMapping( method = RequestMethod.GET)
    public List<Emp> findAll(){

        return empServices.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void insert(@RequestBody Emp emp){

        empServices.insert(emp);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
   public Optional getById(@PathVariable  int id){
        return empServices.findById(id);
   }
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public  void deleteById(@PathVariable int id){
      empServices.deleteById(id);
  }
  @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public void update(@RequestBody Emp emp, @PathVariable int id){
        empServices.update(emp,id);
  }
}