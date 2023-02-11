package com.example.demo.postgres;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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
@EnableJpaRepositories(entityManagerFactoryRef = "PEMF" //
		, transactionManagerRef = "PTM" //
		, basePackages = { "com.example.demo.postgres.repo" })
public class PConfig {

	@Bean(name = "PEMFB")
	public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	@Bean(name = "PDS")
	@ConfigurationProperties(prefix = "p.ds")
	public DataSource ds() {
//		return DataSourceBuilder.create().build();
		return DataSourceBuilder.create() //
				.driverClassName("org.postgresql.Driver") //
				.url("jdbc:postgresql://192.168.0.104:5432/postgres") //
				.username("postgres") //
				.password("postgres") //
				.build();
	}

	@Bean(name = "PJDBC")
	JdbcTemplate jdbcTemplate( //
			@Qualifier("PDS") DataSource ds)
			throws IllegalAccessException, InvocationTargetException, InstantiationException {
		return new JdbcTemplate(ds);
	}

	@Bean(name = "PEMF")
	public LocalContainerEntityManagerFactoryBean emf( //
			@Qualifier("PEMFB") EntityManagerFactoryBuilder builder, //
			@Qualifier("PDS") DataSource ds) {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return builder //
				.dataSource(ds) //
				.packages("com.example.demo.postgres.entity") //
				.persistenceUnit("p") //
				.properties(properties) //
				.build();
	}

	@Bean(name = "PTM")
	public PlatformTransactionManager tm( //
			@Qualifier("PEMF") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
