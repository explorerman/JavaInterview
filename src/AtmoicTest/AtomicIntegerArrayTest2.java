package AtmoicTest;

import java.util.concurrent.atomic.AtomicIntegerArray;


public class AtomicIntegerArrayTest2 {

	static AtomicIntegerArray ata = new AtomicIntegerArray(10);
	
	private static class AddThread implements Runnable{

		@Override
		public void run() {
			for (int k = 0; k < 10000; k++) {
				ata.getAndIncrement(k % ata.length());  //将第i个下标的元素+1
			}			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] ts = new Thread[10];
		for (int i = 0; i < 10; i++) {
			ts[i] = new Thread(new AddThread());
		}
		for (int i = 0; i < 10; i++) {
			ts[i].start();
		}
		for (int i = 0; i < 10; i++) {
			ts[i].join();
		}
		System.out.println(ata);
	}

}
