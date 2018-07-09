package ch01;

public class JavaThreadAnywhere {

	public static void main(String[] args) {
		// get current thread
		Thread currentThread = Thread.currentThread();

		// get current thread name
		String currentThreadName = currentThread.getName();

		System.out.printf("The main method was executed by thread:%s \n", currentThreadName);

		Helper helper = new Helper("Java Thread AnyWhere");
		helper.run();
	}

}

class Helper implements Runnable {

	private final String message;

	public Helper(String message) {
		this.message = message;
	}

	private void doSomething() {

		// get current thread
		Thread currentThread = Thread.currentThread();

		// get current thread name
		String currentThreadName = currentThread.getName();

		System.out.printf("The doSomething method was executed by thread:%s \n", currentThreadName);

		System.out.println("Do something with " + message);
	}

	@Override
	public void run() {
		doSomething();
	}

}