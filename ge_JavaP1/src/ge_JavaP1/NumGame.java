package ge_JavaP1;

public class NumGame {
	public void start() {
		User user=new User();
		Cpu cpu=new Cpu();
		Referee referee=new Referee();
		FileLoading.rule("ge_p1_rule.txt");
		do {
			referee.initCount();//審判のカウントの初期化
			System.out.println("数字当てゲームを開始します。");
			cpu.setNum();
			do {
				System.out.print("数値を入力。");
				user.setNum(InputKey.num(100, 0));
				System.out.print("範囲を入力。");
				user.setRange(InputKey.num(100, 0));			
			}while(!referee.judg(user.getNum(),cpu.getNum(),user.getRange()));
			System.out.println("ゲームを続けますか？　1:はい　2:いいえ");
		}while(InputKey.num(2,1)==1);
		System.out.println("ゲームを終了します");
	}
}
