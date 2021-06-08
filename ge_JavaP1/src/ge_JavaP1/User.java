package ge_JavaP1;
import java.util.Scanner;


public class User {
	private int num;
	private int range;
	
	public void setNum() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("数字を入力してください:");
		int num=scanner.nextInt();
		System.out.println("入力された数字は"+ num +"です");
		this.num=num;
	}
	
	public void setNum(int num) {
		System.out.println("入力された数字は"+ num +"です");
		this.num=num;
	}

	
	public void setRange() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("範囲を入力してください:");
		int range=scanner.nextInt();
		System.out.println("入力された数字は"+ range +"です");
		this.range=range;
	}
	
	public void setRange(int range) {
		System.out.println("入力された数字は"+ range +"です");
		this.range=range;
	}

	
	public int getNum() {
		//System.out.println(this.num+"を渡します。");
		return this.num;
	}
	
	public int getRange() {
		return this.range;
	}
}
