package jp.geng.kadoshima;

import java.io.BufferedReader;
import java.io.FileReader;

public class Game {
	Driver driver;
	Vehicle vehicle;
	
	public Game(){
		this.driver=new Driver();
	}
	
	public void start() {
		do {
			if(this.driver.mode()==1) {
				rule("Rule_explanation_p4.txt");
				this.vehicle=new Train();
			}else {
				rule("Rule_explanation_p5.txt");
				this.vehicle=new Rocket();
			}
			this.vehicle.start(this.driver);
		}while(this.driver.revenge());
	}
	
	private void rule(String path) {
        try {
            //ファイルを読み込む
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ画面出力する
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            //終了処理
            br.close();
            fr.close();

        }catch (Exception e) {
        	 
        }
    }
		
}
