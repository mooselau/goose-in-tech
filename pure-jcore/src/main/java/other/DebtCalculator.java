package other;

public class DebtCalculator {
    public static void main(String[] args) {
        DebtCalculator demo = new DebtCalculator();
        demo.entrypoint();
    }

    public void entrypoint() {
        // 标价出发，按照核验比例
        fromDisplayPrice(205, 0.6); // 标价，核验比例
        // 首付现金出发
        fromDownPaymentCash(128); // 首付现金
    }

    private void fromDisplayPrice(int displayPrice, double ratio) {
        final double taxPortion = 0.01; // 1%契税
        final double feePortion = 0.03; // 3%中介费

        double afterCheckPrice = displayPrice * ratio; // 核验价
        double downPaymentCash = displayPrice - 0.65 * afterCheckPrice; // 首付现金 = 标价 - 贷款价 = 标价 - 核验价 * 0.65
        final double tax = taxPortion * afterCheckPrice; // 核验价得出契税
        double fee = feePortion * displayPrice; // 标价得出中介费

        double totalDownPayment = downPaymentCash + fee + tax; // 总首付 = 首付现金 + 税费 + 中介费
        p("从 " + displayPrice + "w 标价 和 " + ratio * 10 + "折 出发");
        p(String.format("首付总价: %.2fw, 额外税费: %.2fw, 中介费: %.2fw\n", totalDownPayment, tax, fee));
    }

    private void fromDownPaymentCash(int downPaymentCash) {
        final double debtDiscount = 0.65;
        final double downPaymentPortion = 0.35;
        // 55% 核验价
        double percents = 0.45 + 0.55 * 0.35 + 0.03 + 0.01 * 0.55;
        double displayMin = downPaymentCash / percents;

        // 60% 核验价
        percents = 0.4 + 0.6 * 0.35 + 0.03 + 0.01 * 0.6;
        double displayMid = downPaymentCash / percents;

        // 65% 核验价
        percents = 0.35 + 0.65 * 0.35 + 0.03 + 0.01 * 0.65;
        double displayMax = downPaymentCash / percents;

        p("从 " + downPaymentCash + "w 首付现金出发");
        p(String.format("55折: 标价 %.2fw, 贷款: %.2fw, 核验价 %.2fw(核验价低)\n"
                        + "6折: 标价 %.2fw, 贷款: %.2fw, 核验价 %.2fw(核验价中等)\n"
                        + "65折: 标价 %.2fw, 贷款: %.2fw, 核验价 %.2fw(核验价高)\n",
                displayMin, 0.55 * displayMin * debtDiscount, 0.55 * displayMin,
                displayMid, 0.6 * displayMid * debtDiscount, 0.6 * displayMid,
                displayMax, 0.65 * displayMax * debtDiscount, 0.65 * displayMax
        ));
    }

    private void p(String msg) {
        System.out.println(msg);
    }

}
