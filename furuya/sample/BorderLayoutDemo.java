//
//　 コンポーネント応答の利用例
//

import java.awt.*;//Winodwを作りのにJava　Awt　を使う
import java.awt.event.*;//Envent管理に使う
public class BorderLayoutDemo {
	public static void main(String args[]){
		//このしたからアプリが始まります。
		new WindowTest();//これで制御をWindowTestクラスに移す	
	}
}

//
//WindowTest クラスは, Windowの表示を行います。
//
//Windowのコンポーネント応答の例
//
class WindowTest extends Frame implements WindowListener,ActionListener{
	
	//表示用のコンポーネント
	Label  label;//Label型変数　labelを宣言
	Button buttonｓ[]=new Button[16];//Button型の配列　buttonsを宣言
	Panel panel;//Panel型の変数を宣言
	//Button用のラベル
	String buttonLabels[]=
		{"7","8","9","[+]",
		 "4","5","6","[-]",
		 "1","2","3","[×]",
		 "0",".","Ent","[÷]"
		};
	
	//押されたボタンなどを記録する変数
	String regA;//前の入力結果
	String regB;//現在の入力結果
	
	
	//コンストラクタ
	WindowTest(){
		int i;
		
		//regA,regBをクリア
		regA="";
		regB="";
		
		//Windowを作る
		addWindowListener(this);//リスナーの設定
		setSize(240, 240);//サイズを指定す
		setLayout(new BorderLayout() );//BorderLayout設定
		
		//WIndowにLabelを追加する。
		label=new Label(regB);//表示用部品に初期値をセット
		add(label,BorderLayout.NORTH);//表示用の部品をWindow「上」に追加
		
		//Paneの生成とレイアウト設定
		panel=new Panel();//Panelの生成
		panel.setLayout(new GridLayout(4,4));//panelにGridLayout設定
		
		//Buttonの生成と追加
		for(i=0;i<16;i++){
			buttonｓ[i]=new Button(buttonLabels[i]);//Buttonの生成
			buttonｓ[i].addActionListener(this);//ActionListenerをセット
			panel.add(buttonｓ[i]);//生成したボタンをパネルに追加
		}
		
		add(panel,BorderLayout.CENTER);//パネルの「中央」に追加
		
		setVisible(true);//可視化する
	}

	//-------------------------------------------------
	// 以下のメソッドは、Windowに変化があったときに自動で実行されます。
	//( WindowListenerが要求したメソッド）
	//-------------------------------------------------
	
	//アクティブになった特の処理
	public void windowActivated(java.awt.event.WindowEvent e) {
		System.out.println("Activated");
	}

	//閉じられた時の処理
	public void windowClosed(java.awt.event.WindowEvent e) {
		System.out.println("Closed");
	}

	//閉じられている時の処理
	public void windowClosing(java.awt.event.WindowEvent e) {
		System.out.println("Closing");
		System.exit(0);//アプリの終了
	}

	//アクティブでなくなったときの処理
	public void windowDeactivated(java.awt.event.WindowEvent e) {
		System.out.println("Deactivaed");	
	}

	//アイコンから戻ったときの処理
	public void windowDeiconified(java.awt.event.WindowEvent e) {
		System.out.println("Deicnified");
	}

	//アイコン化された時の処理
	public void windowIconified(java.awt.event.WindowEvent e) {
		System.out.println("Icnified");
	}

	// 開かれた時の処理
	public void windowOpened(java.awt.event.WindowEvent e) {
		System.out.println("Opend");
	}

	//-------------------------------------------
	//  ボタンが押されたとき呼び出されるメソッド
	//--------------------------------------------
	public void actionPerformed(ActionEvent e) {
		Button bt=(Button)e.getSource();//押されたボタンを取得
		String lbl=bt.getLabel();//ボタンのラベルを取得
		double a,b,c;//途中計算に使うdouble型変数
		if (lbl.length()==1){
			//ラベルが１文字なら
			regB=regB+lbl;//regAに加える
		}else if(lbl.equals("Ent")){
			//ラベルがEntなら
			regA=regB;//regBをregAにセット
			regB="";//regBをクリア
		}else{
			//ラベルが四則演算なら、演算を実施
			//Errが出る可能性があるので、例外処理を追加
			try{
				c=0;//計算結果を０にする（初期化しないとエラーが出る）
				a=Double.parseDouble(regA);//regAを数値に変換
				b=Double.parseDouble(regB);//regBを数値に変換
				
				if (lbl.equals("[+]")) c=a+b;//[+]ボタンが押されたら加算を実施
				if (lbl.equals("[-]")) c=a-b;//[－]ボタンが押されたら引き算を実施
				if (lbl.equals("[×]")) c=a*b;//[×]ボタンが押されたら掛け算を実施
				if (lbl.equals("[÷]")) c=a/b;//[÷]ボタンが押されたら掛け算を実施
				
				regB=String.valueOf(c);//計算結果をStringに変換
				
			}catch(Exception err){
				regB="Err";//ErrがでたらErrを表示
			}
		}
		
		label.setText(regB);//表示の更新
	}
}
