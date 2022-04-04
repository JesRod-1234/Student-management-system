
Jag har utvecklat allt själv från grunden förutom när Luka och jag arbetade tillsammans på email exception. 
- Vi la in den exception där den var relevant, dvs i Create student och Update student metoden i StudentRest.
- Vår tankeprocess gick som så att det är endast där man skriver in email och det är där det kan krocka. 
- Jag har lagt alla metoder som har med exceptions att göra i en klass som heter Exception, och sedan hämtar jag dem där ifrån. 

Jag har testat alla mina endpoints
- Dock fick jag problem med update, den exception är inte dubbelkollad, men är säker på att den fungerar.


Mina endpoints:

createStudent
http://localhost:8080/student-management-system/api/v1/students/new
(Här bakade vi in email exception eftersom vi tänker att det är där det kan krocka när man skriver in ny email)

deleteStudent
http://localhost:8080/student-management-system/api/v1/students/

findStudentById
http://localhost:8080/student-management-system/api/v1/students/

updateStudent - Jsonbody
http://localhost:8080/student-management-system/api/v1/students/update
(Här bakade vi in email exception eftersom vi tänker att det är där det kan krocka när man skriver in ny email)

findByLastname
http://localhost:8080/student-management-system/api/v1/students/findbylastname

Jag ville göra en exception till i metoderna update och create student. "Om användaren råkar skriva in ett id som redan existerar" 
Jag tyckte dock det var svårt att göra två exception i en och samma metod,
men jag kommer att ge mig på detta imorgon. 

Hur som helst finns det en exception i alla relevanta metoder, men säkerligen kommer denna ovan också imorgon. 



