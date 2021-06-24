package jp.geng.kadoshima;

public abstract class Vehicle{
	
	private final int COLUMN=100;
	protected  int initDistance;//初期距離
	
	protected double distance;//距離
	protected double speed;//速度
	protected int brake;//ブレーキ
	protected int time;//着陸にかかった時間
	protected boolean isGo;//停止のフラグ
	protected int endDistance;//終了条件の距離
	protected String body;
	
	public Vehicle(){
		this.time=0;
		this.isGo=true;
	}
	
	public void start(Driver driver) {
		do {
			this.Display();
			this.setBreaks(driver);
			this.setDistance();
			this.setSpeed();
			this.time++;
		} while (this.isGo);
		this.Display();
		System.out.println("経過時間"+this.time);
	}
	
	public void Display() {
		int i;
		if (this.isGo) {
			System.out.println("進行中");
			System.out.print("|");
			if(this.COLUMN>(int) this.distance / (this.initDistance / this.COLUMN) ) {
				for (i = 0; i < this.COLUMN; i++) {
					//機体を検知した場合表示
					if (i == (int) this.distance / (this.initDistance / this.COLUMN) ) {
						System.out.print(this.body);
						i += 2;
					}else {
						System.out.print("_");					
					}
				}
				
			}else {
				for (i = 0; i < (int) this.distance / (this.initDistance / this.COLUMN) ; i++) {
					System.out.print("_");
				}
				System.out.print(this.body);

			}
		} else {
			System.out.println("停止");
			System.out.print("|");
			if (this.distance <= 0) {
				System.out.print(this.body.substring(1, 3));
				for (i = 0; i < this.COLUMN; i++) {
					System.out.print("_");
				}
			} else {
				for (i = 0; i < this.COLUMN; i++) {
					if (i == (int) this.distance / (this.initDistance / this.COLUMN) ) {
						System.out.print(body.substring(0, 3));
						i += 2;
					} else {
						System.out.print("_");
					}
				}
			}
		}
		statDisplay();
		
	}
	
	public abstract void setBreaks(Driver driver);
	
	public abstract void setDistance();
	
	public abstract void setSpeed();
	
	public abstract void statDisplay() ;

}
