package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Bookings {
    public static void main(String[] args) {
        Bookings tim = new Bookings();
        tim.entrypoint();
    }

    public void entrypoint() {
        List<List<Integer>> list1 = new ArrayList<>();
//        list1.add(Arrays.asList(7));
//        list1.add(Arrays.asList(3));
        list1.add(Arrays.asList(1, 1481122000, 1481122020));
        list1.add(Arrays.asList(3, 1481122000, 1481122020));
        list1.add(Arrays.asList(1,1481122020,1481122040));
        list1.add(Arrays.asList(2,1481122020,1481122040));
        list1.add(Arrays.asList(3,1481122040,1481122060));
        list1.add(Arrays.asList(1,1481122050,1481122060));
        list1.add(Arrays.asList(3,1481122070,1481122090));
//        list1.add(Arrays.asList(3,1481122070,1481122090));
//        list1.add(Arrays.asList(2));
        List<List<Integer>> ret = employeeWithLesserThanKBreaks(list1, 2);
        for (List<Integer> entry : ret) {
            System.out.println("id: " + entry.get(0) + ", breaks: " + entry.get(1));
        }
    }


    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        // Write your code here
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap();
        for (List<Integer> onecall : employeeCalls) {
            int id = onecall.get(0);
            int startTime = onecall.get(1);
            int endTime = onecall.get(2);
            if (map.containsKey(id)) {
                // compare existing endTime and current startTime
                int lastEndTime = map.get(id).get(0);
                int breaks = map.get(id).get(1);
                if (lastEndTime != startTime) {
                    ++ breaks;
                }
                map.put(id, Arrays.asList(endTime, breaks));
            } else {
                map.put(id, Arrays.asList(endTime, 0));
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            int breaks = entry.getValue().get(1);
            if (breaks < k) {
                ret.add(Arrays.asList(id, breaks));
            }
        }
        return ret;
    }

    public void entrypoint02() {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list101 = Arrays.asList(1234, 532632);
        List<Integer> list102 = Arrays.asList(234, 632633);
        List<Integer> list103 = Arrays.asList(2354, 732634);
        list1.add(list101);
        list1.add(list102);
        list1.add(list103);

        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> list201 = Arrays.asList(1234, 532632);
        List<Integer> list202 = Arrays.asList(234, 632633);
        List<Integer> list203 = Arrays.asList(458, 642633);
        List<Integer> list204 = Arrays.asList(2354, 732634);
        list2.add(list201);
        list2.add(list202);
        list2.add(list203);
        list2.add(list204);

        List<Integer> list = missingReservations(list1, list2);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        // Write your code here
        List<List<Integer>> missingResvs = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        set.addAll(secondReservationList);
        for (int i=0; i<secondReservationList.size(); i++) {
            boolean existing = false;
            List<Integer> resv = secondReservationList.get(i);
            for (int j=0; j<firstReservationList.size(); j++) {
                if (resv.get(0).equals(firstReservationList.get(j).get(0))) {
                    existing = true;
                    break;
                }
            }
            if (existing == false) {
                missingResvs.add(resv);
            }
        }
        return sort(missingResvs);
    }

    private List<Integer> sort(List<List<Integer>> resvs) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (List<Integer> one : resvs) {
            map.put(one.get(1), one.get(0));
        }
        return new ArrayList<Integer> (map.values());
    }

}
