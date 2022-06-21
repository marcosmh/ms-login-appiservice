package mx.com.app.login.apiservice.operaciones.repository;


import mx.com.app.login.apiservice.model.db2.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface Jobs repository.
 */
@Repository
public interface IJobsRepository extends JpaRepository<Jobs, String>  {

}
