package com.haywood.dog.config;

public interface DataType {
	
	enum ServiceType{
		PUP("Puppy Preschool"),
		OB1("Basic Obedience 101"),
		OB2("Basic Obedience 102"),
		OFF("Off-Lead Training"),
		CONS("Behavioral Consultation");
		
		private final String serviceType;
		
		private ServiceType (String serviceType){
			this.serviceType = serviceType;
		}

		public String getServiceType() {
			return serviceType;
		}		
	}
}
