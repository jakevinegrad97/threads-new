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
		buffer.add(1);
	}

}
