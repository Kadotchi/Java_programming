package num.game.logics;

public class Referee2 extends Referee {
	
	
	private int user_num;
	private int[] user_num_colum;
	private boolean[] user_duplicate_confirmation;

//	private int cpu_num;
	private int[] cpu_num_colum;
	private boolean[] cpu_duplicate_confirmation;
	
	private int conp_duplicate_count,duplicate_count;
	
	public void init() {
		this.conp_duplicate_count=0;
		this.duplicate_count=0;
	}

	public boolean judg(User2 user,Cpu2 cpu) {
//		user_num=user.getNum();
		user_num_colum=user.getNumColum();
		user_duplicate_confirmation=user.getDuplicateConfirmation();
		
//		cpu_num=cpu.getNum();
		cpu_num_colum=cpu.getNumColum();
		cpu_duplicate_confirmation=cpu.getDuplicateConfirmation();
		
		this.conp_duplicate_count=0;
		this.duplicate_count=0;

		System.out.println("ユーザーから数字を聞きました。"+user_num);
		//System.out.println("CPUから数字を聞きました。"+cpu_num);
		
		for(int i=0;i<ConstNumGame.ISDIZIT;i++) {
			if(user_num_colum[i]==cpu_num_colum[i]){
				conp_duplicate_count++;
			}
		}
		
		for(int i=0;i<ConstNumGame.NUM_GAME2_MAXNUM;i++) {
			if((user_duplicate_confirmation[i]&&cpu_duplicate_confirmation[i])==true){
				duplicate_count++;
			}
		}
		
		super.count++;
		
		if(conp_duplicate_count==ConstNumGame.ISDIZIT) {
			System.out.println(super.count+"回目での正解です。完全一致です。");
			return true;
		}
		
		System.out.println("数の一致は"+this.duplicate_count+"　桁も一致は"+this.conp_duplicate_count+"となります。");
		return false;

	}

}
