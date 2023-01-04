package fairyShop.models;

import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.Collection;

public class ShopImpl implements Shop{
    private HelperRepository helpers;
    private PresentRepository presents;

    public ShopImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }

    @Override
    public void craft(Present present, Helper helper) {
        Collection<Instrument> instruments = helper.getInstruments();
        if (helper.canWork()){
            for (Instrument tool : instruments) {
                while (helper.canWork() && !tool.isBroken() && !present.isDone()){
                    helper.work();
                    tool.use();
                    present.getCrafted();
                }
            }
        }
    }

}
