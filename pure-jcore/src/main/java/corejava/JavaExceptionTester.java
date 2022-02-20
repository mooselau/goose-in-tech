package corejava;

public class JavaExceptionTester {
	
	public static void main(String[] args) {
		JavaExceptionTester tim = new JavaExceptionTester();
		tim.doTesting();
	}
	
	public void doTesting() {
		try {
			throw new CustomException("Exception happened", new Exception("IO error!"));
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println(e.toString());
//			System.out.println("msg: " + e.getMessage());
//			System.out.println("root cause: " + e.getCause().getMessage());
		}
	}
	
	private class CustomException extends Exception {
		private static final long serialVersionUID = -5625887648190226759L;
		public CustomException(String msg, Throwable cause) {
			super(msg, cause);
		}
	}
}
