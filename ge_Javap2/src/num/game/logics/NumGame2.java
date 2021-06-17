package num.game.logics;

public class NumGame2  {
	User2 user;
	Cpu2 cpu;
	Referee2 referee;
	String rule_file;
	boolean num_check_flag;

	
	public NumGame2() {
		this.user=new User2();
		this.cpu=new Cpu2();
		this.referee=new Referee2();
		this.rule_file= "ge_p2_rule.txt";
	}

	
	public void start() {
		do {
			FileLoading.rule(this.rule_file);
			this.referee.initCount();//審判のカウントの初期化
			System.out.println(this.rule_file);
			this.cpu.setNum();
			do {
				user.setNum();
			}while(!this.referee.judg(this.user,this.cpu));
			System.out.println("ゲームを続けますか？　1:はい　2:いいえ");
		}while(this.user.inputKeyNum(2,1,1)==1);
		System.out.println("ゲームを終了します");
	}

}
