package other;

public class OObject {

	private String innerMsg = "I am another String";
	private static String msg = null;

	public OObject(String msg) {
		OObject.msg = msg;
		System.out.println(innerMsg);
	}

	public static String getMsg() {
		return msg;
	}
}
