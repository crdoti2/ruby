//
//  Midiファイルのデモの例です。
//
import java.io.*;//外部からデータを取り込みに必要
import javax.sound.midi.*;//Midiの扱いに必要

public class MidiDemo {
	public static void main(String args[]){
		MidiFilePlayer player=new MidiFilePlayer();//プレイヤーを準備
		player.play("ceremo.mid");//「ceremo.mid」を再生
		sleep(2000);//2秒待ち
		player.stop();//再生停止
		player.play("cooking.mid");//「cooking.mid」を再生
		sleep(2000);//２秒待ち
		player.bye();//終了処理
		System.exit(0);//アプリの終了
	}
	
	//
	// 時間待ち（ｔ mSec)
	//
	static void sleep(long t){
		try{//InterruptedException 例外処理が必要
			Thread.sleep(t);//時間待ち
		}catch(InterruptedException e){
			//例外が発生しら、表示をする
			System.out.println("Err="+e);
		}
	}
}

//
//  midiファイルを再生するためのクラス MidiFilePlayer
//
class MidiFilePlayer{
	Sequencer sequencer;//実際にMidiを再生するプレイヤーです。
	
	//コンストラクタ（実際に音を演奏するSequencerを取得・設定する。
	MidiFilePlayer(){
		try{
			 sequencer = MidiSystem.getSequencer();//Sequencerを取得
			 sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);//無限ループを設定
			 sequencer.open();//操作を可能にする
		}catch(MidiUnavailableException e){
			//例外処理（エラーを表示するだけ）
			System.out.println("Err="+e);
		}
	}
	
	//nameで指定したmidiファイルを再生する
	void play(String name){
		try{
			FileInputStream in=new FileInputStream(name);//midfileとアプリを繋ぐ
			Sequence sequence=MidiSystem.getSequence(in);//音源の取り込み
			in.close();//ファイルをクローズ
			sequencer.setSequence(sequence);//音源セット
			sequencer.start();//再生開始
		}catch(Exception e){//複数の例外処理が必要なので、Exceptionでまとめた
			//例外処理（表示するけ）
			System.out.println("Err ="+e);
		}
	}
	
	//再生を停止する。
	void stop(){
			if (sequencer.isRunning()){
				sequencer.stop();	//再生中なら停止する。
			}
	}
	
	//シーケンサーを解放する。
	void bye(){
		stop();//停止
		sequencer.close();//クローズ
	}
}