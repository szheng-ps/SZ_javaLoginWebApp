package entity;

import core.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.sql.Statement;

public class ProductDAO2 implements DAO<Product> {

    public ProductDAO2() {

    }
    List<Product> products;

    /**
     * Get a single product entity as a product object
     * @param product_id
     * @return
     */
    @Override
    public Optional<Product> get(int product_id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM HD_Product2 WHERE Product_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, product_id);
            rs = stmt.executeQuery();
            Product product = null;
            while (rs.next()) {
                product = new Product(rs.getInt("Product_ID"), rs.getString("Product_Name"), rs.getString("Product_Description"), rs.getString("Product_Color"), rs.getDouble("Product_Size"), rs.getDouble("Product_Price"));
            }
            return Optional.ofNullable(product);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return Optional.empty();
        }
    }

    /**
     * Get all product entities as a List
     * @return
     */
    @Override
    public List<Product> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HD_Product2";
            rs = db.executeQuery(sql);
            Product product = null;
            while (rs.next()) {
                product = new Product(rs.getInt("Product_ID"), rs.getString("Product_Name"), rs.getString("Product_Description"), rs.getString("Product_Color"), rs.getDouble("Product_Size"), rs.getDouble("Product_Price"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return Collections.emptyList();
        }
    }

    /**
     * Insert a product object into product table
     * @param product
     */
    @Override
    public void insert(Product product)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO HD_Product2(Product_Name, Product_Description, Product_Color, Product_Size, Product_Price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getProduct_name());
            stmt.setString(2, product.getProduct_description());
            stmt.setString(3, product.getProduct_color());
            stmt.setDouble(4, product.getProduct_size());
            stmt.setDouble(5, product.getProduct_price());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    product.setProduct_id(rs.getInt(1));
                }
                System.out.println("A new product was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Update a product entity in database if it exists using a product object
     * @param product
     */
    @Override
    public void update(Product product) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE HD_Product2 SET Product_Name=?, Product_Description=?, Product_Color=?, Product_Size=?, Product_Price=? WHERE Product_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, product.getProduct_name());
            stmt.setString(2, product.getProduct_description());
            stmt.setString(3, product.getProduct_color());
            stmt.setDouble(4, product.getProduct_size());
            stmt.setDouble(5, product.getProduct_price());
            stmt.setInt(6, product.getProduct_id());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing product was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Delete a product from product table if the entity exists
     * @param product
     */
    @Override
    public void delete(Product product) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM HD_Product2 WHERE Product_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, product.getProduct_id());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A product was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Get all column names in a list array
     * @return
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HD_Product2 WHERE Product_ID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
}

