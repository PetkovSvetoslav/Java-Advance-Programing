package gifts;


import org.junit.Assert;
import org.junit.Test;

public class GiftFactoryTests {

    @Test
    public void giftCreationTest(){
    Gift gift1 = new Gift("Triangle",2.14);
    Gift gift2 = new Gift("Box",1.14);
    Gift gift3 = new Gift("Circle", 3.14);
    GiftFactory giftFactory = new GiftFactory();
    giftFactory.createGift(gift2);
    Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void giftCreationThrowableTest(){
        Gift gift1 = new Gift("Box",1.14);
        Gift gift2 = new Gift("Box",1.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
    }

    @Test
    public void giftRemovalTest(){
        Gift gift1 = new Gift("Triangle",1.14);
        Gift gift2 = new Gift("Box",2.14);
        Gift gift3 = new Gift("Circle", 3.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(3, giftFactory.getCount());
        giftFactory.removeGift("Box");
        Assert.assertEquals(2, giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void giftRemovalThrowableTest(){
        Gift gift1 = new Gift("Box",1.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        Assert.assertEquals(1, giftFactory.getCount());
        giftFactory.removeGift(" ");
    }

    @Test
    public void getLesserMagicPresentTest() {
        Gift gift1 = new Gift("Triangle", 1.14);
        Gift gift2 = new Gift("Box", 2.14);
        Gift gift3 = new Gift("Circle", 3.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift1, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void getPresentByNameTest() {
        Gift gift1 = new Gift("Triangle", 1.14);
        Gift gift2 = new Gift("Box", 2.14);
        Gift gift3 = new Gift("Circle", 3.14);
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift1, giftFactory.getPresent("Box"));
    }


}
