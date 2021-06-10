package num.game.logics;

import java.util.Random;

public class Cpu2 {
	
	private int num;
	private int[] num_colum;
	private boolean[] duplicate_confirmation;
	Random rand;
	
	public Cpu2(){
		this.num_colum=new int[ConstNumGame.ISDIZIT];//5桁の数値の確保
		this.duplicate_confirmation=new boolean[ConstNumGame.NUM_GAME2_MAXNUM];//重複チェック用の配列
		this.rand=new Random(ConstNumGame.NUM_GAME2_MAXNUM);
	}
	
	public void  init() {
		for(int i=0;i<ConstNumGame.NUM_GAME2_MAXNUM;i++) {
			this.duplicate_confirmation[i]=false;
			if(i<ConstNumGame.ISDIZIT) {
			this.num_colum[i]=0;
			}
		}
	}
			
	public void setNum() {
		//5桁の数値の作成
		int i=0;

		while(!(i==ConstNumGame.ISDIZIT)){
			this.num_colum[i]=this.rand.nextInt(ConstNumGame.NUM_GAME2_MAXNUM);
			//先頭は0以外
			if(i==0&&this.num_colum[i]==0) {
				continue;
			}
			//重複確認trueだったら生成しなおす
			if(this.duplicate_confirmation[this.num_colum[i]]) {
				continue;
			}
			this.duplicate_confirmation[this.num_colum[i]]=true;
			System.out.println("CPUの入力"+i+"桁目は"+this.num_colum[i]+"です。");
			i++;
		}
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int[] getNumColum() {
		return this.num_colum;
	}
	
	public boolean[] getDuplicateConfirmation() {
		return this.duplicate_confirmation;
	}
	
}
