package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.to.PersonEmployeeTO;

public class Helper {
    public static final PersonEmployeeTO convertToPersonEmployeeTO(Person person, Employee employee){
        return new PersonEmployeeTO(
                person.getId(),
                person.getFullName(),
                person.getAddress(),
                person.getEmail(),
                person.getPhone(),
                employee.getId(),
                employee.getTeamLeaderID(),
                employee.isTeamLeader(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}
