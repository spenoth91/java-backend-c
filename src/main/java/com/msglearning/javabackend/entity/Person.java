package com.msglearning.javabackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Table(name = Person.TABLE_NAME)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    static final String TABLE_NAME = "person";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonBackReference
//    @OneToOne(mappedBy = "pers")
//    private Employee employee;

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
