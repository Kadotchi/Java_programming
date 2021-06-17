package jp.geng.kadoshima;

public class Rocket extends Vehicle {
	private final static int UNIT_MAXIMUM = 50;
	
	private int file;

	public Rocket() {
		this.distance = 100;
		this.speed = 0;
		this.brake = 250;
		this.time = 0;
		this.f_go = true;
		this.file=0;
	}

	public void start(Driver driver) {
		do {
			Display();
			setBreaks(driver);
			this.distance -= (this.speed + (this.speed - (1.0*this.file)+1.62));
			this.speed += 1.62-(1.0*this.file);
			if (this.distance <= 0) {
				this.distance = 0;
				this.speed = 0;
				this.f_go = false;
			}
		} while (this.f_go);
		Display();
	}

	public void Display() {
		if (this.f_go) {
			System.out.println("進行中");
		} else {
			System.out.println("停止");
		}
		System.out.println("速度：" + this.speed + "km/h 距離：" + (int) this.distance + "m　残燃料数：" + this.brake + "（一度に投下出来る燃料数"+ UNIT_MAXIMUM+ "）");
	}

	public void setBreaks(Driver driver) {
		System.out.println("投下する燃料を入力してください。");
		file = driver.operation(50, 0);
		if (this.brake<UNIT_MAXIMUM ) {
			if(this.brake<file) {
				System.out.println("残燃料数が足りません");
				file=0;
			}
		} else if (UNIT_MAXIMUM<file) {
			System.out.println("一度に投下出来る燃料を超えています。");
			file = 0;
		}
		this.brake -= file;
	};

	public void operation_breaks() {

	}

}
