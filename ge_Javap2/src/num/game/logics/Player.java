package num.game.logics;

public abstract class Player {
	protected int num;
	protected int[] num_colum;
	protected boolean[] duplicate_confirmation;
	
	public int getNumColum(int i) {
		return this.num_colum[i];
	}
	
	public boolean getDuplicateConfirmation(int i) {
		return this.duplicate_confirmation[i];
	}
	
	public abstract void setNum();
	
}
