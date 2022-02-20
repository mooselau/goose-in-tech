package topics.elevatorchoice;

import java.io.IOException;
import java.util.Scanner;


public class StartPoint {

    public static void main(String[] args) throws IOException {
        StartPoint demo = new StartPoint();
        demo.entrypoint();
    }

    private final ElevatorManager elevatorManager = new ElevatorManager();

    public void entrypoint() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // person floor
            if (line.equals("quit")) {
                break;
            } else if (line.isEmpty()) {
                continue;
            }
            // accept input
            String[] split = line.split("\\s");
            String person = split[0];
            int currentFloor = Integer.parseInt(split[1]);
            int targetFloor = Integer.parseInt(split[2]);
            // use elevator
            elevatorManager.useElevator(person, currentFloor, targetFloor);

            System.out.println("Continue..");
        }
        System.out.println("Bye");
        System.exit(1);
    }

    private void init() {

    }

}
