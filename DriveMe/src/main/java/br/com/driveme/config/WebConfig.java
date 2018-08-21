package br.com.driveme.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.driveme.*")
public class WebConfig extends WebMvcConfigurerAdapter {
	
   @Override
   public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
   }
   
   
   @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**/*").addResourceLocations("/WEB-INF/resources/");
	}
}
