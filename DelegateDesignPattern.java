package com.sudharsan.examples;

interface BusinessService {
	void doProcess();
}

class EJBService implements BusinessService {

	@Override
	public void doProcess() {
		System.out.println("EJB Service.");
	}
}

class JMSService implements BusinessService {

	@Override
	public void doProcess() {
		System.out.println("JMS Service.");
	}
}

class LookUpService {
	
	public BusinessService doLookUp(final String type) {
		
		if ("EJB".equals(type)) {
			return new EJBService();
		} else {
			return new JMSService();
		}
	}
}

class BusinessDelegate {
	
	private String serviceType;
	private BusinessService businessService;
	private LookUpService businessLookUp = new LookUpService();
	
	public void setServiceType(final String serviceType) {
		this.serviceType = serviceType;
	}
	
	public void doTask() {
		this.businessService = businessLookUp.doLookUp(this.serviceType);
		this.businessService.doProcess();
	}
}

class Client {
	private BusinessDelegate businessDelegate;
	
	public Client(final BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	public void doTask() {
		this.businessDelegate.doTask();
	}
}

public class DelegateDesignPattern {
	
	public static void main(final String... args) {
		final BusinessDelegate businessDelegate = new BusinessDelegate();
		businessDelegate.setServiceType("EJB");
		
		final Client client = new Client(businessDelegate);
		client.doTask();
		
		businessDelegate.setServiceType("JMS");
		client.doTask();
	}
}