package other;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.RandomStringUtils;


public class OtherTesting {
    public static void main(String[] args) {
        OtherTesting tester = new OtherTesting();
        tester.entrypoint();
    }

    public void entrypoint() {
        int loopTimes = 10000;
        int timesSum = 0;
        int minConflictTime = loopTimes, maxConflictTime = 0;
        for (int i = 0; i < loopTimes; i++) {
            int time = loopCheck();
            timesSum += time;

            if (time < minConflictTime) {
                minConflictTime = time;
            }
            if (time > maxConflictTime) {
                maxConflictTime = time;
            }
        }

        p("AVG conflict time is: " + timesSum * 1.0 / loopTimes);
        p("MIN is: " + minConflictTime + ", MAX is: " + maxConflictTime);
    }

    public int loopCheck() {
        Set<String> set = new HashSet<>();
        while (true) {
            String random = RandomStringUtils.randomNumeric(6);
            boolean exists = !set.add(random);
            if (exists) {
                break;
            }
        }
        // p("found exists when: " + set.size() + " times");
        return set.size();
    }

    public void p(String msg) {
        System.out.println(msg);
    }

}
