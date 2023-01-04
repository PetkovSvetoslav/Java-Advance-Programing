package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument{
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    private void setPower(int power) {
        if (power < 0){
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }

    @Override
    public void use() {
        int newPower = this.power - 10;
        this.power = Math.max(newPower, 0);
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
