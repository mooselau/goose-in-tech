package leetcode;

public class FibonacciSequence {

    public static void main(String[] args) {
        FibonacciSequence tim = new FibonacciSequence();
        tim.printFibonacci();
    }

    public void printFibonacci() {
        // print specific value
        int index = 10;
        for (int i = 0; i <= index; i++) {
            p(fibonacci(i) + " ");
        }
    }

    private int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        } else {
            return fibonacci(i - 2) + fibonacci(i - 1);
        }
    }

    /*
     * For you to write
     */
    public void way1(int index) {
//        if (index == 0 || index == 1) {
//            return index;
//        } else {
//            int a = way1(index - 2);
//            int b = way1(index - 1);
//            if (a >= Integer.MAX_VALUE || b >= Integer.MAX_VALUE) {
//                throw new IllegalArgumentException("stack overflow found!");
//            }
//            return a + b;
//        }
    }

    /*
     * This is standard solution to this problem
     */
    public int standardWay(String s) {
        return Answers.romanToInt(s);
    }

    /*
     * This is smart solution to this problem
     */
    public int smartWay(String s) {
        return SmartAnswers.romanToInt(s);
    }

    public void p(String msg) {
        System.out.println(msg);
    }
}
