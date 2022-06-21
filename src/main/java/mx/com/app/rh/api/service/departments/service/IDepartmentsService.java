package mx.com.app.rh.api.service.departments.service;


import mx.com.app.rh.api.service.model.db3.Departments;

import java.util.List;


/**
 * The Interface IDepartmentsService.
 */
public interface IDepartmentsService {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Departments> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the departments
     */
    Departments findById(Long id);


}
