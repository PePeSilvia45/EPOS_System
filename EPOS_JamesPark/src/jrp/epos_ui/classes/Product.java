package jrp.epos_ui.classes;

import java.util.ArrayList;

import static jrp.epos_ui.db_handler.Products_DB_Handler.getAllSearchResults;
import static jrp.epos_ui.db_handler.Products_DB_Handler.getPopularProducts;
import static jrp.epos_ui.db_handler.Products_DB_Handler.getValidProduct;
import static jrp.epos_ui.db_handler.Products_DB_Handler.isProductValid;
import static jrp.epos_ui.db_handler.Products_DB_Handler.tallyProductSales;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class Product {

    private String product_id;
    private String product_name;
    private double product_cost;
    private String catagory_id;
    private String product_image;
    private int product_amount_sold;

//========================GETTERS AND SETTERS===================================
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Double product_cost) {
        this.product_cost = product_cost;
    }

    public String getCatagory_id() {
        return catagory_id;
    }

    public void setCatagory_id(String catagory_id) {
        this.catagory_id = catagory_id;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public int getProduct_amount_sold() {
        return product_amount_sold;
    }

    public void setProduct_amount_sold(int product_amount_sold) {
        this.product_amount_sold = product_amount_sold;
    }
//==============================================================================

//=============================CLASS============================================    
    public Product() {

    }

    public Product(String product_id) {
        this.product_id = product_id;
    }

    public Product(String product_id, String product_name, double product_cost) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cost = product_cost;
    }

    public Product(String product_id, String product_name, double product_cost,
            String catagory_id, String product_image, int product_amount_sold) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.catagory_id = catagory_id;
        this.product_image = product_image;
        this.product_amount_sold = product_amount_sold;
    }
//==============================================================================
    
//=============================METHOD===========================================
    public static ArrayList<Product> getPopular(String id){
        return getPopularProducts(id);
    }
    
    public static boolean isValid(Product product){
        return isProductValid(product);
    }
    
    public static Product getValid(Product product){
        return getValidProduct(product);
    }
    
    public void addExtra(Product extra) {

        product_cost += extra.getProduct_cost();

    }

    public static ArrayList<Product> searchFor(String search){
         return getAllSearchResults(search);
    }
    
    public static void tallySales(){
        tallyProductSales();
    }
//==============================================================================
}
