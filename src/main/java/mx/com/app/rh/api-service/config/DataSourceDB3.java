package mx.com.app.login.apiservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * The Class DataSourceBuc.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "buc")
@RefreshScope
public class DataSourceDB3 implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The username. */
    @Value("${spring.datasource3.username}")
    private String username;

    /** Variable password de tipo String. */
    @Value("${spring.datasource3.password}")
    private String password;

    /** Variable driver de tipo String. */
    @Value("${spring.datasource3.driver-class-name}")
    private String driver;

    /** Variable url de tipo String. */
    @Value("${spring.datasource3.url}")
    private String url;

    /** The schema. */
    @Value("${data.db.schema.buc}")
    private String schema;

    /** Variable connectiontime de tipo Long. */
    private Long connectiontime;

    /** Variable poolsize de tipo int. */
    private int poolsize;



    /**
     * Instantiates a new data source buc.
     */
    public DataSourceDB3() {

    }


    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * Sets driver.
     *
     * @param driver the driver
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets connectiontime.
     *
     * @return the connectiontime
     */
    public Long getConnectiontime() {
        return connectiontime;
    }

    /**
     * Sets connectiontime.
     *
     * @param connectiontime the connectiontime
     */
    public void setConnectiontime(Long connectiontime) {
        this.connectiontime = connectiontime;
    }

    /**
     * Gets poolsize.
     *
     * @return the poolsize
     */
    public int getPoolsize() {
        return poolsize;
    }

    /**
     * Sets poolsize.
     *
     * @param poolsize the poolsize
     */
    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }

    /**
     * Gets the schema.
     *
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Sets the schema.
     *
     * @param schema the new schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }
}
