package com.sodep.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

	 @Override
	   public Set<Class<?>> getClasses() {

	      final Set<Class<?>> classes = new HashSet<>();

	      
	      return classes;
	   }

}
