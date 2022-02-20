package demodata;

public class Human extends Creature {
    private int i = 100;

    @Override
    public void saySometing() {
        System.out.println("I am human being, with id: " + i);
    }
}
