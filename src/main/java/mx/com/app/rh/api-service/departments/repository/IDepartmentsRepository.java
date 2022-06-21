package mx.com.app.login.apiservice.departments.repository;



import mx.com.app.login.apiservice.model.db3.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface IDepartmentsRepository.
 */
@Repository
public interface IDepartmentsRepository extends JpaRepository<Departments, Long>  {

}
