package jp.geng.kadoshima;

public class Train extends Vehicle {
	
	public static final int MAXBREAKS=10;//ブレーキの最大
	
	public Train(){
		this.distance=500;
		this.speed=100;
		this.brake=0;
		this.time=0;
		this.f_go=true;
	}
	
	public void start(Driver driver) {
		do {
			Display();
			setBreaks(driver);
			this.distance -= (this.speed+(this.speed-this.brake))/7.2;
			this.speed -= this.brake;
			if(this.speed<=0) {
				this.speed=0;
				this.f_go=false;
			}else if(this.distance<=-10) {
				this.distance=-10;
				this.f_go=false;
			}
		}while(this.f_go);
		Display();
	}
	
	public void Display() {
		if(this.f_go) {
			System.out.println("進行中");
		}else {
			System.out.println("停止");
		}
		System.out.println("速度："+this.speed+"km/h 距離："+(int)this.distance+"m ブレーキ："+this.brake+"（MAX："+MAXBREAKS+"）");
	}
	
	public void setBreaks(Driver driver) {
		int brake;
		System.out.println("2:強く　1:弱く　0:そのまま");
		brake = driver.operation(2,0);
		if(this.brake==MAXBREAKS && brake==1) {
			brake=0;
		}else if(this.brake==0 && brake==-1) {
			brake=0;
		}
		this.brake +=brake;
	};
	
	public void operation_breaks() {
		
	}

}
