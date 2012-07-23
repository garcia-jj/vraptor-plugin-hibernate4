package br.com.caelum.vraptor.plugin.hibernate4;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.mockito.Mock;

import br.com.caelum.vraptor.environment.DefaultEnvironment;
import br.com.caelum.vraptor.environment.Environment;

public class PluginTest {

    private ConfigurationCreator configurationCreator;
    private Configuration configuration;

    private ServiceRegistryCreator serviceRegistryCreator;
    private ServiceRegistry serviceRegistry;

    private SessionFactoryCreator sessionFactoryCreator;
    private SessionFactory sessionFactory;

    private SessionCreator sessionCreator;
    private Session session;
    
    private @Mock Environment environment;

    @Test
    public void main() {
        buildConfiguration();
        buildServiceRegistry();
        buildSessionFactory();
        buildSession();

        assertFalse(sessionFactory.isClosed());
        assertTrue(session.isOpen());

        destroyObjects();

        assertFalse(session.isOpen());
        assertTrue(sessionFactory.isClosed());
    }

    private void buildConfiguration() {
        configurationCreator = new ConfigurationCreator(environment);
        configurationCreator.create();
        configuration = configurationCreator.getInstance();
    }

    private void buildServiceRegistry() {
        serviceRegistryCreator = new ServiceRegistryCreator(configuration);
        serviceRegistryCreator.create();
        serviceRegistry = serviceRegistryCreator.getInstance();
    }

    private void buildSessionFactory() {
        sessionFactoryCreator = new SessionFactoryCreator(configuration, serviceRegistry);
        sessionFactoryCreator.create();
        sessionFactory = sessionFactoryCreator.getInstance();
    }

    private void buildSession() {
        sessionCreator = new SessionCreator(sessionFactory);
        sessionCreator.create();
        session = sessionCreator.getInstance();
    }

    private void destroyObjects() {
        sessionCreator.destroy();
        sessionFactoryCreator.destroy();
        serviceRegistryCreator.destroy();
    }

}
