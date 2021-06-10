package num.game.logics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputKey {
	
	public static int num(int max ,int min) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        //Character character=new Character();
        String str = null;
        boolean flag_illegal=false;//文字が入ってるかどうかのフラグ
        int length=String.valueOf(max).length();
        char[] one_char=new char[length] ;//入力された文字の数だけ確保
        int num;
        
        while(true) {
        	System.out.println(min+"から"+max+"までの数値を入力してください");
        	str=null;
        	//入力
        	try {
        		str = br.readLine();
        		//br.close();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        	
        	//System.out.println("入力された文字：" + str + "　文字の長さは："+str.length());
        	if(length<str.length()) {
        		System.out.println("ERROR->入力文字数がオーバーしてます");
        		continue;
        	}else if(str.length()==0) {
        		System.out.println("ERROR->何も入力されていません。");
        		continue;
        	}
        	for(int i=0;i<str.length();i++) {
        		one_char[i]=str.charAt(i);//文字列を一文字ずつ格納
        		if(!Character.isDigit(one_char[i])) {
        			System.out.println("ERROR->"+one_char[i]+"は文字です。");
        			flag_illegal=true;
        			break;
        		}
        	}
        	if(flag_illegal) {
        		flag_illegal=false;
        		continue;
        	}
        	num=Integer.parseInt(str);//文字列を数値変換
        	//System.out.println("入力された数値:"+num);
        	if(min<=num&&num<=max) {
        		//System.out.println("入力された数値が範囲内です。");
        		break;
        	}else {
        		System.out.println("ERROR->入力された数値が範囲を超えています。");
        		continue;
        	}

        }
        return num;
	}
}
