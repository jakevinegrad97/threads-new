package waitnotify;

import java.util.List;

public class Consumer {

	private List<Integer> buffer;

	public Consumer(List<Integer> buffer) {
		this.buffer = buffer;
	}

	public List<Integer> getBuffer() {
		return buffer;
	}

	public void consume() {
		synchronized (View.lock) {
			if(buffer.size() == 0) {
				try {
					View.lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			buffer.remove(0);
			View.lock.notify();
		}
	}
}
