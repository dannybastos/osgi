package br.osgi.sample.client;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import br.osgi.sample.osgi.sample.app.service.Greeter;
import br.osgi.sample.osgi.sample.app.tracker.GreeterServiceTracker;

public class Client implements BundleActivator{
	private Logger log = Logger.getLogger(getClass().getName());
    private GreeterServiceTracker serviceTracker;
	
	@Override
	public void start(BundleContext context) throws Exception {
		log.info("start");
		serviceTracker = new GreeterServiceTracker(context);
		serviceTracker.open();
		Greeter service = serviceTracker.getService();
		String sayHiTo = service.sayHiTo("Jonh");
		log.info(sayHiTo);
		System.out.println(sayHiTo);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("stop");
		System.out.println("stop");
		serviceTracker.close();
	}

}
