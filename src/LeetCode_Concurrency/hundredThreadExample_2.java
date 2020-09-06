package LeetCode_Concurrency;

/**
 * 100个线程执行i++的情况
 */
public class hundredThreadExample_2 {

	static int i = 0;
	
	private static class AddThread implements Runnable {
		public void run() {
			i++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] t = new Thread[100];
		for (int i = 0; i < 100; i++) {
			t[i] = new Thread(new AddThread());
		}
		for (int i = 0; i < 100; i++) {
			t[i].start();
		}

		System.out.println(i);
	}

}
