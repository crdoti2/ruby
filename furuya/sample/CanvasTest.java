//
//  Canvas�̃e�X�g�ł��B
//
import java.awt.*;//Frame��Canvas���g���̂ɕK�v��import��
import java.awt.event.*;//Frame��Canvas�̃C�x���g�����ɕK�v

public class CanvasTest {
	public static void main(String args[]){
		//�A�v���͂���������s����܂��B
		Frame frame=new Frame();//Frame���쐬
		AppCanvas canvas=new AppCanvas();//Canvas�̌p���N���X��AppCanvas���쐬
		frame.add(canvas);//canvas���t���[���ɒǉ�
		frame.addWindowListener(new Adapter());//Window�̃C�x���g�̏�������w��
		frame.setSize(240,240);//�T�C�Y���w��
		frame.setVisible(true);//�\��
	}
}

//
// Canvas�͌p���N���XAppCanvas
//  ��Canvas�̌p���N���X������
//�@�@�@public void paint(Graphics g)
//  �͕`��̕K�v��������ƁA�����ŌĂт���܂��B
class AppCanvas extends Canvas{
	//�ȉ��ɕ`�悵�������e������
	public void paint(Graphics g){
		g.drawString("Canvas Test", 0, 120);//������\��
	}
}

//
// WindowAdapter�́AWindowLister�̋@�\�������܂����A
//�@�K�v�ȃ��\�b�h�����������΁AWindowListener�Ƃ��Ďg���܂�
class Adapter  extends WindowAdapter {
		//�E��́u�~�v�N���b�N�����ƌĂяo�����
		public void windowClosing(WindowEvent e){
			System.exit(0);//�A�v���̏I��
		}
}
