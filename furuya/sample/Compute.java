//Javaでの計算の例
public class Compute {
	public static void main(String args[]){
		int a;//int型変数aを宣言
		int b;//int型変数ｂを宣言
		int add,sub,mlt,div,mdl,ave;//幾つのint型変数をまとめて宣言

		
		a=8;//aに8をセット
		b=3;//bに３をセット
		
		add=a+b;//足し算を実施
		sub=a-b;//引き算を実施
		mlt=a*b;//掛け算を実施
		div=a/b;//割り算を実施
		mdl=a%b;//余りを計算
		ave=(a+b)/2;//平均を計算
		
		//結果の表示
		System.out.print("a+b=");
		System.out.println(add);
		
		System.out.print("a-b=");
		System.out.println(sub);
		
		System.out.print("a×b=");
		System.out.println(mlt);
		
		System.out.print("a÷b=");
		System.out.println(div);
		
		System.out.print("a%b=");
		System.out.println(mdl);
		
		System.out.print("平均=");
		System.out.println(ave);
		
	}
}
