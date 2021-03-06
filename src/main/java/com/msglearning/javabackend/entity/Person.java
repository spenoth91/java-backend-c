package com.msglearning.javabackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Represents the personal details for the employees
 * <ul> Fields:
 *     <li>id - represents the primary key, is auto incremented</li>
 *     <li>nationality - person's country of origin</li>
 *     <li>fullName - person's full name</li>
 *     <li>address - home address</li>
 *     <li>email - email address</li>
 *     <li>phone - personal phone number</li>
 * </ul>
 */
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
