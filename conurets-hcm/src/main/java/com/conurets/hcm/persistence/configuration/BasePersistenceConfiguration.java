package com.conurets.hcm.persistence.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.conurets.hcm.persistence")
public class BasePersistenceConfiguration {
    @Autowired
    private Environment environment;
    private String schema = "public";
    private String[] entityPackageName = new String[]{
            "com.conurets.hcm.persistence.entity",
    };

    /**
     * A factory for connections to the physical data source.
     *
     * @return datasource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setSchema(this.schema);
        return dataSource;
    }

    /**
     * Interface used to interact with the entity manager factory for the persistence
     *
     * @return entityManagerFactory
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        //vendorAdapter.setShowSql(Boolean.TRUE);
        vendorAdapter.setDatabasePlatform(environment.getProperty("spring.jpa.properties.hibernate.database-platform"));

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(this.entityPackageName);
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        factory.getJpaPropertyMap().put("hibernate.jdbc.lob.non_contextual_creation", Boolean.TRUE);
        factory.setJpaProperties(jpaProperties());

        return factory.getObject();
    }

    /**
     * Transaction manager implementations. Commit and rollback
     *
     * @return jpaTransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = entityManagerFactory();
        return new JpaTransactionManager(factory);
    }

    /*@Bean
    public AuditorAware<Integer> auditorAware() {
        return new UserAuditorAware();
    }*/

    /**
     * Throw runtime exceptions: JPA
     *
     * @return hibernateExceptionTranslator
     */
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    /**
     * Set jpa properties
     *
     * @return properties
     */
    private Properties jpaProperties() {
        Properties properties = new Properties();
        //properties.put("spring.jpa.hibernate.ddl-auto", "update");
        return properties;
    }
}
