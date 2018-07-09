package ch01;

public class WelcomeApp1 {
	
	public static void main(String[] args) {
		// new a thread
		Thread welcomeThread = new Thread(new WelcomeTask());
		
		// start the thread
		welcomeThread.start();
		
		System.out.printf("1. Welcome! I'm %s.%n", Thread.currentThread().getName());
	}
}

class WelcomeTask implements Runnable{

	@Override
	public void run() {
		System.out.printf("2. Welcome! I'm %s.%n", Thread.currentThread().getName());
	}
	
}
