package corejava;

public class LRUnLFU {
    public static void main(String[] args) {
        LRUnLFU tester = new LRUnLFU();
        tester.doCacheManage();
    }

    public void doCacheManage() {
        String[] ss = {"A", "B", "B", "A", "C", "D"};
        for (String s : ss) {
//            doLRU(s);
            doLFU(s);
        }
    }

    LRUList<String> lru = new LRUList<>(3);

    /**
     * Least Recently Used
     *
     * @param s
     */
    private void doLRU(String s) {
        lru.hit(s);
    }

    private LFUList lfu = new LFUList(3);

    /**
     * Least Frequently Used
     *
     * @param s
     */
    private void doLFU(String s) {
        lfu.hit(s);
    }

}
