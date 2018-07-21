package com.example.demo.dao;

import com.example.demo.bean.Customer2;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created byCaoJieBing on 2018/7/15.
 */
@Repository
public interface CustomerRepository extends Neo4jRepository<Customer2,Long> {

    Customer2 findByFirstName(String firstName);

    List<Customer2> findByLastName(String lastName);

}
