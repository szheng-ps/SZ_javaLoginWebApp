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

    public void setName(String product_name) {
        this.product_name = product_name;
    }

    public void setDescription(String product_description) {
        this.product_description = product_description;
    }

    public void setColor(String product_color) {
        this.product_color = product_color;
    }

    public void setSize(double product_size) {
        this.product_size = product_size;
    }

    public void setPrice(double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Customer{" + "PID=" + product_id + ", Name=" + product_name + ", Description=" + product_description + ", Color=" + product_color + ", Size=" + product_size + ", Price=" + product_price + '}';
    }

}
