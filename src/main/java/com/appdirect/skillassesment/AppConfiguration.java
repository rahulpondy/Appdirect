package com.appdirect.skillassesment;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.appdirect.skillassesment.util.OAuthUtil;

@Configuration
public class AppConfiguration {
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public OAuthUtil getoAuthUtil(){
		return new OAuthUtil();
	}

}
