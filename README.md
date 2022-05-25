# java-backend-c
### backend API:
main link: http://localhost:8080/java-api/api

---

Person Controller: /person
- [x] GET: /all
- [x] GET: /id/{id}
- [x] POST: /new + body
- [x] PUT: /update/{id} + body
- [ ] DELETE: /delete/{id}

Body example:
````
{
    "employeeID": 0,
    "password": "secret",
    "fullName": "John Doe",
    "address": "Lake Park nr. 5",
    "email": "johndoe@gmail.com",
    "phone": "0123456789"
}
````

---

Employee Controller: /employee
 - [x] GET: /all
 - [x] GET: /id/{id}
 - [x] GET: /team-leader-id/{id}
 - [x] GET: /department/{department}
 - [x] POST: /new + body
 - [x] PUT: /update/{id} + body
 - [ ] DELETE: /delete/{id}

Body example:
````
// employee example:
{
    "personID": 12,
    "teamLeaderID": 2,
    "isTeamLeader": false,
    "department": "IT",
    "salary": 3000
}

// team leader example:
{
    "personID": 2,
    "teamLeaderID": 0,
    "isTeamLeader": true,
    "department": "IT",
    "salary": 4500
}

// if there is an "id" field, it will not change the employee id
````

---

PersonEmployee Controller: /person-employee
 - [x] GET: /person-id/{id}
 - [x] GET: /employee-id/{id}
