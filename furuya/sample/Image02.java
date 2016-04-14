
//
// �h���������̃v���p�e�B�̗��p��
//
import java.awt.*;//�E�B���h�E�̕\���ɕK�v
import java.awt.event.*;//�E�B���h�E�̃C�x���g�����ɕK�v
import java.awt.image.*;//Image�̎�舵���ɕK�v
import java.io.*;//Image�̓ǂݍ���
import javax.imageio.*;//Image�̓ǂݍ���

public class Image02 {
	static public void main(String args[]){
		//�A�v���͂�������
		AppCanvas canvas=new AppCanvas();//�\���p�̃L�����o�X
		Frame frame=new Frame();//�\���p�̂e�����������쐬
		frame.add(canvas);//�e���������ɒǉ�
		frame.addWindowListener(new Adapter());//Listener���w��
		frame.setSize(240, 240);//�T�C�Y�ݒ�
		frame.setVisible(true);//�\��
	}
}

//-----------------------------
//  �\���p�̃L�����o�X
//------------------------------
class AppCanvas extends Canvas{
	BufferedImage image;//�E�B���h�E�ɕ\������C���[�W
	
	//�R���X�g���N�^
	AppCanvas(){
		image=loadImage("test.gif");//�\���p�̃C���[�W����荞��
	}
	
	//�C���[�W���t�@�C�������荞��
	// �����@- Imgae�̃t�@�C����
	// �߂�l�@- �ǂݍ��񂾃C���[�W
	BufferedImage loadImage(String name){
		try{
			FileInputStream in=new FileInputStream(name);//FileInputStream�����
			BufferedImage rv=ImageIO.read(in);//�C���[�W����荞��
			in.close();//����
			return rv;//�߂�l�ɓǂݍ��񂾃C���[�W���Z�b�g
		}catch(IOException e){
			//�G���[���̏����i�G���[��\���j��null��Ԃ�
			System.out.println("Err e="+e);//�G���[��\��
			return null;//null�@��Ԃ�
		}
	}
	
	//�\���̕K�v������Ύ��s����郁�\�b�h
	public void paint(Graphics g){
		int sw=getWidth();//��ʂ̕����擾
		int sh=getHeight();//��ʂ̍������擾
		int iw=image.getWidth(this);//�C���[�W�̕����擾
		int ih=image.getHeight(this);//�C���[�W�̍������擾
		int x=(sw-iw)/2;//�C���[�W���������ɂȂ�ʒu���v�Z
		int y=(sh-ih)/2;//�C���[�W���c�����ɂȂ�ʒu���v�Z
		g.drawImage(image, x,y,this);//�\��
	}
}

//
//WindowAdapter�́AWindowLister�̋@�\�������܂����A
//�K�v�ȃ��\�b�h�����������΁AWindowListener�Ƃ��Ďg���܂�
//
class Adapter  extends WindowAdapter {
		//�E��́u�~�v�N���b�N�����ƌĂяo�����
		public void windowClosing(WindowEvent e){
			System.exit(0);//�A�v���̏I��
		}
}

