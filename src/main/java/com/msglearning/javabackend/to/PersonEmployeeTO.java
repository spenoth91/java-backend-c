package com.msglearning.javabackend.to;

import com.msglearning.javabackend.entity.Person;

public class PersonEmployeeTO {
    Long employeeID;
    String fullName;
    String address;
    String email;
    String phone;
    String nationality;

    Boolean isTeamLeader;
    String Department;
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
        return isTeamLeader;
    }

    public void setTeamLeader(Boolean teamLeader) {
        isTeamLeader = teamLeader;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
