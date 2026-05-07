package model;

public class Item {

    private int itemId;
    private String itemName;
    private double unitPrice; 
    private int reorderLevel;
    private int availableQuantity;
    private String category;

    public Item(int itemId, String itemName, double unitPrice,
                int reorderLevel, int availableQuantity, String category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.reorderLevel = reorderLevel;
        this.availableQuantity = availableQuantity;
        this.category = category;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getUnitPrice() { return unitPrice; }
    public int getReorderLevel() { return reorderLevel; }
    public int getAvailableQuantity() { return availableQuantity; }
    public String getCategory() { return category; }
} 