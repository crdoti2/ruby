//
//  Midi�t�@�C���̃f���̗�ł��B
//
import java.io.*;//�O������f�[�^����荞�݂ɕK�v
import javax.sound.midi.*;//Midi�̈����ɕK�v

public class MidiDemo {
	public static void main(String args[]){
		MidiFilePlayer player=new MidiFilePlayer();//�v���C���[������
		player.play("ceremo.mid");//�uceremo.mid�v���Đ�
		sleep(2000);//2�b�҂�
		player.stop();//�Đ���~
		player.play("cooking.mid");//�ucooking.mid�v���Đ�
		sleep(2000);//�Q�b�҂�
		player.bye();//�I������
		System.exit(0);//�A�v���̏I��
	}
	
	//
	// ���ԑ҂��i�� mSec)
	//
	static void sleep(long t){
		try{//InterruptedException ��O�������K�v
			Thread.sleep(t);//���ԑ҂�
		}catch(InterruptedException e){
			//��O����������A�\��������
			System.out.println("Err="+e);
		}
	}
}

//
//  midi�t�@�C�����Đ����邽�߂̃N���X MidiFilePlayer
//
class MidiFilePlayer{
	Sequencer sequencer;//���ۂ�Midi���Đ�����v���C���[�ł��B
	
	//�R���X�g���N�^�i���ۂɉ������t����Sequencer���擾�E�ݒ肷��B
	MidiFilePlayer(){
		try{
			 sequencer = MidiSystem.getSequencer();//Sequencer���擾
			 sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);//�������[�v��ݒ�
			 sequencer.open();//������\�ɂ���
		}catch(MidiUnavailableException e){
			//��O�����i�G���[��\�����邾���j
			System.out.println("Err="+e);
		}
	}
	
	//name�Ŏw�肵��midi�t�@�C�����Đ�����
	void play(String name){
		try{
			FileInputStream in=new FileInputStream(name);//midfile�ƃA�v�����q��
			Sequence sequence=MidiSystem.getSequence(in);//�����̎�荞��
			in.close();//�t�@�C�����N���[�Y
			sequencer.setSequence(sequence);//�����Z�b�g
			sequencer.start();//�Đ��J�n
		}catch(Exception e){//�����̗�O�������K�v�Ȃ̂ŁAException�ł܂Ƃ߂�
			//��O�����i�\�����邯�j
			System.out.println("Err ="+e);
		}
	}
	
	//�Đ����~����B
	void stop(){
			if (sequencer.isRunning()){
				sequencer.stop();	//�Đ����Ȃ��~����B
			}
	}
	
	//�V�[�P���T�[���������B
	void bye(){
		stop();//��~
		sequencer.close();//�N���[�Y
	}
}