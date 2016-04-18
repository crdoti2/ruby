//
//  Canvasのテストです。
//
import java.awt.*;//FrameやCanvasを使うのに必要なimport文
import java.awt.event.*;//FrameやCanvasのイベント処理に必要

public class CanvasTest {
	public static void main(String args[]){
		//アプリはここから実行されます。
		Frame frame=new Frame();//Frameを作成
		AppCanvas canvas=new AppCanvas();//Canvasの継承クラスのAppCanvasを作成
		frame.add(canvas);//canvasをフレームに追加
		frame.addWindowListener(new Adapter());//Windowのイベントの処理先を指定
		frame.setSize(240,240);//サイズを指定
		frame.setVisible(true);//表示
	}
}

//
// Canvasは継承クラスAppCanvas
//  ★Canvasの継承クラス内中の
//　　　public void paint(Graphics g)
//  は描画の必要が生じると、自動で呼びだれます。
class AppCanvas extends Canvas{
	//以下に描画したい内容を書く
	public void paint(Graphics g){
		g.drawString("Canvas Test", 0, 120);//文字を表示
	}
}

//
// WindowAdapterは、WindowListerの機能を持ちますが、
//　必要なメソッドだけを書けば、WindowListenerとして使えます
class Adapter  extends WindowAdapter {
		//右上の「×」クリックされると呼び出される
		public void windowClosing(WindowEvent e){
			System.exit(0);//アプリの終了
		}
}
