package demo.configurations;

import java.util.Map;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;


/**
 * Configure the Async ThreadPool for Async Processing.
 */
public class AsyncTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(final Runnable runnable) {
        // pass current MDC context to next thread
        Map<String, String> context = MDC.getCopyOfContextMap();
        return () -> {
            try {
                // set context before running
                MDC.setContextMap(context);
                runnable.run();
            } finally {
                // clear context when it ends processing
                MDC.clear();
            }
        };
    }
}
