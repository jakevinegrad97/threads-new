package racecondition;

public class Wrapper {

	private long number;
	private static final Object key = new Object();
	
	public Wrapper() {
		this.number = 0;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void iterate() {
		number += 1;
	}
	
}
