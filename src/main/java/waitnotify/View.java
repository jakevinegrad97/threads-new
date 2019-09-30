package waitnotify;

import java.util.ArrayList;
import java.util.List;

public class View {

	private static List<Integer> buffer = new ArrayList<>();
	private static final int SIZE = 100;
	public static final Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		
		Thread producerThread = new Thread(() -> {
			for(int i = 1; i <= SIZE; i++) {
				producer.produce();
				System.out.println("Produced " + i);
			}
			System.out.println("Producing is done");
		});
		
		Thread consumerThread = new Thread(() -> {
			for(int i = 1; i <= SIZE; i++) {
				consumer.consume();
				System.out.println("Consumed " + i);
			}
			System.out.println("Consuming is done");
		});
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		consumerThread.join();
		
		System.out.println("Buffer Size: " + buffer.size());
	}
}
