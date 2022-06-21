package mx.com.app.login.apiservice.operaciones.service;

import mx.com.app.login.apiservice.model.db2.Jobs;

import java.util.List;


/**
 * The Interface IJobsService.
 */
public interface IJobsService {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Jobs> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the jobs
     */
    Jobs findById(String id);


}
