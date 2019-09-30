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
		buffer.remove(0);
	}
}
