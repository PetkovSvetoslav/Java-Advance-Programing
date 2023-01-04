package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller{
    private HelperRepository helpers;
    private PresentRepository presents;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type){
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            case "Happy":
                helper = new Happy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        this.helpers.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helpers.findByName(helperName);
        Instrument instrument = new InstrumentImpl(power);

        if (helper != null){
            helper.addInstrument(instrument);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presents.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Shop shop = new ShopImpl();
        Present presentToWorkOn = presents.findByName(presentName);

        List<Helper> workingHelpers = new ArrayList<>();
        for (Helper helper : helpers.getModels()) {
            if (helper.getEnergy() > 50){
                workingHelpers.add(helper);
            }
        }

        if (workingHelpers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        } else {
            for (Helper workingHelper : workingHelpers) {
                shop.craft(presentToWorkOn, workingHelper);
            }
        }

        String presentDone = "";
        if (presentToWorkOn.isDone()){
            presentDone = "done";
        } else {
            presentDone = "not done";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(ConstantMessages.PRESENT_DONE, presentName, presentDone));

        int brokenInstruments = 0;
        for (Instrument instrument : workingHelpers.get(0).getInstruments()) {
            if (instrument.isBroken()){
                brokenInstruments++;
            }
        }

        builder.append(String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments));

        return builder.toString();
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();

        List<Present> presentsDone = new ArrayList<>();
        for (Present present : presents.getModels()) {
            if (present.isDone()){
                presentsDone.add(present);
            }
        }
        builder.append(String.format("%d presents are done!", presentsDone.size()));
        builder.append(System.lineSeparator());

        builder.append("Helpers info:");
        builder.append(System.lineSeparator());

        for (Helper helper : helpers.getModels()) {
            builder.append(String.format("Name: %s", helper.getName()));
            builder.append(System.lineSeparator());
            builder.append(String.format("Energy: %d", helper.getEnergy()));
            builder.append(System.lineSeparator());

            int brokenInstruments = 0;
            for (Instrument instrument : helper.getInstruments()) {
                if (!instrument.isBroken()){
                    brokenInstruments++;
                }
            }
            builder.append(String.format("Instruments: %d not broken left", brokenInstruments));
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
