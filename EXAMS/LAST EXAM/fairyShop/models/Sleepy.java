package fairyShop.models;

public class Sleepy extends BaseHelper{
    private static final int BASE_ENERGY = 50;

    public Sleepy(String name) {
        super(name, BASE_ENERGY);
    }

    @Override
    public void work() {
        int newEnergy = super.getEnergy() - 15;
        this.setEnergy(Math.max(newEnergy, 0));
    }
}
