package br.osgi.sample.osgi.sample.app.tracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import br.osgi.sample.osgi.sample.app.service.Greeter;

public class GreeterServiceTracker extends ServiceTracker<Greeter, Greeter>{

	public GreeterServiceTracker(BundleContext context) {
		super(context, Greeter.class, null);
	}

    public Greeter addingService(ServiceReference<Greeter> reference) {
        System.out.println("Inside HelloServiceTracker.addingService " + reference.getBundle());
        return super.addingService(reference);
    }
    
    public void removedService(ServiceReference<Greeter> reference, Greeter service) {
        System.out.println("Inside HelloServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}
