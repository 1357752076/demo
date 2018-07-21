package com.example.demo;

import com.example.demo.bean.Customer2;
import com.example.demo.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created byCaoJieBing on 2018/7/15.
 */

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public Customer2 findByFirstName(String string){
        Customer2 Customer2 = repository.findByFirstName(string);
        return Customer2;
    }

    public List<Customer2> findByLastName(String s){
        List<Customer2> Customer2s = repository.findByLastName(s);
        return Customer2s;
    }
    
    public void save(){
        this.repository.deleteAll();

        // save a couple of Customer2s
        this.repository.save(new Customer2("Alice", "Smith"));
        this.repository.save(new Customer2("Bob", "Smith"));

        // fetch all Customer2s
        System.out.println("Customer2s found with findAll():");
        System.out.println("-------------------------------");
        for (Customer2 Customer2 : this.repository.findAll()) {
            System.out.println(Customer2);
        }
        System.out.println();

        // fetch an individual Customer2
        System.out.println("Customer2 found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(this.repository.findByFirstName("Alice"));

        System.out.println("Customer2s found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer2 Customer2 : this.repository.findByLastName("Smith")) {
            System.out.println(Customer2);
        }
    }
}
