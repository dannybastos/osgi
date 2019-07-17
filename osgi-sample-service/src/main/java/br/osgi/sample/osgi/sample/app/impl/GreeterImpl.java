package br.osgi.sample.osgi.sample.app.impl;

import java.util.Hashtable;
import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import br.osgi.sample.osgi.sample.app.service.Greeter;
import br.osgi.sample.osgi.sample.app.service.GreeterServiceFactory;

public class GreeterImpl implements Greeter, BundleActivator {

	Logger log = Logger.getLogger(getClass().getName());
	private ServiceRegistration<Greeter> registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		log.info("Registering service");
		registration = context.registerService(Greeter.class, new GreeterServiceFactory(), new Hashtable<>());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		log.info("Unregistering service");
	}

	@Override
	public String sayHiTo(String name) {
		return "Hi, " + name;
	}

}
