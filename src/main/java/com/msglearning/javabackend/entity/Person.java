package com.msglearning.javabackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = Person.TABLE_NAME)
@Entity
public class Person {

    static final String TABLE_NAME = "person";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "pers")
    private Employee employee;

    @Column(nullable = false)
    private String nationality;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;
}
