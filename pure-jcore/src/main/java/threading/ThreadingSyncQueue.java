package threading;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class ThreadingSyncQueue<T extends  Object> implements BlockingQueue<T> {

    private int currentSize; // current used length
    private int totalSize;
    private T[] jobs;
    private Object mutex = new Object();

    public ThreadingSyncQueue(int capacity) {
        totalSize = capacity;
        jobs = (T[]) new Object[capacity];
    }

    @Override
    public void put(final T o) throws InterruptedException {
        synchronized (mutex) {
            // wait if queue full
            while (currentSize >= totalSize) {
                mutex.wait();
            }

            // otherwise fill it, increase currentSize
            jobs[currentSize ++] = o;

            printArray();

            // notify waiting threads to work
            mutex.notifyAll();
        }
    }

    @Override
    public T take() throws InterruptedException {
        final int ZERO = 0, SECOND = 1;
        synchronized (mutex) {
            // wait if queue is empty
            while(currentSize <= ZERO) {
                mutex.wait();
            }

            // otherwise return element
            T target = jobs[0];
            // jobs = Arrays.copyOfRange(jobs, SECOND, totalSize);
            // shifting elements from right to left by 1 position
            for (int i = SECOND; i<totalSize ; i++) {
                jobs[i - 1] = jobs[i];
            }
            jobs[totalSize - 1] = null;

            currentSize --; // current size - 1

            printArray();

            // notify waiting threads to work
            mutex.notifyAll();

            return target;
        }
    }

    private void printArray() {
        System.out.println("ARRAYS: " + Arrays.toString(jobs) + ", CURRENT: " + currentSize);
    }

    public static void main(String[] args) {
        String[] array = { "abc", "bcd", "def", "efg", "fgh" };

        array = Arrays.copyOfRange(array, 1, array.length);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override public boolean add(final Object o) {
        return false;
    }

    @Override public boolean offer(final Object o) {
        return false;
    }

    @Override public T remove() {
        return null;
    }

    @Override public T poll() {
        return null;
    }

    @Override public T element() {
        return null;
    }

    @Override public T peek() {
        return null;
    }

    @Override public boolean offer(final Object o, final long timeout, final TimeUnit unit)
            throws InterruptedException {
        return false;
    }

    @Override public T poll(final long timeout, final TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override public int remainingCapacity() {
        return 0;
    }

    @Override public boolean remove(final Object o) {
        return false;
    }

    @Override public boolean addAll(final Collection c) {
        return false;
    }

    @Override public void clear() {

    }

    @Override public boolean retainAll(final Collection c) {
        return false;
    }

    @Override public boolean removeAll(final Collection c) {
        return false;
    }

    @Override public boolean containsAll(final Collection c) {
        return false;
    }

    @Override public boolean contains(final Object o) {
        return false;
    }

    @Override public Iterator iterator() {
        return null;
    }

    @Override public Object[] toArray() {
        return new Object[0];
    }

    @Override public Object[] toArray(final Object[] a) {
        return new Object[0];
    }

    @Override public int drainTo(final Collection c) {
        return 0;
    }

    @Override public int drainTo(final Collection c, final int maxElements) {
        return 0;
    }

}
