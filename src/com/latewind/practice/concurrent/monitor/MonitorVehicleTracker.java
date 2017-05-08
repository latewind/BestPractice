package com.latewind.practice.concurrent.monitor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MonitorVehicleTracker {
	private Map<String,MutablePoint> locations=new HashMap<>();
	
	public synchronized void setLocation(String name,MutablePoint point){
		
		locations.put(name, point);
	}
	public synchronized MutablePoint getLocation(String name){
		return locations.get(name);
	}
	
	public synchronized Map<String , MutablePoint> getLocations(){
		
		return deepCopy(locations);
	}
	
	private static Map<String, MutablePoint> deepCopy(Map<String , MutablePoint>  locations){
		HashMap<String , MutablePoint> newLocations=new HashMap<>();
		for(Entry<String, MutablePoint> e:locations.entrySet()){
			newLocations.put(e.getKey(), new MutablePoint(e.getValue().getX(), e.getValue().getY()));
		}
		return Collections.unmodifiableMap(newLocations);
		
		
	}
	
}
