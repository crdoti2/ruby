
//
//  BufferWriter�̃f��
//

import java.io.*;//����import�����t�@�C���̏������݂ɕK�v
public class BufferedWriterDemo {
	public static void main(String args[]){
		try{//��O�������K�v
			FileWriter wr=new FileWriter("file.txt");//File�ƃA�v�����q���������݂łȂ�
			BufferedWriter br=new BufferedWriter(wr);//BufferedWriter���쐬
			br.write("line0");//������̏������݇@
			br.newLine();//���s������
			br.write("line1");//������̏������݇A
			br.newLine();//���s������
			br.write("line2");//������̏������݇B
			br.newLine();//���s������
			br.flush();//flush
			wr.flush();
			br.close();//����
			wr.close();
		}catch(IOException e){
			//��O�����́A�G���[��\��
			System.out.println("Err e="+e);
		}
	}
}
