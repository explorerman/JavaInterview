package AtmoicTest;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	static AtomicIntegerArray ata = new AtomicIntegerArray(10);
	
	private static class AddThread implements Runnable{

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				ata.set(i, i);
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		 new Thread(new AddThread()).start();
		 
		 System.out.println(ata.length());
		 
		 for(int i = 0; i < ata.length(); i++){
			 System.out.println(ata.get(i));
		 }
		 
	}

}
