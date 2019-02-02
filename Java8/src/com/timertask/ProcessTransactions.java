package com.timertask;

import java.util.Date;
import java.util.TimerTask;

public class ProcessTransactions extends TimerTask {

	@Override
	public void run() {
		Date date = new Date(System.currentTimeMillis());
		System.out.println("Transaction creation starts at " + date);
		for (int i = 1; i < 4; i++) {
			System.out.println(i + " transaction created");
		}
		System.out.println("Transaction creation ends at " + date);
	}

}
