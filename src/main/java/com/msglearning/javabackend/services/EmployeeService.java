package com.msglearning.javabackend.services;

import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.repositories.EmployeeRepository;
import com.msglearning.javabackend.to.PersonEmployeeTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            return Collections.emptyList();
        } else {
            return employees;
        }
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }


    public List<Employee> getByTeamLeaderID(Long id) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getId().equals(id) || e.getTeamLeaderID().equals(id))
                .collect(Collectors.toList());
    }

    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public Optional<Employee> updateData(Long id, Employee employeeDetails) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isEmpty())
            return Optional.empty();

        Employee employee = employeeOpt.get();

        // shouldn't be able to set the employee id
        employee.setPerson    (employeeDetails.getPerson());
        employee.setDepartment  (employeeDetails.getDepartment());
        employee.setSalary      (employeeDetails.getSalary());
        employee.setTeamLeader  (employeeDetails.isTeamLeader());
        employee.setTeamLeaderID(employeeDetails.getTeamLeaderID());

        return Optional.of(employee);
    }

    public void deleteEmployee(Long id) throws ServiceException {
        employeeRepository.deleteById(id);
    }


    public List<PersonEmployeeTO> getAllEmployeesByPerson(){
        return((List<Employee>) employeeRepository
                .findAll())
                .stream()
                .map(this::convertToEmployeePersonTO)
                    .collect(Collectors.toList());

    }

    private PersonEmployeeTO convertToEmployeePersonTO(Employee employee){
        PersonEmployeeTO personEmployeeTO = new PersonEmployeeTO();
        personEmployeeTO.setEmployeeID(employee.getId());
        personEmployeeTO.setSalary(employee.getSalary());
        personEmployeeTO.setTeamLeader(employee.isTeamLeader());
        personEmployeeTO.setDepartment(employee.getDepartment());

        Person person = employee.getPerson();
        personEmployeeTO.setAddress(person.getAddress());
        personEmployeeTO.setFullName(person.getFullName());
        personEmployeeTO.setNationality(person.getNationality());
        personEmployeeTO.setEmail(person.getEmail());
        personEmployeeTO.setPhone(person.getPhone());

        return personEmployeeTO;
    }

    /*public Long findByPi(Long id){
        return employeeRepository.findByPersonId(id);
    }*/

    public void deleteAll(List<Employee> ids) {
        employeeRepository.deleteAll(ids);
    }
}
