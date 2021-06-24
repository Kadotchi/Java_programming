package jp.geng.kadoshima;
import java.util.Scanner;

public class Driver {
	
	Scanner scanner; 
	
	public Driver() {
		scanner=new Scanner(System.in);
	}
			
	public int inputKeyNum(int max,int min) {
		int num;
		String num_string; 
		
		while(true) {
			try {
				System.out.println("数字を入力してください。");
				num_string=scanner.nextLine();
				if(num_string.contains("+")||num_string.contains("-")) {
					System.out.println("ERROR->+や-などの符号入力しないでください。");
					continue;
				}
				System.out.println("入力された数値は"+num_string+"です。");
				num = Integer.parseInt(num_string);
				if(!(min<=num&&num<=max)) {
					System.out.println("ERROR->数値の範囲が超えています");
					continue;
				}
				return num;
			}catch(NumberFormatException e) {
				System.out.println("ERROR->入力が不正です。もう一度。");
			}
		}
	}

	public int operation(int max,int min) {
		int num;
		String num_string; 
		
		try {
			System.out.println("数字を入力してください。");
			num_string=scanner.nextLine();
			if(num_string.contains("+")||num_string.contains("-")) {
				System.out.println("ERROR->+や-などの符号入力しないでください。");
				return 0;
			}
			System.out.println("入力された数値は"+num_string+"です。");
			num = Integer.parseInt(num_string);
			if(!(min<=num&&num<=max)) {
				System.out.println("ERROR->数値の範囲が超えています");
				return 0;
			}
			
			return num;
		}catch(NumberFormatException e) {
			System.out.println("ERROR->入力が不正です。もう一度。");
			return 0;
		}
	}
	
	public int mode() {
		int mode;
		System.out.println("スタートゲーム　１：電車でGO　２：月面着陸ゲーム");
		mode=inputKeyNum(2,1);
		return mode;
	}
	
	public boolean revenge() {
		System.out.println("ゲームを続けますか？　１：はい　２：いいえ");
		if(inputKeyNum(2,1)==1) {
			return true;
		}else {
			return false;			
		}
	}
	

}
