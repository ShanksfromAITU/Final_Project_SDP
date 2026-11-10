package logistics.decorator;

public class InsuranceDecorator extends DeliveryDecorator {
    private static final double INSURANCE_FEE = 2000;

    public InsuranceDecorator(DeliveryService wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Insurance";
    }

    @Override
    public double getCost() {
        return super.getCost() + INSURANCE_FEE;
    }
}
