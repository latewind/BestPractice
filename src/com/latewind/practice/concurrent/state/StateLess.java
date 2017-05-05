package com.latewind.practice.concurrent.state;

import java.math.BigDecimal;
/**
 * no state class is thread safe
 * @author Administrator
 *
 */
public class StateLess {
	public Object object=new Object();
	public void service(BigDecimal fist,BigDecimal sed){
		BigDecimal sum=plus(fist, sed);
		System.out.println(sum);
		
	}
	private BigDecimal plus(BigDecimal fist,BigDecimal sed){
		BigDecimal sum;
		sum=fist.add(sed);
		return sum;
	}
	public static void main(String[] args) throws InterruptedException {
		
		StateLess stateLess=new StateLess();
				stateLess.service(new BigDecimal("999999999"), new BigDecimal("1"));
		Thread.sleep(1000000);
		stateLess.object=new Object();
	}

}
