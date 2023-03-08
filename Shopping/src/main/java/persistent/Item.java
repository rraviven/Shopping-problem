package persistent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory")
public class Item implements Serializable {
	private static final long serialVersionUID = -9169537743929944714L;

	@Id
    @Column(name = "barcode")
    private String itemBarcode;
    
    @Column(name = "item")
    private String itemName;
    
    @Column(name = "category")
    private String itemCategory;
    
    @Column(name = "price")
    private Float itemPrice;
    
    @Column(name = "discount")
    private Integer itemDiscount;
    
    @Column(name = "available")
    private Boolean itemAvailablity;
    
    /**
     * @return The item's barcode.
     */
    public String getItemBarcode() {
        return itemBarcode;
    }
    
    /**
     * @return The item's name.
     */
    public String getItemName() {
        return itemName;
    }
    
    /**
     * @return The item's category.
     */
    public String getItemCategory() {
        return itemCategory;
    }
    
    /**
     * @return The item's price before any discounts.
     */
    public Float getItemPrice() {
        return itemPrice;
    }
    
    /**
     * @return The percent discount to apply to the item.
     */
    public Integer getItemDiscount() {
        return itemDiscount;
    }
    
    /**
     * @return true if the item is available, false if it is not.
     */
    public Boolean getItemAvailability() {
        return itemAvailablity;
    }
}
