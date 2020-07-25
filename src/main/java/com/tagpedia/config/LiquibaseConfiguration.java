package com.tagpedia.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import liquibase.integration.spring.SpringLiquibase;

@Component
@Profile({"!proftest","!jenkinstest"})
public class LiquibaseConfiguration {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:db/changelog.xml");
		liquibase.setDataSource(dataSource);
		return liquibase;
	}
}
