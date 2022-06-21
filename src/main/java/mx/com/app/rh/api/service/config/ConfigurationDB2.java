package mx.com.app.rh.api.service.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;

/**
 * The type Configuration app movil.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
    entityManagerFactoryRef = "entityManagerFactoryDB2",
    basePackages={
            "mx.com.app.rh.api.service.operaciones.repository"
    },
    transactionManagerRef="transactionManagerDB2"
)
public class ConfigurationDB2 {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationDB2.class);

    /** The ds app movil. */
    @Autowired
    private DataSourceDB2 datasource2;

    /**
     * Instantiates a new Configuration app movil.
     */
    public ConfigurationDB2() {

    }

    /**
     * Hikari config DB2 hikari config.
     *
     * @return the hikari config
     */
    @Bean("hikariConfigDB2")
    public HikariConfig hikariConfigDB2() {
        HikariConfig config = new HikariConfig();
        try {
            LOGGER.info("hikariConfigDB2");
            config.setDriverClassName(datasource2.getDriver());
            config.setJdbcUrl(datasource2.getUrl());
            config.setUsername(datasource2.getUsername());
            config.setPassword(datasource2.getPassword());
            config.setSchema(datasource2.getSchema());
            config.setConnectionTimeout(6000);
            config.setMinimumIdle(5);
            config.setMaximumPoolSize(5);
            config.setIdleTimeout(300000);
            LOGGER.info("Conexion a DB2 [ Ok ] ");
        } catch (Exception e) {
            LOGGER.error("Conexion a DB2 [ Failed ] ");
            LOGGER.error("Error en hikariConfigDB2:  ",e);
        }
        return config;

    }


    /**
     * Second data source data source.
     *
     * @return the data source
     */
    @Bean("secondDataSource")
    public DataSource secondDataSource() {
        try {
            return new HikariDataSource(hikariConfigDB2());
        } catch (BeanInstantiationException e) {
            LOGGER.error("BeanInstantiationException en DB2 :: secondDataSource: ",e);
        } catch(Exception e) {
            LOGGER.error("Exception en DB2 :: secondDataSource: ",e);
        }
        return null;
    }


    /**
     * Entity manager factory local container entity manager factory bean.
     *
     * @param builder the builder
     * @return the local container entity manager factory bean
     */
    @Bean("entityManagerFactoryDB2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDB2(EntityManagerFactoryBuilder builder) {
        try {
            return builder
                    .dataSource(secondDataSource())
                    .packages("mx.com.app.rh.api.service")
                    .persistenceUnit(datasource2.getSchema())
                    .build();
        } catch (PersistenceException e) {
            LOGGER.error("Error en DB2 :: entityManagerFactory: ",e);
            return null;
        }

    }


    /**
     * Transaction manager platform transaction manager.
     *
     * @param emf the emf
     * @return the platform transaction manager
     */
    @Bean("transactionManagerDB2")
    public PlatformTransactionManager transactionManagerDB2(@Qualifier("entityManagerFactoryDB2") EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setDataSource(secondDataSource());
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        } catch (Exception e) {
            LOGGER.error("Error :: DB2 :: transactionManager: ",e);
            return transactionManager;
        }
    }


}
