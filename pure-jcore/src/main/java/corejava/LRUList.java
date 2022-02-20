package corejava;

import lombok.Data;

public class LRUList<E> {
    private Node<E> head = new Node<>(null);
    private Node<E> tail;
    private int maxLen;
    private int length;

    public LRUList(int maxLen) {
        this.maxLen = maxLen;
    }

    public void hit(E element) {
        Node<E> el = new Node<E>(element);
        print("\n===> before input: " + element.toString());
        Node<E> hitted = findHitted(el);
        if (length == 0) {
            head.next = el;
            tail = el;
            length++;
            return;
        } else if (hitted == null) {
            // not found
            Node<E> prevHead = head.next;
            head.next = el;
            el.next = prevHead;
            prevHead.prev = el;
            length++;
            if (length > maxLen) {
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            adjustLengthWithHitted(hitted);
        }
        // print
        print("\n===> after input: " + element.toString());
    }

    private Node<E> findHitted(Node<E> node) {
        Node<E> itr = head;
        while (itr.next != null) {
            Node<E> current = itr.next;
            if (current.getElement().equals(node.getElement())) {
                return current;
            }
            itr = itr.next;
        }
        return null;
    }

    private void adjustLengthWithHitted(Node<E> hitted) {
        if (hitted == head.next) {
            // not need to change if hitted already the first
            return ;
        }

        // for tail
        if (hitted == tail) {
            tail = hitted.prev;
        }

        // found
        Node<E> prev = hitted.prev;
        Node<E> next = hitted.next;
        // possible null!
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }

        Node<E> currentHead = head.next;
        head.next = hitted;
        hitted.prev = null;
        hitted.next = currentHead;
        currentHead.prev = hitted;
    }

    @Data
    private class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E element;

        public Node(E element) {
            this.element = element;
            prev = null;
            next = null;
        }
    }

    public void print(String msg) {
        Node<E> itr = head;
        System.out.println(msg);
        while (itr.next != null) {
            System.out.print(itr.next.element + " ");
            itr = itr.next;
        }
    }

    public static void main(String[] args) {
        LRUList tester = new LRUList(3);
        tester.test();
    }
    public void test() {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        n1.next = n2;
        n3.next = n1;
        System.out.println(n3.next.next.element);

        Node n4 = new Node("D");
        n1.next = n4;
        System.out.println(n3.next.next.element);
    }

}
