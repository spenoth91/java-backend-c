package com.msglearning.javabackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Table(name = Employee.TABLE_NAME)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    static final String TABLE_NAME = "employee";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JoinColumn(name = "person_id")
//    @Column(name="person_id")
    private Person person;


    @Column(name = "team_leader_id")
    private Long teamLeaderID;

    @Column(name = "is_team_leader", nullable = false)
    private boolean isTeamLeader;


    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Long salary;

}
