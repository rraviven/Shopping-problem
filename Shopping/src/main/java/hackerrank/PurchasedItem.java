package hackerrank;

public class PurchasedItem {
    private final String barcode;
    private final String name;
    private final String category;
    private final Float discountedPrice;
    
    /**
     * @param barcode The item's barcode.
     * @param name The item's name.
     * @param category The item's category.
     * @param finalPrice The item's discounted (final) price.
     */
    public PurchasedItem(String barcode, String name, String category, Float finalPrice) {
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.discountedPrice = finalPrice;
    }
    
    /**
     * @return The purchased item's barcode.
     */
    public String getItemBarcode() {
        return barcode;
    }
    
    /**
     * @return The purchased item's name.
     */
    public String getItemName() {
        return name;
    }
    
    /**
     * @return The purchased item's category.
     */
    public String getItemCategory() {
        return category;
    }
    
    /**
     * @return The purchased item's discounted price.
     */
    public Float getItemDiscountedPrice() {
        return discountedPrice;
    }
    
    /**
     * @return The purchased item's details.
     */
    @Override
    public String toString() {
        String details = getItemBarcode() + ", " + getItemName() + ", " + getItemCategory() + ", "
                + getItemDiscountedPrice().toString();
        
        return details;
    }
}
