package model;

public class Supplier extends Person {

    private int supplierId;

    public Supplier(int supplierId, String name, String phone) {
        super(name, phone);
        this.supplierId = supplierId;
    }

    public int getSupplierId() {
        return supplierId;
    }
}