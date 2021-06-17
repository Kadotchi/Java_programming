package jp.geng.kadoshima;



public class Trump {
	private static String[] MARK= {"ハート","スペード","クラブ","ダイヤ"};//マーク
	private static String[] NUM= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};//カードの表示数
	private int value;//カードの強さ
	private int mark_num;
//	int next;//次のカードのインデックス番号
	
	public Trump(int mark,int num) {
		this.mark_num=mark;
		this.value=num;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getMarkNum() {
		return this.mark_num;
	}

	public void stats_print() {
		System.out.println(MARK[mark_num]+"の"+NUM[value]);
	}

}
