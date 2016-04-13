
//
//  BufferWriterのデモ
//

import java.io.*;//このimport文がファイルの書き込みに必要
public class BufferedWriterDemo {
	public static void main(String args[]){
		try{//例外処理が必要
			FileWriter wr=new FileWriter("file.txt");//Fileとアプリを繋ぐ書き込みでつなぐ
			BufferedWriter br=new BufferedWriter(wr);//BufferedWriterを作成
			br.write("line0");//文字列の書き込み①
			br.newLine();//改行を入れる
			br.write("line1");//文字列の書き込み②
			br.newLine();//改行を入れる
			br.write("line2");//文字列の書き込み③
			br.newLine();//改行を入れる
			br.flush();//flush
			wr.flush();
			br.close();//閉じる
			wr.close();
		}catch(IOException e){
			//例外処理は、エラーを表示
			System.out.println("Err e="+e);
		}
	}
}
