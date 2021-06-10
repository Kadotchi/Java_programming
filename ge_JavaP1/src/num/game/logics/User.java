package num.game.logics;

public class User {
	private int num;
	private int range;
		
	public void setNum() {
		System.out.println("入力された数字は"+ num +"です");
		this.num=InputKey.num(ConstNumGame.MAXNUM, 0);	}

	public void setRange() {
		System.out.println("入力された数字は"+ range +"です");
		this.range=InputKey.num(ConstNumGame.MAXNUM,0);
	}

	public int getNum() {
		//System.out.println(this.num+"を渡します。");
		return this.num;
	}
	
	public int getRange() {
		return this.range;
	}
}
