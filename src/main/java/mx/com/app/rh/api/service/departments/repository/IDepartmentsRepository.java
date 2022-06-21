package mx.com.app.rh.api.service.departments.repository;



import mx.com.app.rh.api.service.model.db3.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface IDepartmentsRepository.
 */
@Repository
public interface IDepartmentsRepository extends JpaRepository<Departments, Long>  {

}
