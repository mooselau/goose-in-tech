package leetcode;

public class ASampleTemplate {
	
	public static void main(String[] args) {
		ASampleTemplate tim = new ASampleTemplate();
		int ret = tim.functionName();
		tim.p("result: " + ret);
	}
	
	/*
	 * Function entry in Leet Code
	 */
	public int functionName() {
		String str = "";
		return way1(str);
	}
	
	/*
	 * For you to write
	 */
	public int way1(String s) {
		return 0;
	}

	/*
	 * This is standard solution to this problem
	 */
	 public int standardWay(String s) {
	 	 return Answers.romanToInt(s);
	 }
	 
	 /*
	  * This is smart solution to this problem
	  */
	public int smartWay(String s) {
		return SmartAnswers.romanToInt(s);
	}
    
    public void p(String msg) {
    	System.out.println(msg);
    }
    
}
