package corejava;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTester {
	
	public static void main(String[] args) {
		HashMapTester et = new HashMapTester();
		et.testing();
//		System.out.println(et.isPrime(6) + "");
	}

	private void testing() {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		String s = "str";
		int i = 1;
		ht.put(s, i);
//		ht.put(null, i);
		System.out.println("Hashtable: ");
		for (Entry<String, Integer> en : ht.entrySet()) {
			System.out.println("en: " + en.getKey() + ", val: " + en.getValue());
		}
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put(s, i);
		hm.put(null, null);
		System.out.println("HashMap: ");
		for (Entry<String, Integer> en : hm.entrySet()) {
			System.out.println("en: " + en.getKey() + ", val: " + en.getValue());
		}
		
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<String, Integer>();
		chm.put(s, i);
//		chm.put(s, null);
		System.out.println("ConcurrentHashMap: ");
		for (Entry<String, Integer> en : chm.entrySet()) {
			System.out.println("en: " + en.getKey() + ", val: " + en.getValue());
		}
	}

}
