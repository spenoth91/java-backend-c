package com.msglearning.javabackend.to;


import com.msglearning.javabackend.entity.Person;

/**
 * <p>Combination of person & employee, made into a Transfer object.</p>
 * <p>The fields are from Employee & Person entities</p>
 */
public class PersonEmployeeTO {
    Long employeeID;
    String fullName;
    String address;
    String email;
    String phone;
    String nationality;

    Boolean teamLeader;
    String department;
    Long salary;

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Boolean teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
