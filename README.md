# VRaptor Hibernate 4 Plugin

VRaptor Hibernate 4 Plugin provides support to use with Hibernate 4. 


# How to install?

You only need to copy the jar to your classpath. VRaptor will register plugin when 
your application starts without any configurations. Downloads are available in 
<a href="http://repo1.maven.org/maven2/br/com/caelum/vraptor/vraptor-plugin-hibernate4/">here</a> or in Maven Repository:

	<dependency>
	  <groupId>br.com.caelum.vraptor</groupId>
	  <artifactId>vraptor-plugin-hibernate4</artifactId>
	  <version>1.0.0</version> <!--- or the last version --->
	</dependency>

# Environment support

This plugin optional supports VRaptor Environment. If vraptor-environment jar is available in classpath, 
environment supports will be activated.

See instructions here: https://github.com/caelum/vraptor-environment
