//
//　 ListとCheckBoxのデモ
//　 
//

import java.awt.*;//Winodwを作りのにJava　Awt　を使う
import java.awt.event.*;//Envent管理に使う

public class ListAndCheck {
	public static void main(String args[]){
		//このしたからアプリが始まります。
		new WindowTest();//これで制御をWindowTestクラスに移す	
	}
}


//
//WindowTest クラスは, Windowの表示を行います。
//
//  ListとCheckBoｘのデモ
//
class WindowTest extends Frame 
	implements WindowListener,ActionListener,ItemListener{
	
	//表示用のコンポーネント
	Label  label;//Label型変数　labelを宣言
	Button buttonｓ[]=new Button[16];//Button型の配列　buttonsを宣言
	List   list;//リスト
	Checkbox check;//チェックボックス
	
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
	
	//radianに変換する係数
	double toRad;
	
	//コンストラクタ
	WindowTest(){
		int i;
		
		//regA,regBをクリア
		regA="";
		regB="";
		//Layoutnに必要なGridBagLayout型変数gridBagを宣言
		GridBagLayout gridbag = new GridBagLayout();//GridBagayout型変数　gridbagの宣言と初期化
        GridBagConstraints c = new GridBagConstraints();//GridBagConstraints型変数cの宣言と初期化
      
		
		//Windowを作る
		addWindowListener(this);//リスナーの設定
		setSize(240, 240);//サイズを指定す
		setLayout( gridbag);//BorBagLayout設定
		
		
		//WIndowにLabelを追加する。
		label=new Label(regB);//表示用部品に初期値をセット
		
		c.fill = GridBagConstraints.BOTH;//サイズを立て横とも、自動でそろえるように設定
		c.gridx=0;//表示横位置
		c.gridy=0;//表示の縦位置
		c.gridwidth=4;//表示の幅
		c.gridheight=1;//表示の高さ
		gridbag.setConstraints(label, c);//label表示条件を設定
		add(label);//表示用の部品をWindow「上」に追加
		
		//Buttonの生成と追加
		c.gridwidth=1;//表示の幅は１升
		c.gridheight=1;//表示の高さも１升
		for(i=0;i<16;i++){
			buttonｓ[i]=new Button(buttonLabels[i]);//Buttonの生成
			buttonｓ[i].addActionListener(this);//ActionListenerをセット
			c.gridx=i % 4;//表示の横位置の設定
			c.gridy=(i/4)+1;//表示の縦位置の設置
			gridbag.setConstraints(buttonｓ[i], c);//Buttonの表示条件の設定
			add(buttonｓ[i]);//表示用の部品をWindow「上」に追加
		}
		
		//最初の角度の単位はRad
		toRad=1.0;
		
		//ListBoxの設定
		list=new List();//リストボックスの初期値設定
		list.add("√");//0番のアイテムは√
		list.add("sin");//1番のアイテムはsin
		list.add("cos");//２番のアイテムはcos
		list.add("tan");//3番のアイテムはtan

		list.addItemListener(this);//itemListenerをセット
		
		//表示位置の設定
		c.gridx=0;//横は一番←
		c.gridy=6;//縦は６マス目
		c.gridwidth=3;//幅３升
		gridbag.setConstraints(list,c);//位置をセット

		add(list);//Winodwに追加
		
		//Choiceの設定
		check=new Checkbox("Degree");//チェックボックスの設定
		check.setState(false);//初期値にチェックなしを設定
		
		check.addItemListener(this);//itemListenerをセット
		
		//表示位置のセット
		c.gridx=3;
		c.gridwidth=1;
		gridbag.setConstraints(check,c);
		
		add(check);//Windowに追加
	
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

	//-------------------------------------------
	//  ListやChoiceの変更されたと場合の呼びだされるメソッド
	//-------------------------------------------
	public void itemStateChanged(ItemEvent e) {
		
		Object scr=e.getSource();//イベントが発生したコンポーネントを取得する。
		
		if (scr==list){
			//以下はListが操作された場合の処理
			int itemNo=list.getSelectedIndex();//選択されたアイテムのNoを手に入れる
			double b,c;//計算用の数値変数
			try{
				b=Double.parseDouble(regB);//regBを数値に変換	
				c=0;//結果に０を入れておく
				if (itemNo==0) c=Math.sqrt(b);//0番選択なら√を計算 
				if (itemNo==1) c=Math.sin(toRad*b);//1番選択ならsinを計算
				if (itemNo==2) c=Math.cos(toRad*b);//２番選択ならcosを計算
				if (itemNo==3) c=Math.tan(toRad*b);//3番選択ならtanを計算		
				regB=String.valueOf(c);//計算結果を文字列に戻す
			}catch(Exception err){
				regB="Err";//Errが発生したらErrを設定
			}
			label.setText(regB);//結果の再表示

		}
		
		if (scr==check){
			//checkが操作された時の処理
			if(check.getState()){
				//チェックがあれば、toRadの値をπ/180に設定
				toRad=Math.PI/180;//Math.PIは円周率を示す
			}else{
				//チェックがないと、１に設定
				toRad=1;
			}
			
		}	
	}
	
}
