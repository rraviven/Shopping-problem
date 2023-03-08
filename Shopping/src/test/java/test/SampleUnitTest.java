package test;

import hackerrank.HibernateSessionHelper;
import hackerrank.Purchase;
import hackerrank.PurchasedItem;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;

public class SampleUnitTest {
    
    @BeforeClass
    public static void reopen() {
        if (!HibernateSessionHelper.hibernateSession.getSession().isConnected()) {
            System.out.println("Reopening Session");
            
            HibernateSessionHelper.reopenSession();
        }
    }
    
    @AfterClass
    public static void close() {
        HibernateSessionHelper.hibernateSession.closeSession();
    }
    
    @Test
    public void DayOnePurchaseTest() {
        List<String> itemsBarcode = Arrays.asList("74003658", "74001672", "74004703", "47000022", "74002280");
        List<PurchasedItem> purchasedItemsList = Purchase.getPurchasedItemsList(itemsBarcode);
        
        assertEquals(itemsBarcode.stream().filter(e -> e.startsWith("74")).count(), purchasedItemsList.size());
        
        float total = purchasedItemsList.stream().map((item) -> item.getItemDiscountedPrice())
                .reduce(0.0f, (accumulator, _item) -> accumulator + _item);
        
        assertEquals(12495.77, total, 0.01f);
    }
    
    @Test
    public void DayTwoPurchaseTest() {
        List<String> itemsBarcode = Arrays.asList("47000282", "74004115", "74000628", "74003072", "74000938", "74000366", "47000350", "74004573", "74004124", "74000897", "74001454");
        List<PurchasedItem> purchasedItemsList = Purchase.getPurchasedItemsList(itemsBarcode);
        
        assertEquals(itemsBarcode.stream().filter(e -> e.startsWith("74")).count(), purchasedItemsList.size());
        
        float total = purchasedItemsList.stream().map((item) -> item.getItemDiscountedPrice())
                .reduce(0.0f, (accumulator, _item) -> accumulator + _item);
        
        assertEquals(15377.551, total, 0.01f);
    }
    
    @Test
    public void DayThreePurchaseTest() {
        List<String> itemsBarcode = Arrays.asList("47000676", "74001147", "74001950", "74001713", "47000483", "74001217", "74003429", "74003960", "47000310", "74004211", "74004568", "47000334", "74000819", "74001093", "74004554", "74004244", "47000030", "74003966", "74003160", "74004175", "74002023", "74001669", "74002922", "74004446", "74002695");
        List<PurchasedItem> purchasedItemsList = Purchase.getPurchasedItemsList(itemsBarcode);
        
        assertEquals(itemsBarcode.stream().filter(e -> e.startsWith("74")).count(), purchasedItemsList.size());
        
        float total = purchasedItemsList.stream().map((item) -> item.getItemDiscountedPrice())
                .reduce(0.0f, (accumulator, _item) -> accumulator + _item);
        
        assertEquals(32599.93, total, 0.01f);
    }
    
    @Test
    public void DayFourPurchaseTest() {
        List<String> itemsBarcode = Arrays.asList("74000837", "47000572", "74002313", "74001861", "74001067", "47000991", "74002998", "74001054", "74004501", "74001000", "74004792", "74002879", "74004171", "74002986", "74001618", "74002680", "47000361", "74000503", "47000806", "74004482", "74002841", "74001439", "74003553", "74002550", "47000299", "74004163", "74002681", "74002056", "74002617", "74000043", "74004487", "47000708", "74002140", "74000759", "74004633", "47000937", "74002003", "74002461", "47000933", "74000578", "74004288", "74000809", "74000387", "47000738", "74004909", "74000122", "74000803", "74003370", "74002666", "74002349");
        List<PurchasedItem> purchasedItemsList = Purchase.getPurchasedItemsList(itemsBarcode);
        
        assertEquals(itemsBarcode.stream().filter(e -> e.startsWith("74")).count(), purchasedItemsList.size());
        
        float total = purchasedItemsList.stream().map((item) -> item.getItemDiscountedPrice())
                .reduce(0.0f, (accumulator, _item) -> accumulator + _item);
        
        assertEquals(92870.76, total, 0.01f);
    }
    
    @Test
    public void itemNotAvailableTest() {
        assertFalse(Purchase.isAvailable("47000572"));
    }
    
    @Test
    public void numberOfAvailableItemsInCategoryTest() {
        Integer countTops = Purchase.getNumberOfAvailableItemsInCategory("Tops");
        Integer countBottoms = Purchase.getNumberOfAvailableItemsInCategory("Bottoms");
        Integer countFootwear = Purchase.getNumberOfAvailableItemsInCategory("Footwear");
        
        //assertTrue(countTops == 812);
        assertTrue(countBottoms == 348);
        assertTrue(countFootwear == 290);
    }
}
