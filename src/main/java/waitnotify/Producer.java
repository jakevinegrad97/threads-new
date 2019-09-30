package waitnotify;

import java.util.List;

public class Producer {

	private List<Integer> buffer;
	
	public Producer(List<Integer> buffer) {
		this.buffer = buffer;
	}
	
	public List<Integer> getBuffer() {
		return buffer;
	}
	
	public void produce() {
		synchronized (View.lock) {
			if(buffer.size() == 10) {
				try {
					View.lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			buffer.add(1);
			View.lock.notify();
		}
	}
	
}
