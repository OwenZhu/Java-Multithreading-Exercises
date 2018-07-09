package ch01;

import java.util.Random;

public class ThreadCreateionCmp {

	public static void main(String[] args) {
		Thread t;
		CountingTask ct = new CountingTask();

		// get the number of processes
		final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(numberOfProcessors);
		
		for (int i = 0; i < 2 * numberOfProcessors; i++) {
			// Create Thread
			t = new Thread(ct);
			t.start();
		}

		for (int i = 0; i < 2 * numberOfProcessors; i++) {
			// Create Thread by using subclass
			t = new CountingTread();
			t.start();
		}
	}
}

class Counter {
	private int count = 0;

	public void increment() {
		count++;
	}

	public int value() {
		return count;
	}
}

class CountingTask implements Runnable {

	private Counter counter = new Counter();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			doSomething();
			counter.increment();
		}
		System.out.println("CountingTask:" + counter.value());
	}

	private void doSomething() {
		Tools.randomPause(80);
	}
}

class CountingTread extends Thread {
	private Counter counter = new Counter();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			doSomething();
			counter.increment();
		}
		System.out.println("CountingTask:" + counter.value());
	}

	private void doSomething() {
		Tools.randomPause(80);
	}
}

class Tools {
	public static void randomPause(int time) {
		Random rand = new Random();
		int y = rand.nextInt(time);
		try {
			Thread.sleep(y);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}
}