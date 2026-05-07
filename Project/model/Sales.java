package model;

import java.time.LocalDate;

public class Sales {

    private int saleId;
    private double totalPrice;
    private int itemId;
    private int customerId;
    private LocalDate saleDate;
    private int quantitySold;

    public Sales(int saleId, double totalPrice, int itemId, int customerId, LocalDate saleDate, int quantitySold) {
        this.saleId = saleId;
        this.totalPrice = totalPrice;
        this.itemId = itemId;
        this.customerId = customerId;
        this.saleDate = saleDate;
        this.quantitySold = quantitySold;
    }

    public int getSaleId() {
        return saleId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public int getQuantitySold() {
        return quantitySold;
    }
}