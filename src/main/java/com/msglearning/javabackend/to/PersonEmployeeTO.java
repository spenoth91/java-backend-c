package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PersonEmployeeTO implements Serializable {
    Long personID;
    String fullName;
    String address;
    String email;
    String phone;

    Long employeeID;
    Long teamLeaderID;
    Boolean isTeamLeader;
    String Department;
    Long salary;
}