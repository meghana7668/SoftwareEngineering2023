package edu.iu.p565.customerservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.iu.p565.customerservice.model.customer;


@Repository
public class CustomerRespository {
    
    private List<customer> customers = new ArrayList<>();

    public List<customer> findAll() {
        return customers;
    }

    public int create(customer customer) {
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }
    public void update(customer customer, int id){
        customer x = getCustomerByID(id);
        if(x!= null){
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        }
        else{
            throw new IllegalStateException("Customer Id is invalid");
        }
    }

    private customer getCustomerByID(int id){
        return customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void delete(int id){
        customer x = getCustomerByID(id);
        if(x != null){
          customers.remove(x);
        }
        else{
            throw new IllegalStateException("Customer Id is invalid");
        }
    }
}
