package com.example.demo.bean;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

/**
 * Created byCaoJieBing on 2018/7/15.
 */
@NodeEntity
public class Customer2 implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    public Customer2() {
    }

    public Customer2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer2[id=%s, firstName='%s', lastName='%s']", this.id,
                this.firstName, this.lastName);
    }
}
