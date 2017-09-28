package com.example.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SitemeshConfig {
	
	@Bean
	FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter() {
		FilterRegistrationBean<ConfigurableSiteMeshFilter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
//				builder.addDecoratorPaths("/bootstrap/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPaths("/bootstrap/*", "/WEB-INF/decorators/grid.jsp");
				builder.addDecoratorPaths("/animate/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPaths("/chart/*", "/WEB-INF/decorators/grid.jsp");
			}
		});
		
		filter.setUrlPatterns(Arrays.asList("/bootstrap/*", "/animate/*", "/chart/*"));
		return filter;
	}
   
	// Sitemesh는 Filter로 동작한다. 
	@Bean
	FilterRegistrationBean<Filter> testFilter() {
	   FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
	   filter.setFilter(new Filter() {
		
		@Override
		public void init(FilterConfig arg0) throws ServletException {
			System.out.println("###################");
			System.out.println("## My Filter init()");
			System.out.println("###################");
		}
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			System.out.println("###");
			System.out.println("### My Filter doFilter() start...");
			System.out.println("###");
			chain.doFilter(request, response);
			System.out.println("###");
			System.out.println("### My Filter doFilter() end...");
			System.out.println("###");
		}
		
		@Override
		public void destroy() {
			System.out.println("###################");
			System.out.println("## My Filter destroy()");
			System.out.println("###################");			
		}
	});
	   
	   // mapping된 url만 filter?
	   filter.setUrlPatterns(Arrays.asList("/dept/*", "/emp/*"));
	   return filter;
   }
   
}