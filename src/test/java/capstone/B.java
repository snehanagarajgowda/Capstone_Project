package capstone;

public class B {
	int x=10;
	int y=20;
	void sum() {
		System.out.println(x+y);
	}
	void sum(int a, int b) {
		System.out.println(a+b);	
	}
	void sum(int a, double b) {
		System.out.println(a+b);
	}

	public static void main(String[] args) {
		B b = new B();
		b.sum(1, 2);
		
	}

}
