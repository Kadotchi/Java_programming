package jp.geng.kadoshima;

public class Train extends Vehicle {

	private final int MAXBRAKE = 10;//ブレーキの最大
	private final int ENDDISTANCE = -10;
	private final int INITDISTANCE = 500;
	private final int INITSPEED=100;

	public Train() {
		this.distance = this.INITDISTANCE;
		this.speed = this.INITSPEED;
		this.brake = 0;
		this.endDistance = this.ENDDISTANCE;
		this.initDistance=this.INITDISTANCE;
		this.body="□□□";
	}

	public void setBreaks(Driver driver) {
		int command_brake;
		System.out.println("2:強く　1:弱く　0:そのまま");
		command_brake = driver.operation(2, 0);
		//弱くを入力された場合
		if (command_brake == 1) {
			command_brake = -1;
		} else if (command_brake == 2) {
			command_brake = 1;
		}
		//ブレーキが最大と最小を超えない処理
		if (this.brake == this.MAXBRAKE && command_brake == 1) {
			command_brake = 0;
		} else if (this.brake == 0 && command_brake == -1) {
			command_brake = 0;
		}
		this.brake += command_brake;
		System.out.println("ブレーキ" + this.brake);

	};


	public void setDistance() {
		this.distance -= (this.speed + (this.speed - this.brake)) / 7.2;
		if (this.distance <= this.endDistance) {
			this.distance = this.endDistance;
			this.isGo = false;
		}
		System.out.println("距離" + (int)this.distance);
	}

	public void setSpeed() {
		this.speed -= this.brake;
		if (this.speed <= 0) {
			this.speed = 0;
			this.isGo = false;
		}
		System.out.println("速度" + this.speed);
	}
	
	public void statDisplay() {
		System.out.println("\n速度：" + this.speed + "km/h 距離：" + (int) this.distance + "m ブレーキ：" + this.brake + "（MAX："
			+ this.MAXBRAKE + "）");
		System.out.println(this.time+"秒　駅まで"+(int)this.distance+"mで停止しました。");
	}
	
	
}
