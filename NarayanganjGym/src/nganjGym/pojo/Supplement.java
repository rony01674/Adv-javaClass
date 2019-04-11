package nganjGym.pojo;

/**
 *
 * @author User
 */
public class Supplement {

    private String itemID;
    private String itemName;
    private double unitPrice;
    private Inventory itemStockId;

    public Supplement() {
    }

    public Supplement(String itemID, String itemName, double unitPrice, Inventory itemStockId) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.itemStockId = itemStockId;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Inventory getItemStockId() {
        return itemStockId;
    }

    public void setItemStockId(Inventory itemStockId) {
        this.itemStockId = itemStockId;
    }

}
