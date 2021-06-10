package num.game.logics;

import java.util.Scanner;

public class User2 extends User  {
	
	private int num;
	private int[] num_colum;
	private String num_string;
	private boolean[] duplicate_confirmation;
	
	public User2(){
		this.num_colum=new int[ConstNumGame.ISDIZIT];//5桁の数値の確保
		this.duplicate_confirmation=new boolean[ConstNumGame.NUM_GAME2_MAXNUM];//重複チェック用の配列
	}
	
	public void  init() {
		for(int i=0;i<ConstNumGame.NUM_GAME2_MAXNUM;i++) {
			this.duplicate_confirmation[i]=false;
		}
	}

	
	//キーボードの入力
	public void inputKeyNum(int digits) {
		int num;
		String num_string; 
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println(ConstNumGame.ISDIZIT+"桁の数字を入力してください。");
				num_string=scanner.next();
				if(!(num_string.length()==digits)) {
					System.out.println("ERROR->桁数が不正です。");
					continue;
				}else if(num_string.contains("+")||num_string.contains("-")) {
					System.out.println("ERROR->+や-などの符号入力しないでください。");
					continue;
				}
				System.out.println("入力された数値は"+num_string+"です。");
				num = Integer.parseInt(num_string);
				this.num=num;
				this.num_string=num_string;
			}catch(NumberFormatException e) {
				System.out.println("ERROR->入力が不正です。もう一度。");
				continue;
			}
			break;
		}
	}
	
	public int inputKeyNum(int max,int min,int digits) {
		int num;
		String num_string; 
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println(digits+"桁の数字を入力してください。");
				num_string=scanner.next();
				if(!(num_string.length()==digits)) {
					System.out.println("ERROR->桁数が不正です。");
					continue;
				}else if(num_string.contains("+")||num_string.contains("-")) {
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
				continue;
			}
		}
	}
	
	public boolean num_check() {
		this.init();
		char[] num_char=new char[ConstNumGame.ISDIZIT];
		
		System.out.println("num_check入ります");
		
    	for(int i=0;i<ConstNumGame.ISDIZIT;i++) {
    		num_char[i]=this.num_string.charAt(i);//文字列を一文字ずつ格納
			if(i==0&&num_char[i]=='0') {
				System.out.println("ERROR->1桁目は０にしないでください。");
				return true;
    		}
    		if(this.duplicate_confirmation[Character.getNumericValue(num_char[i])]) {
    			System.out.println("ERROR->重複してる数値があります。");
    			return true;
    		}
    		duplicate_confirmation[Character.getNumericValue(num_char[i])]=true;
    		this.num_colum[i]=Character.getNumericValue(num_char[i]);
    	}
    	System.out.println("falseを返します。");
    	return false;
	}

	public int getNum() {
		return this.num;
	}
	
	public int[] getNumColum() {
		return this.num_colum;
	}
	
	public boolean[] getDuplicateConfirmation() {
		return this.duplicate_confirmation;
	}


}
