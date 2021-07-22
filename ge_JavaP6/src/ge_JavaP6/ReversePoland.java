package ge_JavaP6;

import java.util.ArrayList;

public class ReversePoland {

	private User user;
	private Calculator calcu;
	private boolean isON;
	private ArrayList<String> listFormula;

	public ReversePoland() {
		this.user = new User();
		this.calcu = new Calculator();
		this.isON = true;
		this.listFormula=new ArrayList<String>();
	}

	public void start() {
		System.out.println("MAX:"+Long.MAX_VALUE);
		System.out.println("MIN:"+Long.MIN_VALUE);

		do {
			if(this.validExpression(user.formula_entry())) {
				calcu.start(this.listFormula);//演算機に式を送る。
			}else {
				System.out.println("式に問題があります。初期化します。");
				this.calcu.init_stack();
				this.calcu.display_stack();
			}
		}while(this.isON);
	}

	// 引数で式をもらい、正常であればtrueを返す。
	public boolean validExpression(String[] sArrayFormula) {
		long tmp;
		this.listFormula.clear();//リストの初期化
		if(sArrayFormula[0].equals("OFF")) {
			System.out.println("電卓を終了します。");
			this.isON=false;
			return false;
		}else if (sArrayFormula[0].equals("C")){
			System.out.println("スタックを初期化します。");
			this.calcu.init_stack();
			return false;
		}
		int i=0;
		for (String s : sArrayFormula) {
			if(s.matches("[\\+\\-\\*/]{1}")) {
				System.out.print("演算子です。");
			}else {
				System.out.println("sArrayFormula[" + i + "]:" + s);
				try {
					tmp = Long.parseLong(s);
					System.out.println("Longに変換します。");
				} catch (NumberFormatException e) {
					System.out.println("数字のオーバーフローまたは文字が含まれています。");
					return false;
				}finally {
					i++;
				}
			}
			this.listFormula.add(s);
		}
		return true;
	}
	
	public void displey_listFormula() {
		for(String s:this.listFormula) {
			System.out.println(s);
		}
	}

}
