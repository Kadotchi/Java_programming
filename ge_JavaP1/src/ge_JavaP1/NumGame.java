package ge_JavaP1;

public class NumGame {
	User user;
	Cpu cpu;
	Referee referee;
	
	public NumGame() {
		this.user=new User();
		this.cpu=new Cpu();
		this.referee=new Referee();
	}
	
	public void start() {
		FileLoading.rule("ge_p1_rule.txt");
		do {
			this.referee.initCount();//審判のカウントの初期化
			System.out.println("数字当てゲームを開始します。");
			this.cpu.setNum();
			do {
				System.out.print("数値を入力。");
				this.user.setNum();
				System.out.print("範囲を入力。");
				this.user.setRange();			
			}while(!this.referee.judg(this.user,this.cpu));
			System.out.println("ゲームを続けますか？　1:はい　2:いいえ");
		}while(InputKey.num(2,1)==1);
		System.out.println("ゲームを終了します");
	}
}
