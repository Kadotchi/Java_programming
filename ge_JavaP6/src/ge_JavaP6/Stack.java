package ge_JavaP6;

public class Stack {
	private final int STACKSIZE=5;
	
	private long[] stack;
	private int head;
	
	public Stack() {
		this.stack=new long[this.STACKSIZE];
		this.head=0;
	}
	
	public long pop() {
		this.head--;
		return this.stack[this.head+1];
	}
	
	public void push(long num) {
		
	}
	
}
