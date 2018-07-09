package ch01;

public class WelcomeApp {

	public static void main(String[] args) {
        // new a thread
        Thread welcomeThread = new WelcomeThread();
        
        // start the thread
        welcomeThread.start();
        
        System.out.printf("1. Welcome! I'm %s.%n", Thread.currentThread().getName());
	}
}

class WelcomeThread extends Thread{
	@Override
	public void run() {
		System.out.printf("2. Welcome! I'm %s.%n", Thread.currentThread().getName());
	}
}