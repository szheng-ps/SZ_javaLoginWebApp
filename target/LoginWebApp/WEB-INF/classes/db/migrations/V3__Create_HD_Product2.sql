CREATE TABLE HD_Product2(
    Product_ID int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Product_Name VARCHAR(50) NOT NULL,
    Product_Description VARCHAR(100) NOT NULL,
    Product_Color VARCHAR(20) NOT NULL,
    Product_Size DOUBLE NOT NULL,
    Product_Price DOUBLE NOT NULL
);