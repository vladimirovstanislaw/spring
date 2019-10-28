package core;

public class B extends A implements C {
	public static int i = 6;
	public int ii = 6;
	public int cc = 6;

	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		A aa = b;

		System.out.println("A i = " + a.i);
		System.out.println("B i = " + b.i);

		System.out.println("A aa = b; i = " + aa.i);

		System.out.println(
				"================================================================================================================================================");

		System.out.println("A ii = " + a.ii);
		System.out.println("B ii = " + b.ii);

		System.out.println("A aa = b; ii = " + aa.ii);

		System.out.println(
				"================================================================================================================================================");
		C c = b;

		System.out.println("B cc = " + b.cc);

		System.out.println("C c = b; cc = " + c.cc);
	}
}
