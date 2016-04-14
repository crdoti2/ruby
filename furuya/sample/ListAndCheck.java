//
//�@ List��CheckBox�̃f��
//�@ 
//

import java.awt.*;//Winodw�����̂�Java�@Awt�@���g��
import java.awt.event.*;//Envent�Ǘ��Ɏg��

public class ListAndCheck {
	public static void main(String args[]){
		//���̂�������A�v�����n�܂�܂��B
		new WindowTest();//����Ő����WindowTest�N���X�Ɉڂ�	
	}
}


//
//WindowTest �N���X��, Window�̕\�����s���܂��B
//
//  List��CheckBo���̃f��
//
class WindowTest extends Frame 
	implements WindowListener,ActionListener,ItemListener{
	
	//�\���p�̃R���|�[�l���g
	Label  label;//Label�^�ϐ��@label��錾
	Button button��[]=new Button[16];//Button�^�̔z��@buttons��錾
	List   list;//���X�g
	Checkbox check;//�`�F�b�N�{�b�N�X
	
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
	
	//radian�ɕϊ�����W��
	double toRad;
	
	//�R���X�g���N�^
	WindowTest(){
		int i;
		
		//regA,regB���N���A
		regA="";
		regB="";
		//Layoutn�ɕK�v��GridBagLayout�^�ϐ�gridBag��錾
		GridBagLayout gridbag = new GridBagLayout();//GridBagayout�^�ϐ��@gridbag�̐錾�Ə�����
        GridBagConstraints c = new GridBagConstraints();//GridBagConstraints�^�ϐ�c�̐錾�Ə�����
      
		
		//Window�����
		addWindowListener(this);//���X�i�[�̐ݒ�
		setSize(240, 240);//�T�C�Y���w�肷
		setLayout( gridbag);//BorBagLayout�ݒ�
		
		
		//WIndow��Label��ǉ�����B
		label=new Label(regB);//�\���p���i�ɏ����l���Z�b�g
		
		c.fill = GridBagConstraints.BOTH;//�T�C�Y�𗧂ĉ��Ƃ��A�����ł��낦��悤�ɐݒ�
		c.gridx=0;//�\�����ʒu
		c.gridy=0;//�\���̏c�ʒu
		c.gridwidth=4;//�\���̕�
		c.gridheight=1;//�\���̍���
		gridbag.setConstraints(label, c);//label�\��������ݒ�
		add(label);//�\���p�̕��i��Window�u��v�ɒǉ�
		
		//Button�̐����ƒǉ�
		c.gridwidth=1;//�\���̕��͂P��
		c.gridheight=1;//�\���̍������P��
		for(i=0;i<16;i++){
			button��[i]=new Button(buttonLabels[i]);//Button�̐���
			button��[i].addActionListener(this);//ActionListener���Z�b�g
			c.gridx=i % 4;//�\���̉��ʒu�̐ݒ�
			c.gridy=(i/4)+1;//�\���̏c�ʒu�̐ݒu
			gridbag.setConstraints(button��[i], c);//Button�̕\�������̐ݒ�
			add(button��[i]);//�\���p�̕��i��Window�u��v�ɒǉ�
		}
		
		//�ŏ��̊p�x�̒P�ʂ�Rad
		toRad=1.0;
		
		//ListBox�̐ݒ�
		list=new List();//���X�g�{�b�N�X�̏����l�ݒ�
		list.add("��");//0�Ԃ̃A�C�e���́�
		list.add("sin");//1�Ԃ̃A�C�e����sin
		list.add("cos");//�Q�Ԃ̃A�C�e����cos
		list.add("tan");//3�Ԃ̃A�C�e����tan

		list.addItemListener(this);//itemListener���Z�b�g
		
		//�\���ʒu�̐ݒ�
		c.gridx=0;//���͈�ԁ�
		c.gridy=6;//�c�͂U�}�X��
		c.gridwidth=3;//���R��
		gridbag.setConstraints(list,c);//�ʒu���Z�b�g

		add(list);//Winodw�ɒǉ�
		
		//Choice�̐ݒ�
		check=new Checkbox("Degree");//�`�F�b�N�{�b�N�X�̐ݒ�
		check.setState(false);//�����l�Ƀ`�F�b�N�Ȃ���ݒ�
		
		check.addItemListener(this);//itemListener���Z�b�g
		
		//�\���ʒu�̃Z�b�g
		c.gridx=3;
		c.gridwidth=1;
		gridbag.setConstraints(check,c);
		
		add(check);//Window�ɒǉ�
	
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

	//-------------------------------------------
	//  List��Choice�̕ύX���ꂽ�Əꍇ�̌Ăт�����郁�\�b�h
	//-------------------------------------------
	public void itemStateChanged(ItemEvent e) {
		
		Object scr=e.getSource();//�C�x���g�����������R���|�[�l���g���擾����B
		
		if (scr==list){
			//�ȉ���List�����삳�ꂽ�ꍇ�̏���
			int itemNo=list.getSelectedIndex();//�I�����ꂽ�A�C�e����No����ɓ����
			double b,c;//�v�Z�p�̐��l�ϐ�
			try{
				b=Double.parseDouble(regB);//regB�𐔒l�ɕϊ�	
				c=0;//���ʂɂO�����Ă���
				if (itemNo==0) c=Math.sqrt(b);//0�ԑI���Ȃ����v�Z 
				if (itemNo==1) c=Math.sin(toRad*b);//1�ԑI���Ȃ�sin���v�Z
				if (itemNo==2) c=Math.cos(toRad*b);//�Q�ԑI���Ȃ�cos���v�Z
				if (itemNo==3) c=Math.tan(toRad*b);//3�ԑI���Ȃ�tan���v�Z		
				regB=String.valueOf(c);//�v�Z���ʂ𕶎���ɖ߂�
			}catch(Exception err){
				regB="Err";//Err������������Err��ݒ�
			}
			label.setText(regB);//���ʂ̍ĕ\��

		}
		
		if (scr==check){
			//check�����삳�ꂽ���̏���
			if(check.getState()){
				//�`�F�b�N������΁AtoRad�̒l����/180�ɐݒ�
				toRad=Math.PI/180;//Math.PI�͉~����������
			}else{
				//�`�F�b�N���Ȃ��ƁA�P�ɐݒ�
				toRad=1;
			}
			
		}	
	}
	
}
