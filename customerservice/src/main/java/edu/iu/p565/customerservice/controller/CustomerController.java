package edu.iu.p565.customerservice.controller;

import java.util.List;
import edu.iu.p565.customerservice.model.*;
import edu.iu.p565.customerservice.repository.CustomerRespository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
// import edu.iu.p565.customerservice.model.*;

@RestController
@RequestMapping("/customers")

public class CustomerController {

    private CustomerRespository respository;

    public CustomerController(CustomerRespository respository) {
        this.respository = respository;
    }





    @GetMapping
    public List<customer> findALL() {
        return respository.findAll();
    }

    @PostMapping
    public int create(@Valid  @RequestBody customer customer) {
        return respository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody customer customer, @PathVariable int id){
        respository.update(customer,id);
    }

    @DeleteMapping("/{id}")
     public void delete(@PathVariable int id){
        respository.delete(id);
     }
}
