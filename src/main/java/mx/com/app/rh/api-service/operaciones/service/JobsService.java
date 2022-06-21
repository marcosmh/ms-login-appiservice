package mx.com.app.login.apiservice.operaciones.service;

import mx.com.app.login.apiservice.model.db2.Jobs;
import mx.com.app.login.apiservice.operaciones.repository.IJobsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Class JobsService.
 */
@Service
public class JobsService implements  IJobsService{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JobsService.class);

    /** The repository jobs. */
    @Autowired
    IJobsRepository repositoryJobs;


    /**
     * Find all.
     *
     * @return the list
     */
    @Override
    public List<Jobs> findAll() {
        LOGGER.info("Peticion recibida para consultar los Puestos de Trabajos");
        return repositoryJobs.findAll();
    }


    /**
     * Find by id.
     *
     * @param id the id
     * @return the jobs
     */
    @Override
    public Jobs findById(String id) {
        LOGGER.info("Buscar Puestos de Trabajos por id: " +  id);
        return repositoryJobs.findById(id).orElse(null);
    }

}
