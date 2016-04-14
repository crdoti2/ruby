//
//  �}�E�X����̃f���ł��B
//
import java.awt.*;//Frame��Canvas���g���̂ɕK�v��import��
import java.awt.event.*;//Frame��Canvas�̃C�x���g�����ɕK�v

public class Mouse {
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
//Canvas�͌p���N���XAppCanvas
//��Canvas�̌p���N���X������
//public void paint(Graphics g)
//�͕`��̕K�v��������ƁA�����ŌĂт���܂��B
class AppCanvas extends Canvas{
	//�v���p�e�B
	String methodName;//�C�x���g�����m�������\�b�h
	int eventId;//���������C�x���g�̔ԍ�
	int x,y;//�}�E�X�̈ʒu
	int count;//Mouse�֌W
	int button;//���삳�ꂽ�{�^��
	long time;//���삳�ꂽ����
	
	//�R���X�g���N�^
	AppCanvas(){
		//�v���p�e�B�̏�����
		methodName="";
		eventId=0;
		x=y=0;
		count=0;
		button=0;
		time=System.currentTimeMillis();
		
		//��������C�x���g�̎�ނ�
		//enableEvents(�C�x���g�}�X�NID�P�i�b�C�x���g�}�X�N��ID2)...);�Őݒ�
		//�@�@MOUSE_MOTION_EVEMT��MOUSE_EVENT����������C�x���g�Ƃ��ĕ\��
		enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK|AWTEvent.MOUSE_EVENT_MASK);
	}
	
	//�ȉ��ɕ`�悵�������e������
	public void paint(Graphics g){
		//�^�C�g���̕\��
		g.drawString("---�}�E�X�̃C�x���g---", 0, 12);
		
		//�}�E�X�C�x���g�̕\��
		g.drawString("Method="+methodName, 0, 24);
		g.drawString("Ev="+getEvTypeName(eventId), 0, 36);
		g.drawString("Button="+getButtonName(button), 0, 48);
		g.drawString("ClickCount="+count,0,60);
		g.drawString("time="+time, 0, 72);
		
		//�}�E�X�̈ʒu�ɃC�x���g����\��
		g.drawString(getEvTypeName(eventId),x,y);
		
	}
	
	//�}�E�X�C�x���g�h�c����A�C�x���g���̂��擾
	// �߂�l�@�C�x���g��
	// �����@�@�C�x���g����
	String getEvTypeName(int id){
		switch(id){
		case MouseEvent.MOUSE_CLICKED:return "MOUSE_CLICKED";
		case MouseEvent.MOUSE_DRAGGED:return "MOUSE_DRAGGED";
		case MouseEvent.MOUSE_ENTERED:return "MOUSE_ENTERED";
		case MouseEvent.MOUSE_EXITED:return "MOUSE_EXITED";
		case MouseEvent.MOUSE_MOVED:return "MOUSE_MOVED";
		case MouseEvent.MOUSE_PRESSED:return "MOUSE_PRESSED";
		case MouseEvent.MOUSE_RELEASED:return "MOUSE_RELEASED";
		case MouseEvent.MOUSE_WHEEL:return "MOUSE_WHELL";
		}
		return "unDefine";	
	}
	
	//�{�^���̂h�c����A�{�^���̖��O���擾
	//�߂�l�@�{�^���̖��O
	//�����@�@�{�^���̂h�c�@
	String getButtonName(int bt){
		switch(bt){
		case MouseEvent.BUTTON1:return "Button1";
		case MouseEvent.BUTTON2:return "Button2";
		case MouseEvent.BUTTON3:return "Button3";
		}
		return "No_Button";
	}
	
	// �}�E�X�����삳��ƁA�����Ŏ��s����郁�\�b�h
	//�@�@�����@e - ���������C�x���g�̏��
	//  �����ł́A�P�Ƀv���p�e�B�ɃC�x���g�̏����Z�b�g
	public void processMouseEvent(MouseEvent e){
		methodName="MouseEvent";//�������������\�b�h�i�����\�b�h�j���O���Z�b�g
		x=e.getX();//�}�E�X�̉��ʒu���Z�b�g
		y=e.getY();//�}�E�X�̈ʒu���Z�b�g
		eventId=e.getID();//�C�x���g�̂h�c���Z�b�g
		button=e.getButton();//���삳�ꂽ�{�^�����Z�b�g
		count=e.getClickCount();//�{�^���������ꂽ�񐔂��Z�b�g
		time=e.getWhen();//�C�x���g�����������Z�b�g
		repaint();//�ĕ`��
	}
	
	// �}�E�X���ړ�����ƁA�����Ŏ��s����郁�\�b�h
	//�@�@�����@e - ���������C�x���g�̏��
	//  �����ł́A�P�Ƀv���p�e�B�ɃC�x���g�̏����Z�b�g
	public void processMouseMotionEvent(MouseEvent e){
		methodName="MouseMotionEvent";//�������������\�b�h�i�����\�b�h�j���O���Z�b�g
		x=e.getX();//�}�E�X�̉��ʒu���Z�b�g
		y=e.getY();//�}�E�X�̈ʒu���Z�b�g
		eventId=e.getID();//�C�x���g�̂h�c���Z�b�g
		button=e.getButton();//���삳�ꂽ�{�^�����Z�b�g
		count=e.getClickCount();//�{�^���������ꂽ�񐔂��Z�b�g
		time=e.getWhen();//�C�x���g�����������Z�b�g
		repaint();//�ĕ`��
	}
		
}

//
//WindowAdapter�́AWindowLister�̋@�\�������܂����A
//�K�v�ȃ��\�b�h�����������΁AWindowListener�Ƃ��Ďg���܂�
class Adapter  extends WindowAdapter {
		//�E��́u�~�v�N���b�N�����ƌĂяo�����
		public void windowClosing(WindowEvent e){
			System.exit(0);//�A�v���̏I��
		}
}
