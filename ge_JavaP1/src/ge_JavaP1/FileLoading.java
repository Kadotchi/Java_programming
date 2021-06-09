package ge_JavaP1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoading {
	public static void rule(String path) {
        try {
            //ファイルを読み込む
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ画面出力する
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            //終了処理
            br.close();
            fr.close();

        } catch (IOException ex) {
            //例外発生時処理
            ex.printStackTrace();
        }catch (Exception e) {
        	 
        }
    }

}
