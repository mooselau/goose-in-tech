package demodata;

public class Entrypoint {
    public static void main(String[] args) {
        Entrypoint test = new Entrypoint();
        test.entrypoint();
    }

    public void entrypoint() {
        Creature c = new Creature();
        Human h = new Human();
        c.saySometing();
        h.saySometing();

        Creature ch = new Human();
        ch.saySometing();
    }
}
