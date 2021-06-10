package num.game.logics;

public class NumGame2  {
	User2 user;
	Cpu2 cpu;
	Referee2 referee;
	String rule_file= "ge_p2_rule.txt";
	boolean num_check_flag;

	
	public NumGame2() {
		this.user=new User2();
		this.cpu=new Cpu2();
		this.referee=new Referee2();
	}

	
	public void start() {
		FileLoading.rule("ge_p2_rule.txt");
		do {
			this.referee.initCount();//審判のカウントの初期化
			this.cpu.init();
			System.out.println(this.rule_file);
			this.cpu.setNum();

			do {
				referee.init();//いらない
				do {
				System.out.print("数値を入力。");
				this.user.inputKeyNum(ConstNumGame.ISDIZIT);
				}while(this.user.num_check());
			}while(!this.referee.judg(this.user,this.cpu));
			System.out.println("ゲームを続けますか？　1:はい　2:いいえ");
		}while(this.user.inputKeyNum(2,1,1)==1);
		System.out.println("ゲームを終了します");
	}

}
