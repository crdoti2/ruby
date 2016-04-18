//
//�@ �R���|�[�l���g�����̗��p��
//

import java.awt.*;//Winodw�����̂�Java�@Awt�@���g��
import java.awt.event.*;//Envent�Ǘ��Ɏg��
public class BorderLayoutDemo {
	public static void main(String args[]){
		//���̂�������A�v�����n�܂�܂��B
		new WindowTest();//����Ő����WindowTest�N���X�Ɉڂ�	
	}
}

//
//WindowTest �N���X��, Window�̕\�����s���܂��B
//
//Window�̃R���|�[�l���g�����̗�
//
class WindowTest extends Frame implements WindowListener,ActionListener{
	
	//�\���p�̃R���|�[�l���g
	Label  label;//Label�^�ϐ��@label��錾
	Button button��[]=new Button[16];//Button�^�̔z��@buttons��錾
	Panel panel;//Panel�^�̕ϐ���錾
	//Button�p�̃��x��
	String buttonLabels[]=
		{"7","8","9","[+]",
		 "4","5","6","[-]",
		 "1","2","3","[�~]",
		 "0",".","Ent","[��]"
		};
	
	//�����ꂽ�{�^���Ȃǂ��L�^����ϐ�
	String regA;//�O�̓��͌���
	String regB;//���݂̓��͌���
	
	
	//�R���X�g���N�^
	WindowTest(){
		int i;
		
		//regA,regB���N���A
		regA="";
		regB="";
		
		//Window�����
		addWindowListener(this);//���X�i�[�̐ݒ�
		setSize(240, 240);//�T�C�Y���w�肷
		setLayout(new BorderLayout() );//BorderLayout�ݒ�
		
		//WIndow��Label��ǉ�����B
		label=new Label(regB);//�\���p���i�ɏ����l���Z�b�g
		add(label,BorderLayout.NORTH);//�\���p�̕��i��Window�u��v�ɒǉ�
		
		//Pane�̐����ƃ��C�A�E�g�ݒ�
		panel=new Panel();//Panel�̐���
		panel.setLayout(new GridLayout(4,4));//panel��GridLayout�ݒ�
		
		//Button�̐����ƒǉ�
		for(i=0;i<16;i++){
			button��[i]=new Button(buttonLabels[i]);//Button�̐���
			button��[i].addActionListener(this);//ActionListener���Z�b�g
			panel.add(button��[i]);//���������{�^�����p�l���ɒǉ�
		}
		
		add(panel,BorderLayout.CENTER);//�p�l���́u�����v�ɒǉ�
		
		setVisible(true);//��������
	}

	//-------------------------------------------------
	// �ȉ��̃��\�b�h�́AWindow�ɕω����������Ƃ��Ɏ����Ŏ��s����܂��B
	//( WindowListener���v���������\�b�h�j
	//-------------------------------------------------
	
	//�A�N�e�B�u�ɂȂ������̏���
	public void windowActivated(java.awt.event.WindowEvent e) {
		System.out.println("Activated");
	}

	//����ꂽ���̏���
	public void windowClosed(java.awt.event.WindowEvent e) {
		System.out.println("Closed");
	}

	//�����Ă��鎞�̏���
	public void windowClosing(java.awt.event.WindowEvent e) {
		System.out.println("Closing");
		System.exit(0);//�A�v���̏I��
	}

	//�A�N�e�B�u�łȂ��Ȃ����Ƃ��̏���
	public void windowDeactivated(java.awt.event.WindowEvent e) {
		System.out.println("Deactivaed");	
	}

	//�A�C�R������߂����Ƃ��̏���
	public void windowDeiconified(java.awt.event.WindowEvent e) {
		System.out.println("Deicnified");
	}

	//�A�C�R�������ꂽ���̏���
	public void windowIconified(java.awt.event.WindowEvent e) {
		System.out.println("Icnified");
	}

	// �J���ꂽ���̏���
	public void windowOpened(java.awt.event.WindowEvent e) {
		System.out.println("Opend");
	}

	//-------------------------------------------
	//  �{�^���������ꂽ�Ƃ��Ăяo����郁�\�b�h
	//--------------------------------------------
	public void actionPerformed(ActionEvent e) {
		Button bt=(Button)e.getSource();//�����ꂽ�{�^�����擾
		String lbl=bt.getLabel();//�{�^���̃��x�����擾
		double a,b,c;//�r���v�Z�Ɏg��double�^�ϐ�
		if (lbl.length()==1){
			//���x�����P�����Ȃ�
			regB=regB+lbl;//regA�ɉ�����
		}else if(lbl.equals("Ent")){
			//���x����Ent�Ȃ�
			regA=regB;//regB��regA�ɃZ�b�g
			regB="";//regB���N���A
		}else{
			//���x�����l�����Z�Ȃ�A���Z�����{
			//Err���o��\��������̂ŁA��O������ǉ�
			try{
				c=0;//�v�Z���ʂ��O�ɂ���i���������Ȃ��ƃG���[���o��j
				a=Double.parseDouble(regA);//regA�𐔒l�ɕϊ�
				b=Double.parseDouble(regB);//regB�𐔒l�ɕϊ�
				
				if (lbl.equals("[+]")) c=a+b;//[+]�{�^���������ꂽ����Z�����{
				if (lbl.equals("[-]")) c=a-b;//[�|]�{�^���������ꂽ������Z�����{
				if (lbl.equals("[�~]")) c=a*b;//[�~]�{�^���������ꂽ��|���Z�����{
				if (lbl.equals("[��]")) c=a/b;//[��]�{�^���������ꂽ��|���Z�����{
				
				regB=String.valueOf(c);//�v�Z���ʂ�String�ɕϊ�
				
			}catch(Exception err){
				regB="Err";//Err���ł���Err��\��
			}
		}
		
		label.setText(regB);//�\���̍X�V
	}
}
