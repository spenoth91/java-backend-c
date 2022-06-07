package com.msglearning.javabackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Represents employee data related to the company
 * <ul> Fields:
 *     <li>id - represents the primary key, is auto incremented</li>
 *     <li>person - link to personal data</li>
 *     <li>teamLeaderId - the id of the team leader, 0 if it's a team leader</li>
 *     <li>isTeamLeader - tells if it's a team leader</li>
 *     <li>department - department of working (ex: IT, HR, ...)</li>
 *     <li>salary - how much does the employee earn</li>
 * </ul>
 */
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
