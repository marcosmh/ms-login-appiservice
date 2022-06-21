package mx.com.app.login.apiservice.employee.controller;

import java.util.List;

import mx.com.app.login.apiservice.departments.service.IDepartmentsService;
import mx.com.app.login.apiservice.employee.service.IEmployeeService;
import mx.com.app.login.apiservice.model.db1.Employee;
import mx.com.app.login.apiservice.model.db2.Jobs;
import mx.com.app.login.apiservice.model.db3.Departments;
import mx.com.app.login.apiservice.operaciones.service.IJobsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	/** The service. */
	@Autowired
	private IEmployeeService service;

	/** The service jobs. */
	@Autowired
	private IJobsService serviceJobs;

	/** The service departments. */
	@Autowired
	private IDepartmentsService serviceDepartments;




	/**
	 * Consultar empleados.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> consultarEmpleados() {
		LOGGER.info("Peticion recibida para consultar los empleados");
		return new ResponseEntity<List<Employee>>(service.findAll(),HttpStatus.OK);		
	}

	/**
	 * Consultar empleado por id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Employee> consultarEmpleadoPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para consultar empleado por id: " +  id);
		return new ResponseEntity<Employee>(service.findById(id),HttpStatus.OK);		
	}

	/**
	 * Guardar empleado.
	 *
	 * @param employee the employee
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Employee> guardarEmpleado(@RequestBody Employee employee) {
		LOGGER.info("Peticion recibida para guardar Empleado");
		return new ResponseEntity<Employee>(service.save(employee),HttpStatus.OK);
	}

	/**
	 * Actualizar empleado.
	 *
	 * @param employee the employee
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<Employee> actualizarEmpleado(@RequestBody Employee employee) {
		LOGGER.info("Peticion recibida para actualizar empleado");
		return new ResponseEntity<Employee>(service.update(employee),HttpStatus.OK);
	}

	/**
	 * Borrar empleado por id.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/{id}")
	public void borrarEmpleadoPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para borrar Empleado por id: " +  id);
		service.deleteById(id);
	}



	/**
	 * Consultar trabajos.
	 *
	 * @return the response entity
	 */
	@PatchMapping
	public ResponseEntity<List<Jobs>> consultarTrabajos() {
		LOGGER.info("Peticion recibida para consultar los Puestos de Trabajos");
		return new ResponseEntity<List<Jobs>>(serviceJobs.findAll() ,HttpStatus.OK);

	}


	/**
	 * Consultar departamentos por id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@PatchMapping("/{id}")
	public ResponseEntity<Departments> consultarDepartamentosPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para consultar departamentos por id: " +  id);
		return new ResponseEntity<Departments>(serviceDepartments.findById(id),HttpStatus.OK);
	}
	
}
