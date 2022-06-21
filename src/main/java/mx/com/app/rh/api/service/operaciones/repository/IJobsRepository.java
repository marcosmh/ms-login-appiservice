package mx.com.app.rh.api.service.operaciones.repository;


import mx.com.app.rh.api.service.model.db2.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface Jobs repository.
 */
@Repository
public interface IJobsRepository extends JpaRepository<Jobs, String>  {

}
