package com.example.demo.controller;

import com.example.demo.CustomerService;
import com.example.demo.bean.Customer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created byCaoJieBing on 2018/7/15.
 */

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("get")
    public String aa(@RequestParam(value = "firstName") String firstName){
        System.out.println(firstName);
        Customer2 customer2 = service.findByFirstName(firstName);
        System.out.println(customer2.toString());
        Customer2 customer21=new Customer2("AAA","aaa");
        return customer2.toString();
    }

    @GetMapping("save")
    public void save(){
        service.save();

    }


}
