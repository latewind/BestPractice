package com.latewind.practice.jvm;

import java.util.ArrayList;
/**
 * VM Args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author hasee
 *
 */
public class HeepOOM {
	static class OOMObject{
		
	}
	public static void main(String[] args){
		ArrayList<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}

}
