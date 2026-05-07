-- Run this script in MySQL to set up the database

CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;

CREATE TABLE IF NOT EXISTS Item (
    item_id            INT PRIMARY KEY,
    item_name          VARCHAR(50)    NOT NULL,
    unit_price         DECIMAL(10,2)  NOT NULL,
    reorder_level      INT            NOT NULL,
    available_quantity INT            NOT NULL,
    category           VARCHAR(20)    NOT NULL
);

CREATE TABLE IF NOT EXISTS Supplier (
    supplier_id   INT PRIMARY KEY,
    supplier_name VARCHAR(50) NOT NULL,
    phone         VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer (
    customer_id   INT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    phone         VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS Purchase (
    purchase_id   INT PRIMARY KEY,
    quantity      INT           NOT NULL,
    item_id       INT           NOT NULL,
    supplier_id   INT           NOT NULL,
    cost_price    DECIMAL(10,2) NOT NULL,
    purchase_date DATE          NOT NULL,
    FOREIGN KEY (item_id)     REFERENCES Item(item_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

CREATE TABLE IF NOT EXISTS Sales (
    sale_id       INT PRIMARY KEY,
    total_price   DECIMAL(10,2),
    item_id       INT  NOT NULL,
    customer_id   INT  NOT NULL,
    sale_date     DATE NOT NULL,
    quantity_sold INT  NOT NULL,
    FOREIGN KEY (item_id)     REFERENCES Item(item_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- Admin table for login (was missing from original schema)
CREATE TABLE IF NOT EXISTS admin (
    admin_id  INT PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    password  VARCHAR(50) NOT NULL
);

-- ============================================================
-- TEST DATA
-- ============================================================

INSERT IGNORE INTO admin VALUES (1, 'admin', 'admin123');

INSERT IGNORE INTO Item VALUES
(1, 'Coffee Beans',  1500.00, 10, 50, 'Beverage'),
(2, 'Sugar',          200.00,  5, 30, 'Ingredient'),
(3, 'Milk',           180.00,  8, 20, 'Dairy'),
(4, 'Tea Bags',       350.00,  5, 15, 'Beverage'),
(5, 'Disposable Cups', 500.00, 10,  8, 'Supplies');

INSERT IGNORE INTO Supplier VALUES
(1, 'Ali Traders',   '03001234567'),
(2, 'Fresh Farm Co', '03119876543');

INSERT IGNORE INTO Customer VALUES
(1, 'Ahmed Khan',  '03331234567'),
(2, 'Sara Malik',  '03219876543'),
(3, 'Usman Raza',  '03451230000');
