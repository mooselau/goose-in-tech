package topics.elevatorchoice;

import java.util.ArrayList;
import java.util.List;


public class ElevatorManager {

    private static final int WORKER_SIZE = 2;
    private final List<Elevator> elevators;

    public ElevatorManager() {
        elevators = new ArrayList<>();
        for (int i = 1; i <= WORKER_SIZE; i++) {
            Elevator elevator = new Elevator();
            elevator.setId(i + "号");
            elevators.add(elevator);
        }
    }

    public void useElevator(String person, int currentFloor, int targetFloor) {
        p(String.format("Person[%s] standing on [%s]floor wants to go [%s]floor", person, currentFloor, targetFloor));

        Elevator elevator = selectElevator(currentFloor, targetFloor);
        p(String.format("Elevator[%s] is answering Person[%s]", elevator.getId(), person));
        // move to customer's floor
        elevator.goToFloor(currentFloor);
        p(String.format("Elevator[%s] picked Person[%s] on [%s]floor, now going to [%s]floor", elevator.getId(),
                person, currentFloor, targetFloor));
        // travel customer
        elevator.goToFloor(targetFloor);

        p(String.format("Person[%s] from [%s]floor arrived [%s]floor", person, currentFloor, targetFloor));
    }

    public Elevator selectElevator(int fromFloor, int toFloor) {
        return doSelection(fromFloor, toFloor);
    }

    public Elevator doSelection(int fromFloor, int toFloor) {
        final int INIT = -1;

        Elevator closest = elevators.get(0); // initial
        int gap = INIT;
        for (Elevator e : elevators) {
            int t = Math.abs(e.getCurrentFloor() - fromFloor);
            if (gap == INIT) {
                gap = t;
                closest = e;
            } else if (t < gap) {
                gap = t;
                closest = e;
            }
        }

        return closest;
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}
