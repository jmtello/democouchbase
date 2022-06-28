package com.jtr.democouchbase.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


//si uso @PropertySource("file:${spring.config.location}") me sobreescribe el application.properties y se arranca en el puerto 8080
//hay que crear un VM argument -Dconfig.properties="application.properties" estando ya previamente definido el VM argument
//spring.config.location
@Configuration
@PropertySource(value = "${config.properties}")
@EnableCouchbaseRepositories(basePackages = { "com.jtr.democouchbase.dao" })
public class CouchbaseConfig extends AbstractCouchbaseConfiguration
{


	@Value("${spring.couchbase.bootstrap-hosts}")
	private String couchbaseHost;

	@Value("${spring.couchbase.bucket.name}")
	private String couchbaseBucket;

	@Value("${spring.couchbase.bucket.password}")
	private String couchbasePassword;
	
	@Override
	protected List<String> getBootstrapHosts()
	{
		return Collections.singletonList(couchbaseHost);
	}

	@Override
	protected String getBucketName()
	{
		return this.couchbaseBucket;
	}

	@Override
	protected String getBucketPassword()
	{
		return this.couchbasePassword;
	}

	@Bean
	public LocalValidatorFactoryBean validator()
	{
		return new LocalValidatorFactoryBean();
	}

}
