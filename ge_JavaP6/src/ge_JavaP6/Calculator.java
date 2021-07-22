package ge_JavaP6;

import java.util.ArrayList;

public class Calculator {

	private final int STACKSIZE = 5;

	private long[] stack;
	private int head;

	public Calculator() {
		this.stack = new long[STACKSIZE];
		this.head = 0;
	}

	public void start(ArrayList<String> listFormula) {
		long num1 = 0, num2 = 0;
		int i = 0;
		System.out.println("演算機に入りました");
		for (String s : listFormula) {
			if (s.matches("[\\+\\-\\*/]{1}")) {
				System.out.print("演算子です。");
				if (this.head < 2) {
					System.out.println("EROOR->スタックが足りません");
					this.init_stack();
					break;
				} else {
					num2 = this.pop();
					num1 = this.pop();
					System.out.println("スタックから" + num1 + "と" + num2 + "を取り出しました。");
				}

				if (s.equals("+")) {
					if (this.overAddCheck(num1, num2)) {
						System.out.println("正常に計算を行いました。");
					} else {
						System.out.println("計算がオーバーフローします。");
						this.init_stack();
						break;
					}
				} else if (s.equals("-")) {
					if (this.overSubtractionCheck(num1, num2)) {
						System.out.println("正常に計算を行いました。");
					} else {
						System.out.println("計算がオーバーフローします。");
						this.init_stack();
						break;
					}
				} else if (s.equals("*")) {
					if (this.overMathCheck(num1, num2)) {
						System.out.println("正常に計算を行いました。");
					} else {
						System.out.println("計算がオーバーフローします。");
						this.init_stack();
						break;
					}
				} else if (s.equals("/")) {
					if (this.overDivisionCheck(num1, num2)) {
						System.out.println("正常に計算を行いました。");
					} else {
						System.out.println("計算がオーバーフローします。");
						this.init_stack();
						break;
					}
				} else {
					System.out.println("予期せぬ例外");
				}
			} else {
				if (this.STACKSIZE - 1 < this.head) {
					System.out.println("スタックがオーバーフローします。");
					this.init_stack();
					break;
				} else {
					System.out.println("sArrayFormula[" + i + "]:" + s);
					this.push(Long.parseLong(s));
					System.out.println("Longに変換します。");
				}
				i++;
			}
		}
		this.display_stack();
	}

	public void push(long num) {
		System.out.println("プッシュします。");
		this.stack[this.head] = num;
		this.head++;
	}

	public long pop() {
		this.head--;
		return this.stack[this.head];
	}

	public boolean overAddCheck(long num1, long num2) {
		try {
			this.push(Math.addExact(num1, num2));
			return true;
		} catch (ArithmeticException e) {
			return false;
		}
	}

	public boolean overSubtractionCheck(long num1, long num2) {
		try {
			this.push(Math.subtractExact(num1, num2));
			return true;
		} catch (ArithmeticException e) {
			return false;
		}

	}

	public boolean overMathCheck(long num1, long num2) {
		try {
			this.push(Math.multiplyExact(num1, num2));
			return true;
		} catch (ArithmeticException e) {
			return false;
		}

	}

	public boolean overDivisionCheck(long num1, long num2) {
		if (num1 == Long.MIN_VALUE && num2 == -1) {
			System.out.println("計算がオーバーフローします。");
			return false;
		} else {
			try {
				push(Math.round((double)num1 / (double)num2));
				return true;
			} catch (ArithmeticException e) {
				System.out.println("０除算はダメです。");
				return false;
			}
		}
	}

	public void display_stack() {
		if (this.head == 0) {
			System.out.println("スタックは空です。");
		} else {
			for (int i = 0; i < this.head; i++) {
				System.out.println("stack[" + i + "]:" + this.stack[i]);
			}
		}
	}

	public void init_stack() {
		this.head = 0;
		
	}

}
