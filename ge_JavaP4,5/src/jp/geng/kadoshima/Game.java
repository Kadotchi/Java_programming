package jp.geng.kadoshima;


public class Game {
	Driver driver=new Driver();
	Vehicle vehicle ;
	
	public void start() {
		do {
			if(driver.mode()==1) {
				vehicle=new Train();
			}else {
				vehicle=new Rocket();
			}
			vehicle.start(driver);
		}while(driver.revenge());
	}
		
}
