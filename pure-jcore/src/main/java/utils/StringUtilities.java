package utils;

public class StringUtilities {
	
	private static StringUtilities tools= null;
	
	private StringUtilities() {
	}
	
	// TODO: not thread safety!!
	public static StringUtilities getInstance() {
		if (tools == null) {
			tools = new StringUtilities();
		}
		return tools;
	}
	
	public void print(String msg) {
		System.out.print(msg);
	}
	
	public void println(String msg) {
		System.out.println(msg);
	}
	
	public void printNoln(String msg) {
		System.out.print(msg);
	}
	
	public String removeEmptySpacesInString(String rawStr) {
		String regex = "([ ])";
		return rawStr.replaceAll(regex, "");
	}
	
}
