package mx.com.app.rh.api.service.employee.repository;

import mx.com.app.rh.api.service.model.db1.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The Interface IEmployeeRepository.
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
