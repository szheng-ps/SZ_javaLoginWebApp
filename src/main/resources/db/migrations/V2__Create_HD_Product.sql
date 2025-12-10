CREATE TABLE HD_Product(
    Product_ID int NOT NULL PRIMARY KEY,
    Product_Name VARCHAR(50) NOT NULL,
    Product_Description VARCHAR(200) NOT NULL,
    Product_Color VARCHAR(20) NOT NULL,
    Product_Size DOUBLE NOT NULL,
    Product_Price DOUBLE NOT NULL
);