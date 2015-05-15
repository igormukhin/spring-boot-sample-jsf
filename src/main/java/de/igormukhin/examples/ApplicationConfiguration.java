package de.igormukhin.examples;

import java.util.Collections;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.igormukhin.examples")
public class ApplicationConfiguration {
    
    @Bean
    public FacesViewScope facesViewScope() {
        return new FacesViewScope();
    }

	@Bean
	public CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(Collections.<String, Object>singletonMap(
                FacesViewScope.NAME, facesViewScope()));
		return configurer;
	}
}
