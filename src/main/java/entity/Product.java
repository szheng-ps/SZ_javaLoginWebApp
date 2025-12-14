package entity;

public class Product {

    private int product_id;
    private String product_name;
    private String product_description;
    private String product_color;
    private double product_size;
    private double product_price;

    public Product(int product_id, String product_name, String product_description, String product_color, double product_size, double product_price)
    {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_color = product_color;
        this.product_size = product_size;
        this.product_price = product_price;
    }

    public Product()
    {

    }

    // Setters and getters
    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String getProduct_color() {
        return product_color;
    }

    public double getProduct_size() {
        return product_size;
    }
    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public void setProduct_size(double product_size) {
        this.product_size = product_size;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_name=" + product_name + ", product_description=" + product_description + ", product_color=" + product_color + ", product_size=" + product_size + ", product_price=" + product_price + '}';
    }

}