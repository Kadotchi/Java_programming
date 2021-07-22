package ge_JavaP6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
	private Scanner scanner;
	
	public User() {
		this.scanner = new Scanner(System.in);
	}


	public String[] formula_entry() {
		String sFormula;
		String[] sArrayFormula;
		Pattern p=Pattern.compile("[\s]+");//正規表現をコンパイル
		System.out.print("式を入力：");
		sFormula = scanner.nextLine();
		System.out.println(sFormula);
		sFormula = sFormula.trim();//文字列の先頭と最後から空白をとる
		System.out.println(sFormula);
		//sArrayFormula= p.split(sFormula);//半角スペースごとに分ける
		sArrayFormula= sFormula.split("[\s]+");//半角スペースごとに分ける
		int i = 0;
		for (String s : sArrayFormula) {
			System.out.println("sArrayFormula[" + i + "]:" + s);
			i++;
		}
		return sArrayFormula;
	}
}
