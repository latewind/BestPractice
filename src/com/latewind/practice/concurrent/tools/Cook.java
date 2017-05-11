package com.latewind.practice.concurrent.tools;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Cook {

}

class Kettle extends FutureTask<HotWarter> {

	public Kettle(Callable<HotWarter> callable) {
		super(callable);
	}

}

class HotWarter {

}