package corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LFUList {

    private Map<String, Integer> map = new HashMap<>();
    private int maxLen;

    public LFUList(int maxLen) {
        this.maxLen = maxLen;
    }

    public void hit(String element) {
        // print("\n===> before input " + element);
        String hitted = null;
        for (String key : map.keySet()) {
            if (key == element) {
                hitted = key;
            }
        }
        if (hitted != null) {
            map.put(hitted, map.get(hitted) + 1);
        } else {
            if (map.size() >= maxLen) {
                removeLeast();
            }
            map.put(element, 1);
        }
        print("\n===> after input " + element);
    }

    private void removeLeast() {
        Entry<String, Integer> least = null;
        for (Entry<String, Integer> en : map.entrySet()) {
            if (least == null) {
                // initial
                least = en;
            } else if(en.getValue() < least.getValue())  {
                least = en;
            }
        }
        map.remove(least.getKey());
    }

    public void print(String msg) {
        System.out.println(msg);
        for (Entry<String, Integer> en : map.entrySet()) {
            System.out.print("entry: " + en.getKey() + ", index: " + en.getValue() + "; ");
        }
    }
}
