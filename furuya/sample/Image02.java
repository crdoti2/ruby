
//
// Ｉｍａｇｅのプロパティの利用例
//
import java.awt.*;//ウィンドウの表示に必要
import java.awt.event.*;//ウィンドウのイベント処理に必要
import java.awt.image.*;//Imageの取り扱いに必要
import java.io.*;//Imageの読み込み
import javax.imageio.*;//Imageの読み込み

public class Image02 {
	static public void main(String args[]){
		//アプリはここから
		AppCanvas canvas=new AppCanvas();//表示用のキャンバス
		Frame frame=new Frame();//表示用のＦｒａｍｅを作成
		frame.add(canvas);//Ｆｒａｍｅに追加
		frame.addWindowListener(new Adapter());//Listenerを指定
		frame.setSize(240, 240);//サイズ設定
		frame.setVisible(true);//表示
	}
}

//-----------------------------
//  表示用のキャンバス
//------------------------------
class AppCanvas extends Canvas{
	BufferedImage image;//ウィンドウに表示するイメージ
	
	//コンストラクタ
	AppCanvas(){
		image=loadImage("test.gif");//表示用のイメージを取り込み
	}
	
	//イメージをファイルから取り込む
	// 引数　- Imgaeのファイル名
	// 戻り値　- 読み込んだイメージ
	BufferedImage loadImage(String name){
		try{
			FileInputStream in=new FileInputStream(name);//FileInputStreamを作る
			BufferedImage rv=ImageIO.read(in);//イメージを取り込む
			in.close();//閉じる
			return rv;//戻り値に読み込んだイメージをセット
		}catch(IOException e){
			//エラー時の処理（エラーを表示）しnullを返す
			System.out.println("Err e="+e);//エラーを表示
			return null;//null　を返す
		}
	}
	
	//表示の必要があれば実行されるメソッド
	public void paint(Graphics g){
		int sw=getWidth();//画面の幅を取得
		int sh=getHeight();//画面の高さを取得
		int iw=image.getWidth(this);//イメージの幅を取得
		int ih=image.getHeight(this);//イメージの高さを取得
		int x=(sw-iw)/2;//イメージが横中央になる位置を計算
		int y=(sh-ih)/2;//イメージが縦中央になる位置を計算
		g.drawImage(image, x,y,this);//表示
	}
}

//
//WindowAdapterは、WindowListerの機能を持ちますが、
//必要なメソッドだけを書けば、WindowListenerとして使えます
//
class Adapter  extends WindowAdapter {
		//右上の「×」クリックされると呼び出される
		public void windowClosing(WindowEvent e){
			System.exit(0);//アプリの終了
		}
}

