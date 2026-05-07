package ui;

import java.util.Scanner;
import java.sql.Connection;
import java.time.LocalDate;

import model.*;
import service.*;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();

        // LOGIN
        LoginService loginService = new LoginService(con);

        System.out.println("===== LOGIN SYSTEM =====");

        System.out.print("Enter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        boolean login = loginService.login(username, password);

        if (!login) {
            System.out.println("Invalid login!");
            return;
        }

        System.out.println("\nLogin Successful!\n");

        // SERVICES
        InventoryOperations<Item>     itemService     = new ItemService(con);
        InventoryOperations<Supplier> supplierService = new SupplierService(con);
        InventoryOperations<Customer> customerService = new CustomerService(con);

        PurchaseService   purchaseService  = new PurchaseService(con);
        SaleService       saleService      = new SaleService(con);
        DashboardService  dashboardService = new DashboardService(con);

        int choice;

        do {
            System.out.println("\n===== CAFE INVENTORY SYSTEM =====");
            System.out.println("1. Item Operations");
            System.out.println("2. Supplier Operations");
            System.out.println("3. Customer Operations");
            System.out.println("4. Purchase Operations");
            System.out.println("5. Sale Operations");
            System.out.println("6. Dashboard");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // ITEM
                case 1:
                    int itemChoice;
                    do {
                        System.out.println("\n--- ITEM MENU ---");
                        System.out.println("1. Add Item");
                        System.out.println("2. View Items");
                        System.out.println("3. Update Item");
                        System.out.println("4. Delete Item");
                        System.out.println("5. Back");

                        itemChoice = sc.nextInt();

                        switch (itemChoice) {

                            case 1:
                                System.out.print("ID: ");
                                int id = sc.nextInt();
                                System.out.print("Name: ");
                                String name = sc.next();
                                System.out.print("Price: ");
                                double price = sc.nextDouble();
                                System.out.print("Reorder Level: ");
                                int rl = sc.nextInt();
                                System.out.print("Qty: ");
                                int qty = sc.nextInt();
                                System.out.print("Category: ");
                                String cat = sc.next();

                                itemService.add(new Item(id, name, price, rl, qty, cat));
                                break;

                            case 2:
                                itemService.view();
                                break;

                            case 3:
                                System.out.print("ID: ");
                                int uid = sc.nextInt();
                                System.out.print("New Price: ");
                                double np = sc.nextDouble();
                                System.out.print("New Qty: ");
                                int nq = sc.nextInt();

                                itemService.update(uid, new Item(uid, "", np, 0, nq, ""));
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int did = sc.nextInt();
                                itemService.delete(did);
                                break;
                        }

                    } while (itemChoice != 5);
                    break;

                // SUPPLIER
                case 2:
                    int supChoice;
                    do {
                        System.out.println("\n--- SUPPLIER MENU ---");
                        System.out.println("1. Add Supplier");
                        System.out.println("2. View Suppliers");
                        System.out.println("3. Update Supplier");
                        System.out.println("4. Delete Supplier");
                        System.out.println("5. Back");

                        supChoice = sc.nextInt();

                        switch (supChoice) {

                            case 1:
                                System.out.print("ID: ");
                                int sid = sc.nextInt();
                                System.out.print("Name: ");
                                String sn = sc.next();
                                System.out.print("Phone: ");
                                String sp = sc.next();

                                supplierService.add(new Supplier(sid, sn, sp));
                                break;

                            case 2:
                                supplierService.view();
                                break;

                            case 3:
                                System.out.print("ID: ");
                                int usid = sc.nextInt();
                                System.out.print("Name: ");
                                String nsn = sc.next();
                                System.out.print("Phone: ");
                                String nsp = sc.next();

                                supplierService.update(usid, new Supplier(usid, nsn, nsp));
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int dsid = sc.nextInt();
                                supplierService.delete(dsid);
                                break;
                        }

                    } while (supChoice != 5);
                    break;

                // CUSTOMER
                case 3:
                    int custChoice;
                    do {
                        System.out.println("\n--- CUSTOMER MENU ---");
                        System.out.println("1. Add Customer");
                        System.out.println("2. View Customers");
                        System.out.println("3. Update Customer");
                        System.out.println("4. Delete Customer");
                        System.out.println("5. Back");

                        custChoice = sc.nextInt();

                        switch (custChoice) {

                            case 1:
                                System.out.print("ID: ");
                                int cid = sc.nextInt();
                                System.out.print("Name: ");
                                String cn = sc.next();
                                System.out.print("Phone: ");
                                String cp = sc.next();

                                customerService.add(new Customer(cid, cn, cp));
                                break;

                            case 2:
                                customerService.view();
                                break;

                            case 3:
                                System.out.print("ID: ");
                                int uc = sc.nextInt();
                                System.out.print("Name: ");
                                String ncn = sc.next();
                                System.out.print("Phone: ");
                                String ncp = sc.next();

                                customerService.update(uc, new Customer(uc, ncn, ncp));
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int dc = sc.nextInt();
                                customerService.delete(dc);
                                break;
                        }

                    } while (custChoice != 5);
                    break;

                // PURCHASE
                case 4:
                    int purchaseChoice;
                    do {
                        System.out.println("\n--- PURCHASE MENU ---");
                        System.out.println("1. Add Purchase");
                        System.out.println("2. View Purchases");
                        System.out.println("3. Back");

                        purchaseChoice = sc.nextInt();

                        switch (purchaseChoice) {

                            case 1:
                                System.out.println("Enter Purchase Details");
                                System.out.print("Purchase ID: ");
                                int pid = sc.nextInt();
                                System.out.print("Item ID: ");
                                int itemId = sc.nextInt();
                                System.out.print("Supplier ID: ");
                                int supId = sc.nextInt();
                                System.out.print("Quantity: ");
                                int pq = sc.nextInt();
                                System.out.print("Cost Price: ");
                                double cp2 = sc.nextDouble();

                                // Fixed: constructor is (purchaseId, itemId, supplierId, quantity, costPrice)
                                purchaseService.addPurchase(new Purchase(pid, itemId, supId, pq, cp2));
                                break;

                            case 2:
                                purchaseService.viewPurchases();
                                break;
                        }

                    } while (purchaseChoice != 3);
                    break;

                // SALE
                case 5:
                    int saleChoice;
                    do {
                        System.out.println("\n--- SALE MENU ---");
                        System.out.println("1. Add Sale");
                        System.out.println("2. View Sales");
                        System.out.println("3. Back");

                        saleChoice = sc.nextInt();

                        switch (saleChoice) {

                            case 1:
                                System.out.println("Enter Sale Details");
                                System.out.print("Sale ID: ");
                                int saleId = sc.nextInt();
                                System.out.print("Item ID: ");
                                int si = sc.nextInt();
                                System.out.print("Customer ID: ");
                                int scid = sc.nextInt();
                                System.out.print("Quantity Sold: ");
                                int sq = sc.nextInt();
                                System.out.print("Total Price: ");
                                double stb = sc.nextDouble();

                                // Fixed: class is "Sales" not "Sale"; uses LocalDate.now() for date
                                saleService.addSale(new Sales(saleId, stb, si, scid, LocalDate.now(), sq));
                                break;

                            case 2:
                                saleService.viewSales();
                                break;
                        }

                    } while (saleChoice != 3);
                    break;

                // DASHBOARD
                case 6:
                    dashboardService.showDashboard();
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
        System.out.println("System Closed");
    }
}
