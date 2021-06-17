package jp.geng.kadoshima;

public abstract class Vehicle {
	double distance;//距離
	double speed;//速度
	int brake;//ブレーキ
	int time;//着陸にかかった時間
	boolean f_go;//停止のフラグ
	
	public abstract void start(Driver driver) ;

}
