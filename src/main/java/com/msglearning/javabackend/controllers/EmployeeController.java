package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_EMPLOYEE })
public class EmployeeController {

    private static final String PATH_ALL = "/all";
    private static final String PATH_ID = "/id/{id}";
    private static final String PATH_NEW = "/new";
    private static final String PATH_TEAM_LEADER_ID = "/team-leader-id/{id}";
    private static final String PATH_DEPARTMENT = "/department/{department}";

    @Autowired
    EmployeeService employeeService;

    @GetMapping(PATH_ALL)
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping(PATH_ID)
    public Optional<Employee> getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping(PATH_NEW)
    public Employee newEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping(PATH_TEAM_LEADER_ID)
    public List<Employee> getByTeamLeaderID(@PathVariable Long id) {
        return employeeService.getByTeamLeaderID(id);
    }

    public List<Employee> getByDepartment(@PathVariable String department) {
        return employeeService.getByDepartment(department);
    }
}
