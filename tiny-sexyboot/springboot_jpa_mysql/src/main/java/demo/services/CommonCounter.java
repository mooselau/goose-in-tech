package demo.services;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;


@Component
public class CommonCounter {
    private AtomicInteger totalOrder = new AtomicInteger(0);

    public void addOne() {
        totalOrder.addAndGet(1);
    }

    public int getCount() {
        return totalOrder.get();
    }
}
