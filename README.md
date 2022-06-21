# Microservicio RH

## ms-rh-api-service

Microservicio CRUD con operaciones de bases de datos
<br/>

### Especificaciones:
- OpenJDK 11 RedHat Build
- Spring Boot 2.5.12 Red Hat
- Conexión a Bases de Datos Oracle
- Spring JPA
- Swagger
- Hikari


### Employee Service
Contiene los métodos que se utilizan para el CRUD de Empleados.


Method	| Path	                  | Description
------------- |------------------------|-----------------------------------------
GET	| /api/employee	         | Consultar todos los empleados
GET	| /api/employee/{id}	    | Consultar empleado por Id
PATCH| /api/employee	         | Consultar todos los Puestos de Trabajo
POST| /api/employee	         | Guardar Empleado
PUT	| /api/employee	         | Actualizar Empleado
DELETE| /api/employee/{id}	    | Eliminar Empleado por Id


### Opearations Service
Contiene los métodos que se utilizan para el CRUD de las Operaciones.


Method	| Path	  | Description
------------- |--------|-----------------------------------------
GET	| /api/operaciones	 | Consultar todas las operaciones
GET	| /api/operaciones/{id}	 | Consultar las operaciones por Id
POST| /api/operaciones	 | Guardar Operación
PUT	| /api/operaciones	 | Actualizar Operación
DELETE| /api/operaciones/{id}	 | Eliminar Operación por Id




### Run the application
```
mvn spring-boot:run
```