# java-backend-c
## backend API:
main link: http://localhost:8080/java-api/api


Person Controller: /person
- GET: /all
- GET: /id/{id}
- POST: /new   + body
- PUT: /update/{id}
- DELETE: /delete/{id}

.

Employee Controller: /employee
 - GET: /all
 - GET: /id/{id}
 - GET: /team-leader-id/{id}
 - GET: /department/{department}
 - POST: /new   + body
 - PUT: /update/{id}
 - DELETE: /delete/{id}

.

PersonEmployee Controller: /person-employee
 - GET: /person-id/{id}
 - GET: /employee-id/{id}
