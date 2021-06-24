package ge_JavaP6;

public class Calculator {

	private final int STACKSIZE = 5;

	private long[] stack;
	private int head;

	public Calculator() {
		this.stack = new long[STACKSIZE];
		this.head = 0;
	}

	public boolean start(String[] formula) {

		long tmp;

		for (String s : formula) {
			try {
				tmp = Long.parseLong(s);
				if (this.head >= STACKSIZE - 1) {
					if(push(tmp)) {
						break;
					}else {
						System.out.println("正常にPOP");
					}
				}
			} catch (Exception e) {
				if (s.equals("OFF")) {
					return false;
				} else if (s.equals("C")) {
					System.out.println("Cが入力されました。");
					this.head = 0;//スタックの初期化
					break;
				} else if (s.equals("+")) {
					System.out.println("+が入力されました。");
					if(overAddCheck(pop(),pop())) {
						System.out.println("オーバーフロー");
					}else {
						System.out.println("正常に計算");
					}
				} else if (s.equals("-")) {
					System.out.println("-が入力されました。");
					if(overAddCheck(pop(),-1*pop())) {
						System.out.println("オーバーフロー");
					}else {
						System.out.println("正常に計算");
					}
				} else if (s.equals("*")) {
					System.out.println("*が入力されました。");
					if(overMathCheck(pop(),pop())) {
						System.out.println("オーバーフロー");
					}else {
						System.out.println("正常に計算");
					}

				} else if (s.equals("/")) {
					System.out.println("/が入力されました。");
					push(pop()/pop());
				}else {
					System.out.println("ERROR");
				}
			}
		}
		return true;

	}
	
	public boolean push(long num) {
		if (this.head >= STACKSIZE - 1) {
			System.out.println("stackオーバーフロー");
			this.head = 0;//スタックの初期化
			return true;
		}else {
			this.stack[this.head]=num;
			return false;
		}
	}
	
	public long pop() {
		this.head--;
		return this.stack[head+1];
	}

	public boolean overAddCheck(long num1, long num2) {
		try {
			Math.addExact(num1, num2);
			return false;
		} catch (ArithmeticException e) {
			return true;
		}
	}

	public static boolean overMathCheck(long num1, long num2) {
		try {
			Math.subtractExact(num1, num2);
			return false;
		} catch (ArithmeticException e) {
			return true;
		}

	}

}
