package mx.com.app.rh.api.service.operaciones.service;

import mx.com.app.rh.api.service.model.db2.Jobs;

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
