package mx.com.app.login.apiservice.departments.service;


import mx.com.app.login.apiservice.model.db3.Departments;

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
