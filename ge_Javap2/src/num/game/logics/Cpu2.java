package num.game.logics;

import java.util.Random;

public class Cpu2 extends Player {
	
	Random rand;
	
	public Cpu2(){
		this.num_colum=new int[ConstNumGame.DIZIT];//5桁の数値の確保
		this.duplicate_confirmation=new boolean[ConstNumGame.NUM_GAME2_MAXNUM];//重複チェック用の配列
		this.rand=new Random();
	}
	
	public void  init() {
		for(int i=0;i<ConstNumGame.NUM_GAME2_MAXNUM;i++) {
			this.duplicate_confirmation[i]=false;
			if(i<ConstNumGame.DIZIT) {
			this.num_colum[i]=0;
			}
		}
	}
			
	public void setNum() {
		this.init();
		//5桁の数値の作成
		int i=0;

		while(!(i==ConstNumGame.DIZIT)){
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
	
	public int inputKeyNum() {
		return 0;
	}
	
}
