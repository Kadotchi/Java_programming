package ge_JavaP6;

import java.util.ArrayList;
import java.util.Scanner;


public class User {
	private Scanner scanner;
	private String[] sArrayFormula;
	private ArrayList<String> listFormula;
	

	
	public User() {
		this.scanner=new Scanner(System.in);
		//this.sArrayFormula=new String[];
		this.listFormula=new ArrayList<>();
	}
	
	public void calculator() {
		
		while(this.formula_entry()) {
			//式チェック
			System.out.println("計算します 。");
//			this.formula_entry();
//			this.formula_entry()
//			calcu.start(this.sArrayFormula);
		}

	}
	
	public boolean formula_entry() {
		String sFormula;
		String[] sArrayFormula;
		long tmp;
		//listFormulaの初期化
		System.out.print("式を入力：");
		//scanner.next();
		sFormula=scanner.nextLine();
		sArrayFormula=sFormula.split(" ");
		int i=0;
		for(String s:sArrayFormula) {
			System.out.println("sArrayFormula["+i+"]:"+s);
			listFormula.add(s);
			try {
				tmp=Long.parseLong(s);
				
			}catch(NumberFormatException e){
				System.out.println("オーバーフロー");
			}
			i++;
		}
		for(String s : listFormula) {
			System.out.println(s);
		}
		if(sArrayFormula[0].equals("OFF")) {
			return false;
		}else {
			return true;
		}
		
		//		System.out.println("入力をListにいれました。");
//		scanner.close();
//		//listの表示
//		System.out.println("表示終わり");

	}
	
	public ArrayList<String> getListFormula() {
		return this.listFormula;
	}
	
	
	

}
