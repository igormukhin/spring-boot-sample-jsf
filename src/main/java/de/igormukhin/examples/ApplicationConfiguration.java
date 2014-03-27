package de.igormukhin.examples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.igormukhin.examples")
public class ApplicationConfiguration {

	@Bean
	public CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		
		Map<String, Object> scopes = new HashMap<>();
		scopes.put(FacesViewScope.NAME, new FacesViewScope());
		
		configurer.setScopes(scopes);
		
		return configurer;
	}
}
