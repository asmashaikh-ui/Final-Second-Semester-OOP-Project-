package model;

public class Customer extends Person {

    private int customerId;

    public Customer(int customerId, String name, String phone) {
        super(name, phone);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}