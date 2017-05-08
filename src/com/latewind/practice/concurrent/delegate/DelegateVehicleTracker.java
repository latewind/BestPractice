package com.latewind.practice.concurrent.delegate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class DelegateVehicleTracker {
	public static int DYNAMIC_LOCATION=0;
	public static int STATIC_LOCATION=1;
	private Map<String, InmutablePoint> locations;
	private Map<String, InmutablePoint> unmodifyMap;
	public DelegateVehicleTracker() {
		locations= new HashMap<> ();
		unmodifyMap=Collections.unmodifiableMap(locations);
	}
	
	public  void setLocation(String name,InmutablePoint point){
		
		locations.put(name, point);
	}
	public  InmutablePoint getLocation(String name){
		return locations.get(name);
	}
	
	public  Map<String , InmutablePoint> getLocations(int type){
		if(type==DYNAMIC_LOCATION){
			return unmodifyMap;
		}
		else{
			return Collections.unmodifiableMap(new HashMap<>(locations));
		}
	}
	
}
