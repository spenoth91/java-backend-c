package com.msglearning.javabackend.to;

import com.msglearning.javabackend.entity.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PE_TO {
    String address;
    String department;
    String email;
    String fullName;
    Long id;
    String nationality;

    Person person;

    String phone;
    Long salary;
    Boolean teamLeader;
    Long teamLeaderId;
}
