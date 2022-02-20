package utils;

import java.util.function.Consumer;
import lombok.Getter;
import lombok.Setter;


public final class ParamUtil {

    private ParamUtil() {
    }

    public static <O> void setIfNotNull(O subject, Consumer<O> consumer) {
        if (subject != null) {
            consumer.accept(subject);
        }
    }

    @Getter
    @Setter
    private static class DemoBox {
        private String label;
        private String label02;
    }

    public static void main(String[] args) {
        System.out.println("== ==");
        DemoBox box = new DemoBox();

        String target = " hello ";
        String subject = " world ";
        setIfNotNull("01" + subject + target, box::setLabel);
        setIfNotNull("02" + target + subject, box::setLabel02);

        System.out.println(box.getLabel());
        System.out.println(box.getLabel02());
    }

}
