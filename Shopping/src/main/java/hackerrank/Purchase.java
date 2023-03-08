package hackerrank;

import persistent.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 *	TODO: Complete the Purchase class
 */
public class Purchase {
    /**
     * Find the PurchasedItems for each of the given barcodes.
     *
     * @param itemBarcodeList A list of barcodes.
     * @return A list of PurchasedItems.
     */
    public static List<PurchasedItem> getPurchasedItemsList(List<String> itemBarcodeList) {
        // TODO: Complete the function.
        String hql = "from Item i where i.itemBarcode IN (:barCodesList) and i.itemAvailablity =1";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("barCodesList", itemBarcodeList);
        List<Item> items = HibernateQueryRunner.getItemsList(hql, Optional.of(paramMap));
        List<PurchasedItem> purchasedItems = new ArrayList<>();
        for(Item item: items) {
            Float discountedPrice = item.getItemPrice() * ((100 - item.getItemDiscount())/ 100f);
            PurchasedItem purchasedItem = new PurchasedItem(item.getItemBarcode(),
                    item.getItemName(),
                    item.getItemCategory(),
                    discountedPrice);
            purchasedItems.add(purchasedItem);
        }
        return purchasedItems;
    }

    /**
     * Find the total number of available items in the given category.
     *
     * @param category The item's category.
     * @return The number of available items in that category.
     */
    public static Integer getNumberOfAvailableItemsInCategory(String category) {
    	// TODO: Complete the function.

        String hql = "from Item i where i.itemCategory = :category and i.itemAvailablity =1";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", category);
        List<Item> items = HibernateQueryRunner.getItemsList(hql, Optional.of(paramMap));
        return items.size() > 0 ? items.size() : 0 ;
    }

    /**
     * Find the total number of available items priced lower than upperLimit.
     *
     * @param upperLimit
     * @return available items with lower price than upperLimit
     */
    public static Integer getTotalAvailableLowerPricedItemsWithoutDiscount(Float upperLimit) {
    	// TODO: Complete the function.
        String hql = "from Item i where i.itemPrice < :limit and i.itemAvailablity = 1";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("limit", upperLimit);
        List<Item> items = HibernateQueryRunner.getItemsList(hql, Optional.of(paramMap));
        return items.size() > 0 ? items.size() : 0 ;
    }

    /**
     * Find the total number of available items priced higher than lowerLimit.
     * @param lowerLimit
     * @return available items with higher price than lowerLimit
     */
    public static Integer getTotalAvailableHigherPricedItemsWithoutDiscount(Float lowerLimit) {
    	// TODO: Complete the function.
        String hql = "from Item i where i.itemPrice > :limit and i.itemAvailablity =1";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("limit", lowerLimit);
        List<Item> items = HibernateQueryRunner.getItemsList(hql, Optional.of(paramMap));
        return items.size() > 0 ? items.size() : 0 ;
    }

    /**
     * Find whether the item with the given barcode is available.
     *
     * @param barcode The item's barcode.
     * @return true if the item is available and false if it is not.
     */
    public static boolean isAvailable(String barcode) {
    	// TODO: Complete the function.
        String hql = "from Item i where i.itemBarcode = :barcode";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("barcode", barcode);
        Item item = HibernateQueryRunner.getSingleItem(hql, Optional.of(paramMap));
        return item.getItemAvailability()? item.getItemAvailability():false;
    }

    /**
     * Count the total number of available items.
     *
     * @return The total number of available items.
     */
    public static Integer getTotalAvailableItems() {
    	// TODO: Complete the function.
        String hql = "from Item i where i.itemAvailablity = 1";
        List<Item> items = HibernateQueryRunner.getItemsList(hql, Optional.empty());
        return items.size() > 0 ? items.size() : 0 ;
    }

    /**
     * Count the total number of unavailable items.
     *
     * @return The total number of unavailable items.
     */
    public static Integer getTotalUnAvailableItems() {
    	// TODO: Complete the function.
        String hql = "from Item i where i.itemAvailablity = 0";
        List<Item> items = HibernateQueryRunner.getItemsList(hql, Optional.empty());
        return items.size() > 0 ? items.size() : 0 ;
    }
}
