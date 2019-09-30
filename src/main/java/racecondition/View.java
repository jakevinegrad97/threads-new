package racecondition;

public class View {

	public static void main(String[] args) throws InterruptedException {
		Wrapper number = new Wrapper();
		Runnable task = () -> {
			for(int i = 0; i < 1000; i++)
				number.iterate();
		};
		
		Thread[] threads = new Thread[1000];
		for(int i = 0; i < 1000; i++) {
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		for(Thread thread : threads) {
			thread.join();
		}
		
		System.out.println("Value: " + number.getNumber());
		
 	}
}
