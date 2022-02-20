package leetcode;

import java.util.ArrayList;
import java.util.List;
import utils.StringUtilities;

public class DiffWaysToAddParentheses {
	
	private static StringUtilities tool = StringUtilities.getInstance();
	private static List<Integer> results = new ArrayList<Integer>();
	static String flag = "i";
	
	public static void main(String[] args) {
		
		String input = "2*3-4*5";
		entryPoint(input);
		
		tool.printNoln("[");
		for (Integer i : results) {
			tool.printNoln(""+i+" ");
		}
		tool.printNoln("]\n");
		
	}
	
	private static void entryPoint(String input) {
		
		// 1. pick up numbers and ops
		boolean ifCharIsNumber = false;
		int tempNumber = 0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> opList = new ArrayList<String>();
		for (int i=0; i<input.length(); i++) {
			
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				int cInt = c - 48;
				tempNumber = 10*tempNumber + cInt;
				if (i == input.length() - 1) {
					// for the last digit
					numList.add(tempNumber);
//					tool.print("num: "+String.valueOf(tempNumber));
				}
			} else {
				// save this number
				numList.add(tempNumber);
//				tool.print("num: "+String.valueOf(tempNumber));
				// save this operator
				opList.add(String.valueOf(c));
//				tool.print("op: "+String.valueOf(c));
				// reset indicators
				tempNumber = 0;
			}
			
		}
		
		processCalc(numList, opList);
		return ;
	}
	
	private static void processCalc(List<Integer> numList, List<String> opList) {
		
		// 2. calculate every pair
		// use numList.size() - 1, to make sure the last pair of A & B is existed..
		for (int i=0;i<numList.size()-1;i++) {
			
			int numA = numList.get(i);
			int numB = numList.get(i+1);
			
			String op = opList.get(i);
			
			int numC = 0;
			switch(op) {
				case("+"):
					numC = numA + numB;
					tool.print(numA + "+" + numB);
					break;
				case("-"):
					numC = numA - numB;
					tool.print(numA + "-" + numB);
					break;
				case("*"):
					numC = numA * numB;
					tool.print(numA + "*" + numB);
					break;
				default: 
					throw new IllegalArgumentException("Operation \""+op+"\" cannot be found!");
			}
			
			// break the loop if no numbers left
			// numC is the result of this round of calculation
			if (numList.size() == 2 && opList.size() == 1) {
				results.add(numC);
				tool.print("One round is over!");
				break;
			}
			
			// do following when list has more than 2 numbers
			List<Integer> copyNumList = new ArrayList<Integer>();
			copyNumList.addAll(numList);
			List<String> copyOpList = new ArrayList<String>();
			copyOpList.addAll(opList);
			
			// replace A & B with C
			copyNumList.remove(i+1);
			copyNumList.remove(i);
			copyNumList.add(i, numC);
			
			// remove operator of A & B
			copyOpList.remove(i);
			
			// do the recursion
			processCalc(copyNumList, copyOpList);
		}
		
		return ;
		
//		return resultNum;
//		throw new UnexpectedException("All numbers are out but not returned here..");
	}
	
}
