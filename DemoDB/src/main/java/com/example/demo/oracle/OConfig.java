package com.example.demo.oracle;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "OEMF" //
		, transactionManagerRef = "OTM" //
		, basePackages = { "com.example.demo.oracle.repo" })
public class OConfig {

//	@Bean(name = "OEMFB")
//	public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
//		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
//	}

	@Bean(name = "ODS")
	@ConfigurationProperties(prefix = "o.ds")
	public DataSource ds() {
		return DataSourceBuilder.create() //
				.driverClassName("oracle.jdbc.driver.OracleDriver") //
				.url("jdbc:oracle:thin:@192.168.0.104:1521/ORCLCDB") //
				.username("c##demo") //
				.password("oracle") //
				.build();
//		return DataSourceBuilder.create().build();
	}

	@Bean(name = "OJDBC")
	JdbcTemplate jdbcTemplate(@Qualifier("ODS") DataSource ds)
			throws IllegalAccessException, InvocationTargetException, InstantiationException {
		return new JdbcTemplate(ds);
	}

	@Bean(name = "OEMF")
	public LocalContainerEntityManagerFactoryBean emf(EntityManagerFactoryBuilder builder,
			@Qualifier("ODS") DataSource ds) {
		return builder.dataSource(ds).packages("com.example.demo.oracle.entity").persistenceUnit("o").build();
	}

	@Bean(name = "OTM")
	public PlatformTransactionManager tm(@Qualifier("PEMF") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
