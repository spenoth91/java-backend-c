package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.repositories.EmployeeRepository;
import com.msglearning.javabackend.services.EmployeeService;
import com.msglearning.javabackend.services.PersonService;
import com.msglearning.javabackend.services.UserService;
import com.msglearning.javabackend.to.PE_TO;
import com.msglearning.javabackend.to.PersonEmployeeTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.msglearning.javabackend.controllers.MyResponseEntity.buildErrorMessage;
import static com.msglearning.javabackend.controllers.MyResponseEntity.buildSuccessMessage;

@CrossOrigin
@RestController
@RequestMapping({ ControllerConstants.API_PATH_EMPLOYEE })
public class EmployeeController {

    private static final String PATH_ALL = "/all";
    private static final String PATH_ALL_BY_PERSON = "/all-emp-pers";
    private static final String PATH_ID = "/id/{id}";
    private static final String PATH_NEW = "/new";
    private static final String PATH_TEAM_LEADER_ID = "/team-leader-id/{id}";
    private static final String PATH_DEPARTMENT = "/department/{department}";
    private static final String PATH_UPDATE = "/update/{id}";
    private static final String PATH_DELETE = "/delete/{id}";
    private static final String PATH_DELETE_ALL = "/deleteall";


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
    public Employee newEmployee(@RequestBody PersonEmployeeTO employee) {
        return employeeService.save(employee);
    }

    @GetMapping(PATH_TEAM_LEADER_ID)
    public List<Employee> getByTeamLeaderID(@PathVariable Long id) {
        return employeeService.getByTeamLeaderID(id);
    }

    @GetMapping(PATH_DEPARTMENT)
    public List<Employee> getByDepartment(@PathVariable String department) {
        return employeeService.getByDepartment(department);
    }

//    @PutMapping(PATH_UPDATE)
//    public Optional<Employee> updateData(@PathVariable Long id, @RequestBody Employee employeeDetails) {
//        return employeeService.updateData(id, employeeDetails);
//    }

    @PutMapping(PATH_UPDATE)
    public Optional<Employee> updateData(@PathVariable Long id, @RequestBody PE_TO details) {
        return employeeService.updateData(id, details);
    }

    @GetMapping(PATH_ALL_BY_PERSON)
    public List<PersonEmployeeTO>getAllEmployeesByPerson(){
        List<PersonEmployeeTO>personEmployee = employeeService.getAllEmployeesByPerson();
        return personEmployee;
    }

    @DeleteMapping(PATH_DELETE)
    public MyResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try{
            employeeService.deleteEmployee(id);
            return buildSuccessMessage();
        }catch(ServiceException e){
            return buildErrorMessage(e.getMessage());
        }
    }


    @DeleteMapping(PATH_DELETE_ALL)
    public MyResponseEntity<?> deleteAllEmployees(@RequestBody List<Employee> ids) {
        if (!ids.isEmpty()) {
            try {
                employeeService.deleteAll(ids);
                return buildSuccessMessage("Fired all employees");

            } catch (ServiceException e) {
                return buildErrorMessage(e.getMessage());
            }
        }
        return buildErrorMessage("There is no Employee in your list");
    }
}
