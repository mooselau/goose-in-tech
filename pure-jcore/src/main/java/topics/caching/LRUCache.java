package topics.caching;

import org.apache.commons.lang3.tuple.MutablePair;


/**
 * Least-Recently Used Cache
 */
public class LRUCache {

    private final int SIZE_THRESHOLD = 3;
    // private List<String> cachingList = new ArrayList<>(SIZE_THRESHOLD);
    // private Map.Entry[] entries = new Map.Entry[SIZE_THRESHOLD];
    // private HashMap<String, String> cacheMap = new HashMap<>();
    private MutablePair<String, String>[] cachePairs = new MutablePair[SIZE_THRESHOLD];

    private void put(String k, String v) {
        if (exists(k)) {
            // hit & move to front
            moveToLast(k);
            return;
        }

        insertToLast(k, v);
        // int size = cachingList.size();
        // if (size >= SIZE_THRESHOLD) {
        // throw the oldest
        // String removed = cachingList.remove(0);
        // }
        // cachingList.add(k);
    }

    private boolean exists(String k) {
        for (final MutablePair<String, String> cachePair : cachePairs) {
            if (null != cachePair && cachePair.left.equals(k)) {
                return true;
            }
        }
        return false;
    }

    private MutablePair<String, String> findPair(String k) {
        for (final MutablePair<String, String> cachePair : cachePairs) {
            if (cachePair.left.equals(k)) {
                return cachePair;
            }
        }
        return null;
    }

    private int indexOf(String k) {
        for (int i = 0; i < SIZE_THRESHOLD; i++) {
            if (cachePairs[i].left.equals(k)) {
                return i;
            }
        }
        return -1;
    }

    private void moveToLast(String k) {
        // find the pair
        MutablePair<String, String> p = findPair(k);

        if (null == p) {
            throw new IllegalArgumentException(String.format("Key[%s] not found.", k));
        }

        int index = indexOf(k);
        // if index is last then no need to move
        if (index == SIZE_THRESHOLD - 1) {
            return;
        }

        // keep target in temp object
        MutablePair<String, String> temp = new MutablePair<>(cachePairs[index].left, cachePairs[index].right);
        // move till the last one
        for (int i = index; i < SIZE_THRESHOLD - 1; i++) {
            cachePairs[i] = cachePairs[i + 1];
        }
        cachePairs[SIZE_THRESHOLD - 1] = temp;
    }

    private void insertToLast(String k, String v) {
        p("Element[" + cachePairs[0] + "] was removed");

        // move each element to one slot prior
        for (int i = 1; i < SIZE_THRESHOLD; i++) {
            cachePairs[i - 1] = cachePairs[i];
        }
        // add new element in the last
        cachePairs[SIZE_THRESHOLD - 1] = new MutablePair<>(k, v);
    }

    private void printCache() {
        for (final MutablePair<String, String> cachePair : cachePairs) {
            if (null != cachePair) {
                System.out.print(String.format("Pair[%s, %s] ", cachePair.left, cachePair.right));
            }
        }
        // cachingList.forEach(System.out::print);
        p("");
    }

    private void p(String msg) {
        System.out.println(msg);
    }

    public void entrypoint() throws InterruptedException {
        String[] elements = { "A", "B", "C", "A", "C", "A", "D", "E", "A" };
        int i = 0;
        while (i < elements.length) {
            put(elements[i], elements[i]);
            i++;
            printCache();

            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCache demo = new LRUCache();
        demo.entrypoint();
    }
}
