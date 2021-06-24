package ge_JavaP6;

import java.util.Scanner;

public class User {
	Scanner scanner;
	Calculator calcu;

	
	public User() {
		scanner=new Scanner(System.in);
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
//		ArrayList<String> listFormula=new ArrayList<>();
		System.out.print("式を入力：");
		//scanner.next();
		sFormula=scanner.nextLine();
		sArrayFormula=sFormula.split(" ");
		int i=0;
		for(String s:sArrayFormula) {
			System.out.println("sArrayFormula["+i+"]:"+s);
//			listFormula.add(s);
			i++;
		}
		if(sArrayFormula[0].equals("OFF")) {
			return false;
		}else {
			return true;
		}
		
		//		System.out.println("入力をListにいれました。");
//		scanner.close();
//		//listの表示
//		for(String s : listFormula) {
//			System.out.println(s);
//		}
//		System.out.println("表示終わり");

	}
	
	
	

}
