package AtmoicTest;
import java.util.concurrent.atomic.*;
public class AtomicIntegerFieldUpdaterTest {
	
	public static class Candidate{
		int id;
		volatile int score;
	} 

	public final static	AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
	
	public static AtomicInteger allScore = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		final Candidate stu = new Candidate();
		Thread[] ts = new Thread[10000];
		for (int i = 0; i < 10000; i++) {
			ts[i] = new Thread(){
				public void run() {
					if(Math.random() > 0.4){
						scoreUpdater.incrementAndGet(stu);
						allScore.incrementAndGet();
					}
				};
			};
			ts[i].start();
		}
		
		for (int i = 0; i < 10000; i++) {
			ts[i].join();
		}
		System.out.println("score = " + stu.score);
		System.out.println("allScore = " + allScore);
	}

}
