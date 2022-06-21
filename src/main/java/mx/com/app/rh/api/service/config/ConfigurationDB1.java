package mx.com.app.rh.api.service.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


/**
 * The type Configuration Afo GNP.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
    entityManagerFactoryRef = "entityManagerFactoryDB1",
    basePackages={
            "mx.com.app.rh.api.service.employee.repository"
    },
    transactionManagerRef="transactionManagerDB1"
)
public class ConfigurationDB1 {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationDB1.class);

    /** The ds afo GNP. */
    @Autowired
    private DataSourceDB1 datasource1;



    /**
     * Instantiates a new Configuration afo gnp.
     */
    public ConfigurationDB1() {
    }


    /**
     * Hikari config afo gnp hikari config.
     *
     * @return the hikari config
     */
    @Primary
    @Bean("hikariConfigDB1")
    public HikariConfig hikariConfigDB1() {
        HikariConfig config = new HikariConfig();
        try {
            LOGGER.info("hikariConfigDB1");
            config.setDriverClassName(datasource1.getDriver());
            config.setJdbcUrl(datasource1.getUrl());
            config.setUsername(datasource1.getUsername());
            config.setPassword(datasource1.getPassword());
            config.setSchema(datasource1.getSchema());
            config.setConnectionTimeout(6000);
            config.setMinimumIdle(5);
            config.setMaximumPoolSize(5);
            config.setIdleTimeout(300000);
            LOGGER.info("Conexion a DB1 [ Ok ] ");
        } catch (Exception e) {
            LOGGER.error("Conexion a DB1 [ Failed ] ");
            LOGGER.error("Error en hikariConfigDB1:  ",e);
        }
        return config;

    }


    /**
     * Primary data source data source.
     *
     * @return the data source
     */
    @Primary
    @Bean("primaryDataSource")
    public DataSource primaryDataSource() {
        try {
            return new HikariDataSource(hikariConfigDB1());
        } catch (BeanInstantiationException e) {
            LOGGER.error("BeanInstantiationException en DB1 :: primaryDataSource: ",e);
        } catch(Exception e) {
            LOGGER.error("Exception en DB1 :: primaryDataSource: ",e);
        }
        return null;

    }

    /**
     * Entity manager factory local container entity manager factory bean.
     *
     * @param builder the builder
     * @return the local container entity manager factory bean
     */
    @Primary
    @Bean("entityManagerFactoryDB1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDB1(EntityManagerFactoryBuilder builder) {
        try {
            return builder
                    .dataSource(primaryDataSource())
                    .packages("mx.com.app.rh.api.service")
                    .persistenceUnit(datasource1.getSchema())
                    .build();
        } catch (PersistenceException e) {
            LOGGER.error("Error en DB1 :: entityManagerFactory: ",e);
        }
        return null;

    }

    /**
     * Transaction manager platform transaction manager.
     *
     * @param emf the emf
     * @return the platform transaction manager
     */
    @Primary
    @Bean("transactionManagerDB1")
    public PlatformTransactionManager transactionManagerDB1(@Qualifier("entityManagerFactoryDB1") EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setDataSource(primaryDataSource());
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        } catch(PersistenceException e) {
            LOGGER.error("Error :: DB1 :: transactionManager: ",e);
            return transactionManager;
        }

    }

}
