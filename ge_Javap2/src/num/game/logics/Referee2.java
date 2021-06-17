package num.game.logics;

public class Referee2 {
	
	private int conp_duplicate_count,duplicate_count;
	private int count;
	
	public void init() {
		this.conp_duplicate_count=0;
		this.duplicate_count=0;
		this.count=0;
	}
	
	public void initCount() {
		this.count=0;
	}


	public boolean judg(User2 user,Cpu2 cpu) {
		
		//初期化
		this.init();
				
		//System.out.println("CPUから数字を聞きました。"+cpu_num);
		
		for(int i=0;i<ConstNumGame.DIZIT;i++) {
			if(user.getNumColum(i)==cpu.getNumColum(i)){
				conp_duplicate_count++;
			}
		}
		
		for(int i=0;i<ConstNumGame.NUM_GAME2_MAXNUM;i++) {
			if((user.getDuplicateConfirmation(i)&&cpu.getDuplicateConfirmation(i))==true){
				duplicate_count++;
			}
		}
		
		this.count++;
		
		if(conp_duplicate_count==ConstNumGame.DIZIT) {
			System.out.println(this.count+"回目での正解です。完全一致です。");
			return true;
		}
		
		System.out.println("数の一致は"+this.duplicate_count+"　桁も一致は"+this.conp_duplicate_count+"となります。");
		return false;

	}

}
