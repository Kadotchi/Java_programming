package num.game.logics;

import java.util.Random;

public class Cpu {
	private int num;
	
	public Cpu() {
		
	}
	
	public void setNum() {
		Random rand=new Random();
		this.num=rand.nextInt(100);
		System.out.println("CPUの入力は"+this.num+"です。");
	}
	
	public int getNum() {
		return this.num;
	}
}
