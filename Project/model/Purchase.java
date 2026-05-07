package model;

import java.time.LocalDate;

public class Purchase {

    private int purchaseId;
    private int itemId;
    private int supplierId;
    private int quantity;
    private double costPrice;
    private LocalDate date;

    // Constructor used by MainMenu: (purchaseId, itemId, supplierId, quantity, costPrice)
    public Purchase(int purchaseId, int itemId, int supplierId, int quantity, double costPrice) {
        this.purchaseId = purchaseId;
        this.itemId = itemId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.date = LocalDate.now();
    }

    public int getPurchaseId() { return purchaseId; }
    public int getItemId()     { return itemId; }
    public int getSupplierId() { return supplierId; }
    public int getQuantity()   { return quantity; }
    public double getCostPrice(){ return costPrice; }
    public LocalDate getDate() { return date; }
}
