package jp.geng.kadoshima;

public class Rocket extends Vehicle {
	private final int UNIT_MAXIMUM = 50;
	private final int INITDISTANCE = 100;
	private final int ENDDISTANCE = 0;
	private final int INITHAVEFILE=250;//初期の保持燃料
	
	private int file;
	private boolean isLandingSuccess;

	public Rocket() {
		this.distance = this.INITDISTANCE;
		this.speed = 0;
		this.brake = this.INITHAVEFILE;//所持燃料
		this.file=0;//投下する燃料
		this.endDistance=this.ENDDISTANCE ;
		this.body="=□>";
		this.initDistance=this.INITDISTANCE;
		this.isLandingSuccess=false;
	}

	public void setBreaks(Driver driver) {
		System.out.println("投下する燃料を入力してください。");
		this.file = driver.operation(50, 0);
		if (this.brake<this.UNIT_MAXIMUM ) {
			if(this.brake<this.file) {
				System.out.println("残燃料数が足りません");
				this.file=0;
			}
		} else if (this.UNIT_MAXIMUM<this.file) {
			System.out.println("一度に投下出来る燃料を超えています。");
			this.file = 0;
		}
		this.brake -= this.file;
	};
	
	public void setDistance() {		
		this.distance -= (this.speed + (this.speed - (0.1*this.file)+1.62))/2;
	}
	
	public void setSpeed() {
		this.speed += 1.62-(0.1*this.file);
		if (this.distance <= this.endDistance) {
			if(this.speed<1.0) {
				this.isLandingSuccess=true;
			}
			this.distance = this.endDistance;
			this.speed = 0;
			this.isGo = false;
			//着陸成功の場合
		}
	}

	public void statDisplay() {
		System.out.println("\n速度：" + String.format("%.2f", this.speed) + "km/h 距離：" + (int) this.distance + "m　残燃料数：" + this.brake + "（一度に投下出来る燃料数"+ UNIT_MAXIMUM+ "）");
		if(!isGo) {
			if(this.isLandingSuccess) {
				System.out.println("着陸成功しました。");
			}else {
				System.out.println("着陸失敗しました。");
			}
		}
	}



}
