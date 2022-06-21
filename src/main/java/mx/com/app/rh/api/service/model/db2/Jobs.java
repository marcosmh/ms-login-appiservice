package mx.com.app.rh.api.service.model.db2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The type Jobs.
 */
@Entity
@Table(name = "DUMMY_JOBS")
public class Jobs {

    /** The id. */
    @Id
    @Column(name = "JOB_ID", nullable = false)
    private String id;

    /** The job Title. */
    @Column(name = "JOB_TITLE", nullable = false)
    private String jobTitle;

    /** The min Salary. */
    @Column(name = "MIN_SALARY")
    private String minSalary;

    /** The max Salary. */
    @Column(name = "MAX_SALARY")
    private String maxSalary;

    /**
     * Instantiates a new Jobs.
     */
    public Jobs() {

    }

    /**
     * Instantiates a new Jobs.
     *
     * @param id        the id
     * @param jobTitle  the job title
     * @param minSalary the min salary
     * @param maxSalary the max salary
     */
    public Jobs(String id, String jobTitle, String minSalary, String maxSalary) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets job title.
     *
     * @return the job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets job title.
     *
     * @param jobTitle the job title
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Gets min salary.
     *
     * @return the min salary
     */
    public String getMinSalary() {
        return minSalary;
    }

    /**
     * Sets min salary.
     *
     * @param minSalary the min salary
     */
    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    /**
     * Gets max salary.
     *
     * @return the max salary
     */
    public String getMaxSalary() {
        return maxSalary;
    }

    /**
     * Sets max salary.
     *
     * @param maxSalary the max salary
     */
    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }


}
