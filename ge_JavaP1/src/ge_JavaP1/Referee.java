package ge_JavaP1;

public class Referee {
	private int count;
	
	public void initCount() {
		this.count=0;
	}
	
	public boolean judg(User user,Cpu cpu) {
		int user_num=user.getNum();
		int range=user.getRange();
		int cpu_num=cpu.getNum();
		
		System.out.println("ユーザーから数字を聞きました。"+user_num);
		System.out.println("CPUから数字を聞きました。"+cpu_num);
		
		if(user_num==cpu_num) {
			System.out.println("おめでとうございます。"+this.count+"回目での正解です");
			return true;
		}if((user_num-cpu_num)*(user_num-cpu_num)>(range*range)) {
			System.out.println("不正解です。範囲外です。");
			count++;
			return false;
		}if((user_num-cpu_num)*(user_num-cpu_num)<=(range*range)) {
			System.out.println("不正解です。範囲内です。");
			count++;
			return false;
		}else {
			System.out.println("謎の結果です。");
			return false;
		}

	}
}
