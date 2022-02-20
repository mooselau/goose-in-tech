package other;

public class ExceptionTesting {
	public static void main(String[] args) {
		ExceptionTesting tester = new ExceptionTesting();
		tester.entrypoint();
	}

	public void entrypoint() {
		m2();
	}

	public void m2() {
		try {
			m1();
		} catch (Exception e) {
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e: ");
			e.printStackTrace();
		}
	}

	public void m1() throws Exception {
		throw new Exception("An exception from M1().");
	}
}
