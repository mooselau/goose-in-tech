package topics.elevatorchoice;

import lombok.Data;


@Data
public class Elevator {
    private String id;
    private int currentFloor;
    private RunningState state;
    private int targetFloor;
    private String person;

    public void goToFloor(int targetFloor) {
        state = currentState(targetFloor);
        // loop until reach target floor
        while (Math.abs(targetFloor - currentFloor) > 0) {
            if (RunningState.GOING_UP.equals(state)) {
                moveUp();
            } else {
                moveDown();
            }
        }
    }

    private void moveUp() {
        p(String.format("Elevator[%s] is moving up[%s -> %s]", id, currentFloor, ++currentFloor));
        justMoving();
    }

    private void moveDown() {
        p(String.format("Elevator[%s] is moving down[%s -> %s]", id, currentFloor, --currentFloor));
        justMoving();
    }

    private void justMoving() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private RunningState currentState(int targetFloor) {
        return (targetFloor > currentFloor) ? RunningState.GOING_UP : RunningState.GOING_DOWN;
    }

    private void p(String msg) {
        System.out.println(msg);
    }

}
