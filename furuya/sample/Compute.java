//Java�ł̌v�Z�̗�
public class Compute {
	public static void main(String args[]){
		int a;//int�^�ϐ�a��錾
		int b;//int�^�ϐ�����錾
		int add,sub,mlt,div,mdl,ave;//���int�^�ϐ����܂Ƃ߂Đ錾

		
		a=8;//a��8���Z�b�g
		b=3;//b�ɂR���Z�b�g
		
		add=a+b;//�����Z�����{
		sub=a-b;//�����Z�����{
		mlt=a*b;//�|���Z�����{
		div=a/b;//����Z�����{
		mdl=a%b;//�]����v�Z
		ave=(a+b)/2;//���ς��v�Z
		
		//���ʂ̕\��
		System.out.print("a+b=");
		System.out.println(add);
		
		System.out.print("a-b=");
		System.out.println(sub);
		
		System.out.print("a�~b=");
		System.out.println(mlt);
		
		System.out.print("a��b=");
		System.out.println(div);
		
		System.out.print("a%b=");
		System.out.println(mdl);
		
		System.out.print("����=");
		System.out.println(ave);
		
	}
}
