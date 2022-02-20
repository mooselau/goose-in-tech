package corejava.io;

import utils.StringUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadFile {
	
	private static StringUtilities tool = StringUtilities.getInstance();
	
	public static void main(String[] args) throws IOException {
		ReadFile rf = new ReadFile();
		tool.print(rf.readFile("Text.txt"));
	}
	
	public String readFile(String fileName) throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		BufferedReader reader = null;
		StringBuilder sb =  new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String s;
			while((s = reader.readLine()) != null) {
				list.add(s);
			}
			System.out.println();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
		while (!list.isEmpty()) {
			String outputStr = list.removeLast();
			sb.append(outputStr + "\n");
		}
		return sb.toString();
	}
}
