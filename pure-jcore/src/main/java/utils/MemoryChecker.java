package utils;

public class MemoryChecker {
    private Runtime runtime;
    private static final long MEGABYTE = 1024L * 1024L;

    public MemoryChecker() {
        runtime = Runtime.getRuntime();
    }

    public void tryGC() {
        runtime.gc();
    }

    public void checkTotalMemory() {
        p("Total Mem: " + runtime.totalMemory() / MEGABYTE + "MB");
    }

    public void checkMemoryUsage() {
        p("Mem Usage: " + (runtime.totalMemory() - runtime.freeMemory() / MEGABYTE) + "MB");
    }

    public void checkFreeMemory() {
        p("Free Mem: " + runtime.freeMemory() / MEGABYTE + "MB");
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}
