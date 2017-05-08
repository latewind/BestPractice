package com.latewind.practice.concurrent.immutable;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

public class OneValueCache {
	private final BigInteger lastNumber;
	private final BigInteger[] factors;

	public OneValueCache(BigInteger lastNumber, BigInteger[] factors) {
		this.lastNumber = lastNumber;
		this.factors = Arrays.copyOf(factors, factors.length);
	}
	
	public BigInteger[] getFacotrs(BigInteger lastNum){
		if(lastNum==null||!Objects.equals(lastNumber, lastNum))
			return null;
		return Arrays.copyOf(factors, factors.length);
	}	

}
