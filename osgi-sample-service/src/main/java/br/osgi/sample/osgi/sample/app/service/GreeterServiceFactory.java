package br.osgi.sample.osgi.sample.app.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import br.osgi.sample.osgi.sample.app.impl.GreeterImpl;

public class GreeterServiceFactory implements ServiceFactory<Greeter> {

	private int usageCounter = 0;
	
	@Override
	public Greeter getService(Bundle bundle, ServiceRegistration<Greeter> registration) {
        System.out.println("Create object of HelloService for " + bundle.getSymbolicName());
        usageCounter++;
        System.out.println("Number of bundles using service " + usageCounter);
		return new GreeterImpl();
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<Greeter> registration, Greeter service) {
		System.out.println("Removed object of HelloService for " + bundle.getSymbolicName());
		usageCounter--;
		System.out.println("Number of bundles using service " + usageCounter);
	}

}
