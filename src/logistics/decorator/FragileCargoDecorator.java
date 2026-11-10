package logistics.decorator;

public class FragileCargoDecorator extends DeliveryDecorator {
    private static final double FRAGILE_FEE = 1500;

    public FragileCargoDecorator(DeliveryService wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Fragile cargo";
    }

    @Override
    public double getCost() {
        return super.getCost() + FRAGILE_FEE;
    }
}
