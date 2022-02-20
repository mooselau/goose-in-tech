package other;

import java.math.BigDecimal;


public class Calculation {
    public static void main(String[] args) {
        Calculation demo = new Calculation();
        demo.entrypoint();
    }

    private void entrypoint() {
        long curr = System.currentTimeMillis();
        double num = 7.205759403793E+16;
        System.out.println(BigDecimal.valueOf(num).toPlainString());
        System.out.println(curr);
        System.out.println((Long.parseLong(BigDecimal.valueOf(num).toPlainString())));
    }
}
