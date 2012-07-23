package br.com.caelum.vraptor.plugin.hibernate4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * Creates a Hibernate {@link Configuration}, once when application starts.
 * 
 * @author Otávio Scherer Garcia
 */
@Component
@ApplicationScoped
public class ConfigurationCreator implements ComponentFactory<Configuration> {

	private Configuration cfg;

	private Environment environment;

	public ConfigurationCreator(Environment environment) {
		this.environment = environment;
	}

	/**
	 * Create a new instance for {@link Configuration}, and after call the
	 * {@link ConfigurationCreator#configureExtras()} method, that you can
	 * override to configure extra guys.
	 */
	@PostConstruct
	protected void create() {

		cfg = new Configuration().configure();

		try {

			Properties hibernateProperties = new Properties();
			InputStream is = environment.getResource("/hibernate.properties").openStream();
			hibernateProperties.load(is);

			getInstance().addProperties(hibernateProperties);

		} catch (IOException e) {
			throw new RuntimeException("Error reading hibernate.properties", e);
		}

		configureExtras();
	}

	/**
	 * This method can override if you want to configure more things.
	 */
	public void configureExtras() {

	}

	public Configuration getInstance() {
		return cfg;
	}
}
