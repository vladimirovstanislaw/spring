
public class Exceptionf {
	public static void main(String[] args) throws Exception {
		int i;
		try {
			i = 6;
			test();
		} catch (Exception ex) {
			System.out.println("johny");
			// throw new Exception(); //���� ������������� , �� System.out.println("johny");
			// ������ unreachable
		}
		// System.out.println("johny");
	}

	public static void test() throws Exception {
		try {
			throw new Exception();
		} catch (Exception ex) {
			throw new Exception();
		}
	}
}
