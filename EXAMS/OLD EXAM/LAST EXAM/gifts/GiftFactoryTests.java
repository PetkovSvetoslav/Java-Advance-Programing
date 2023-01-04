package gifts;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GiftFactoryTests {

    @Test
    public void testCreateGift(){
    Gift gift1 = new Gift("Box",1.14);
    Gift gift2 = new Gift("Square",2.14);
    Gift gift3 = new Gift("Oval", 3.14);
    GiftFactory giftFactory = new GiftFactory();
    giftFactory.createGift(gift1);
    Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftThrow (){
        Gift gift1 = new Gift("Box",1.14);
        Gift gift2 = new Gift("Box",1.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
    }

    @Test
    public void testRemoveGift(){
        Gift gift1 = new Gift("Box",1.14);
        Gift gift2 = new Gift("Square",2.14);
        Gift gift3 = new Gift("Oval", 3.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(3, giftFactory.getCount());
        giftFactory.removeGift("Box");
        Assert.assertEquals(2, giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftThrow (){
        Gift gift1 = new Gift("Box",1.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        Assert.assertEquals(1, giftFactory.getCount());
        giftFactory.removeGift(" ");
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        Gift gift1 = new Gift("Box", 1.14);
        Gift gift2 = new Gift("Square", 2.14);
        Gift gift3 = new Gift("Oval", 3.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift1, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresentByName() {
        Gift gift1 = new Gift("Box", 1.14);
        Gift gift2 = new Gift("Square", 2.14);
        Gift gift3 = new Gift("Oval", 3.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift1, giftFactory.getPresent("Box"));
    }


}
