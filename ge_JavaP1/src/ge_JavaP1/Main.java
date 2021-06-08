package ge_JavaP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) {
		NumGame a ;
		a= new NumGame();
		a.start();
	}
	
	public static int num(int max ,int min) {
	    InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    //Character character=new Character();
	    String str = null;
	    boolean flag_char=true;//文字が入ってるかどうかのフラグ
	        int num;
	 
	        System.out.println(min+"から"+max+"までの数値を入力してください");
	    try {
	        str = br.readLine();
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    char[] one_char=new char[str.length()] ;//入力された文字の数だけ確保
	    System.out.println("入力された文字：" + str + "　文字の長さは："+str.length());
	    for(int i=0;i<str.length()-1;i++) {
	    	one_char[i]=str.charAt(i);//文字列を一文字ずつ格納
	    	if(!Character.isDigit(one_char[i])) {
	    		System.out.println(one_char[i]+"は文字です。");
	    		flag_char=false;
	    		break;
	    	}
	    }
	    num=Integer.parseInt(str);//文字列を数値変換
		System.out.println("入力された数値:"+num);
	    if(min<=num&&num<=max) {
	    	System.out.println("入力された数値が範囲内です。");
	    	return num;
	    }else {
	    	System.out.println("入力された数値が範囲を超えています。");
	    }
	    
		return 0;
	}
	
}
