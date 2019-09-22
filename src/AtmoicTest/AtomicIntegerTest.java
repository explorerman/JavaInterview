package AtmoicTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	static AtomicInteger i = new AtomicInteger();
	
	private static class AddThread implements Runnable {
		public void run() {
			for (int k = 0; k < 100; k++) {
				i.incrementAndGet();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] t = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t[i] = new Thread(new AddThread());
		}
		for (int i = 0; i < 10; i++) {
			t[i].start();
		}
		for (int i = 0; i < 10; i++) {
			t[i].join();
		}
		System.out.println(i);
	}

}
