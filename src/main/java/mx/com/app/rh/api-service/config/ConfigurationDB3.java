package mx.com.app.login.apiservice.config;

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
 * The type Configuration DB3.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
    entityManagerFactoryRef = "entityManagerFactoryDB3",
    basePackages={
            "mx.com.profuturognp.login20.apiservice.departments.repository"
    },
    transactionManagerRef="transactionManagerDB3"
)
public class ConfigurationDB3 {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationDB3.class);

    /** The ds DB3. */
    @Autowired
    private DataSourceDB3 datasource3;

    /**
     * Instantiates a new Configuration DB3.
     */
    public ConfigurationDB3() {

    }


    /**
     * Hikari config DB3 hikari config.
     *
     * @return the hikari config
     */
    @Bean("hikariConfigDB3")
    public HikariConfig hikariConfigDB3() {
        HikariConfig config = new HikariConfig();
        try {
            LOGGER.info("hikariConfigDB3");
            config.setDriverClassName(datasource3.getDriver());
            config.setJdbcUrl(datasource3.getUrl());
            config.setUsername(datasource3.getUsername());
            config.setPassword(datasource3.getPassword());
            config.setSchema(datasource3.getSchema());
            config.setConnectionTimeout(6000);
            config.setMinimumIdle(5);
            config.setMaximumPoolSize(5);
            config.setIdleTimeout(300000);
            LOGGER.info("Conexion a DB3 [ Ok ] ");
        } catch (Exception e) {
            LOGGER.error("Conexion a DB3 [ Failed ] ");
            LOGGER.error("Error en hikariConfigDB3:  ",e);
        }
        return config;
    }


    /**
     * Third data source data source.
     *
     * @return the data source
     */
    @Bean("thirdDataSource")
    public DataSource thirdDataSource() {
        try {
            return new HikariDataSource(hikariConfigDB3());
        } catch (BeanInstantiationException e) {
            LOGGER.error("BeanInstantiationException en DB3 :: thirdDataSource: ",e);
        } catch(Exception e) {
            LOGGER.error("Exception en DB3 :: thirdDataSource: ",e);
        }
        return null;
    }


    /**
     * Entity manager factory local container entity manager factory bean.
     *
     * @param builder the builder
     * @return the local container entity manager factory bean
     */
    @Bean("entityManagerFactoryDB3")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDB3(EntityManagerFactoryBuilder builder) {
        try {
            return builder
                    .dataSource(thirdDataSource())
                    .packages("mx.com.app.login.apiservice")
                    .persistenceUnit(datasource3.getSchema())
                    .build();
        } catch (PersistenceException e) {
            LOGGER.error("Error en DB3 :: entityManagerFactory: ",e);
            return null;
        }

    }


    /**
     * Transaction manager platform transaction manager.
     *
     * @param emf the emf
     * @return the platform transaction manager
     */
    @Bean("transactionManagerDB3")
    public PlatformTransactionManager transactionManagerDB3(@Qualifier("entityManagerFactoryDB3") EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setDataSource(thirdDataSource());
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        } catch (Exception e) {
            LOGGER.error("Error :: DB3 :: entityManagerFactory: ",e);
            return transactionManager;
        }
    }


}
