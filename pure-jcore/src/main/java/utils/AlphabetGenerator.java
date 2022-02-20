package utils;

import java.util.LinkedList;
import java.util.List;

public class AlphabetGenerator {

	private static AlphabetGenerator gen;
	
	private AlphabetGenerator() {}
	
	public static AlphabetGenerator getInstance() {
		if (gen == null) {
			gen = new AlphabetGenerator();
		}
		return gen;
	}
	
	// alphabetic starter in lower cases: 97 ~ 122
	// in upper case: 65 ~ 90
	private int starter = 65;
	private int ender = starter;
	private List<Integer> alphabetList = new LinkedList<Integer>();
	
	public String getNextStringLetter() {
		alphabetList.add(ender);
		return String.valueOf((char)ender ++);
	}
	
	public int getCharUsedLength() {
		return alphabetList.size();
	}
	
	public int getEnder() {
		return ender;
	}
	
	public static void main(String[] args) {
		AlphabetGenerator ag = getInstance();
		System.out.println(ag.getNextStringLetter());
		System.out.println(ag.getNextStringLetter());
		System.out.println(ag.getNextStringLetter());
		
		System.out.println(ag.getCharUsedLength());
		System.out.println(ag.getEnder());
	}
	
}
