//
//  Canvas�̃e�X�g�ł��B
//
import java.awt.*;//Frame��Canvas���g���̂ɕK�v��import��
import java.awt.event.*;//Frame��Canvas�̃C�x���g�����ɕK�v

public class GraphicsDemo {
	public static void main(String args[]){
		//�A�v���͂���������s����܂��B
		Frame frame=new Frame();//Frame���쐬
		AppCanvas canvas=new AppCanvas();//Canvas�̌p���N���X��AppCanvas���쐬
		frame.add(canvas);//canvas���t���[���ɒǉ�
		frame.addWindowListener(new Adapter());//Window�̃C�x���g�̏�������w��
		frame.setSize(300,240);//�T�C�Y���w��
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
		int x,y;//�`�悷�邽�߂̉��ʒu�̊
		int w,h;//�`�悷�邽�߂̕��̊
		int dw,dh;//�`�悷��Ƃ��̊ۂ�
		int px[]=new int[3];//���p�`��`�悷�鉡�ʒu
		int py[]=new int[3];//���p�`��`�悷�鎞�̈ʒu
		int x2,y2;//�����̏I�_
		
		//
		// g.setColor(Color.�F�̖��O);
		//�ŕ`�悷��F���ݒ�ł��܂��B�F�̖��O�́A�ȉ�����I�т܂��B
		//  WHITE - ���@�@�@�@�@LIGHT_GRAY�@�|���C�g�O��
		//  GRAY  - �O���C�@�@�@DARK_GRAY�@�@�|�_�[�N�O��
		//  BLACK - ���@�@�@�@�@RED�@�@�@�@�@�@�@�|��
		//  PINK  - �s���N�@�@�@ORANGE�@�@�@�@�@�|�I�����W
		//  YELLOW- ���@�@�@�@�@GREEN�@�@�@�@�@�\��
		//  MAGENTA-�}�[���_�@�@CYAN�@�@�@�@�@�@�|�V�A��
		//  BLUE-   �@
		// ���������ł����Ă������݂����ł��B
		g.setColor(Color.LIGHT_GRAY);//�`��F�����C�g�O���[�ɐݒ�
		
		//�`��ʒu��ݒ肷�邽�߂̈ʒu�⍂����ϐ�x,y,w,h�ɃZ�b�g
		x=10;y=5;
		w=70;h=55;

		//�ȉ��̒��ߕ��ł́A�����炘�s�N�Z���A�ォ�炙�s�N�Z���̈ʒu���i���A���j�Ŏ����܂��B
		//�s�N�Z���ʒu�̎w�肪�A�w�Z�łȂ�������W�̏㉺���������܂ł��B
		//(x,y)������Ƃ��āA�����A�������̒����`(�h��Ԃ�����j��`�悷��B
		g.fillRect(x, y, w, h);
		
		g.setColor(Color.BLACK);//�`��F������
		//(x,y)������Ƃ��āA����+1�A������+1�̒����`�i�h��Ԃ����j��`�悷��B
		//���h��Ԃ��Ȃ��̕`��ł́A�󔒂̕��⍂�����w�肷��̂ŁA�S�̂̕��͑����܂�
		g.drawRect(x, y, w, h);
		
		g.setColor(Color.DARK_GRAY);//�`��F���_�[�N�O����
		
		//�p�̊ۂ݂̃p�����[�^�Ɏg���ϐ����Z�b�g
		dw=w/2;
		dh=h/2;
		//(x,y)������Ƃ��āA�����A�������̊p�Ɋۂ݂����钷���`(�h��Ԃ�����j��`�悷��B
		// �ۂ݂͏c����rw,�悱����rh�̒����`�ɓ��ڂ���ȉ~�̉��Ƃ��܂��B
		g.fillRoundRect(x, y, w,h, dw, dh);
		
		g.setColor(Color.GREEN);//�`��F��΂ɕύX
		
		//(x,y)������Ƃ��āA�����A�������̊p�Ɋۂ݂����钷���`(�h��Ԃ����j��`�悷��B
		// �ۂ݂͏c����rw,�悱����rh�̒����`�ɓ��ڂ���ȉ~�̉��Ƃ��܂��B
		g.drawRoundRect(x, y, w,h, dw, dh);
		
		g.setColor(Color.WHITE);//�`��F�𔒂ɕύX
		
		//�I�_(x2,y2)���v�Z
		x2=x+w;
		y2=y+h;
		
		g.drawLine(x,y,x2,y2);//(x,y)-(x2,y2)�̐�������
		
		x=100;//�`��ꏊ���ړ�
		g.setColor(Color.RED);//�`��F��΂ɕύX

		//(x,y)������Ƃ��āA����+1�A������+1�̕����o�Č����钷���`�i�h��Ԃ����j��`�悷��B
		g.draw3DRect(x, y, w, h, true);
		
		x=200;//�`��ꏊ���ړ�
		//(x,y)������Ƃ��āA�����A�������̕����o�Č����钷���`�i�h��Ԃ��L��j��`�悷��B
		g.fill3DRect(x, y, w, h, true);
		
		y=75;//�`��ꏊ���ړ�
		//(x,y)������Ƃ��āA����+1�A������+1�̒��݂���Ō����钷���`�i�h��Ԃ����j��`�悷��B
		g.draw3DRect(x, y, w, h, false);
		
		x=100;//�`��ꏊ���ړ�
		//(x,y)������Ƃ��āA�����A�������̒��݂���Ō����钷���`�i�h��Ԃ��L��j��`�悷��B
		g.fill3DRect(x, y, w, h, false);
		
		x=10;//�`��ꏊ���ړ�
		g.setColor(Color.PINK);//�`��F���s���N�ɕύX
		
		//(x,y)������Ƃ��āA�����A�����������`�ɓ��ڂ���ȉ~�i�h��Ԃ��L��j��`�悷��B
		g.fillOval(x, y, w, h);
		
		g.setColor(Color.RED);//�`��F��ԂɕύX
		
		//(x,y)������Ƃ��āA����+1�A������+1�����`�ɓ��ڂ���ȉ~�i�h��Ԃ����j��`�悷��B
		//���s���N�ƐԂ̊ԂɌ��Ԃ�����̂ɒ��ڂ��Ă�������
		g.drawOval(x, y, w, h);
		
		y=140;//�`��ʒu�̈ړ�
		g.setColor(Color.YELLOW);//�`��F�����F�ɕύX
		
		//(x1,y1)������Ƃ��āA�����A�����������`�ɓ��ڂ���ȉ~��i�h��Ԃ��L��j��`�悷��B
		// �J�n�p�x45�x�A�`��p�x180�x�i�P�ʂ͓x�ł��j
		g.fillArc(x, y, w, h, 45, 180);
		g.setColor(Color.ORANGE);
		
		//(x1,y1)������Ƃ��āA����+1�A������+1�����`�ɓ��ڂ���ȉ~��i�h��Ԃ�����j��`�悷��B
		// �J�n�p�x45�x�A�`��p�x180�x�i�P�ʂ͓x�ł��j
		//���傫�����h��Ԃ�����Ə����Ⴄ�̂ɒ��ڂ����Ă������B
		g.drawArc(x, y, w, h, 225, 180);
		
		x=100;//�`��ʒu�̈ړ�
		
		//�O�p�`��`�悷�邽�߂̓_�̌v�Z
		px[0]=x+w/2;py[0]=y;
		px[1]=x;py[1]=y+h;
		px[2]=x+w;py[2]=y+h;
		
		g.setColor(Color.CYAN);//�F���V�A���ɕύX
		
		// px,py�Ŏw�肳��鑽�p�`��`���i�h��Ԃ�����j��`��
		g.fillPolygon(px,py,3);
		
		g.setColor(Color.BLUE);//���V�A���ɕύX
		
		// px,py�Ŏw�肳��鑽�p�`��`���i�h��Ԃ��Ȃ��j��`��
		g.drawPolygon(px,py,3);
		
		x=200;//�`��ʒu�̈ړ�
		
		//�O�p�`��`�悷�邽�߂̓_�̌v�Z
		px[0]=x+w/2;py[0]=y;
		px[1]=x;py[1]=y+h;
		px[2]=x+w;py[2]=y+h;
		
		// px,py�Ŏw�肳���܂����`���i�h��Ԃ��Ȃ��j��`��
		// ���܂���
		g.drawPolyline(px,py,3);
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
