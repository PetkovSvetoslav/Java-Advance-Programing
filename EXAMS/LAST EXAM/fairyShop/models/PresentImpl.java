package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class PresentImpl implements Present{
    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    private void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0){
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }

        this.energyRequired = energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        int newEnergyRequired = this.energyRequired - 10;
        this.energyRequired = Math.max(newEnergyRequired, 0);
    }
}
