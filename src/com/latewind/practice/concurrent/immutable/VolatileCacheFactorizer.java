package com.latewind.practice.concurrent.immutable;

import java.math.BigInteger;
import java.util.Objects;

public class VolatileCacheFactorizer {
	private volatile OneValueCache cache=new OneValueCache(null, null);
	
	public BigInteger[] service(BigInteger num){
		BigInteger[] factors=cache.getFacotrs(num);
		
		if(Objects.isNull(factors)){
			factors=factors(num);
		cache=new OneValueCache(num, factors);
	}
		return factors;
		
}

	private BigInteger[] factors(BigInteger num) {
		return null;
	}

	
}