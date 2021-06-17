package jp.geng.kadoshima;

import java.util.Scanner;

public class User {
	private int money;//所持金
	private Scanner scanner;
	
	public User() {
		this.money=100;//所持金セット
		this.scanner=new Scanner(System.in);
	}
	
	public void letPay(Dealer dealer) {
		int bet_money;
		dealer.now_card_print();
		System.out.println("所持金:"+this.money);
		bet_money=inputKeyNum(this.money,1);
		System.out.println("掛け金の支払い");

		dealer.setBetMoney(bet_money);//親に掛け金支払い
		this.money -= bet_money;
	}
	
	public boolean bet() {
		System.out.println("賭けますか？　はい:2 いいえ:1");
		if(inputKeyNum(2,1)==2) {
			System.out.println("賭けます");
			return true;
		}else {
			System.out.println("おります。");
			return false;
		}
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void getDivMoney(int div_money) {
		this.money += div_money;
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
				continue;
			}
		}
	}
	
	public boolean revenge() {
		System.out.println("ゲーム続けますか？　はい:1　いいえ:2");
		if(inputKeyNum(2,1)==1) {
			return true;
		}else {
			return false;
		}
	}
	

}
