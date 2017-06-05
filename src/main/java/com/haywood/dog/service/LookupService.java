package com.haywood.dog.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.haywood.dog.config.DataType.ServiceType;

@Component
public class LookupService {
	
	public Map<String, String> getServices(){
    	Map<String, String> serviceTypes = new LinkedHashMap<String, String>();
    	for(ServiceType serviceType : ServiceType.values()){
    		serviceTypes.put(serviceType.name(), serviceType.getServiceType());
    	}    	
    	return serviceTypes;    	
    }
}
