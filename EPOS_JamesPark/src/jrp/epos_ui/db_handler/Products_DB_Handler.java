package jrp.epos_ui.db_handler;

/**
 * @author James Park
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jrp.epos_ui.classes.Product;
import static jrp.epos_ui.db_handler.DB_Handler.getConnection;

public class Products_DB_Handler {

    public static boolean isProductValid(Product product) {
        //checks if the product being looked at is valid and exists in the database.
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getProduct = stmt.executeQuery(
                    "SELECT * FROM products "
                    + "WHERE "
                    + "product_id = " + product.getProduct_id()
            );

            while (getProduct.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.err.println("isProductValid : error");
            System.err.println("SQLException occured " + e);
            return false;
        }
        return false;
    }

    public static Product getValidProduct(Product product) {
        //used with the check to get the valid product information from the database
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getProduct = stmt.executeQuery(
                    "SELECT * FROM products "
                    + "WHERE "
                    + "product_id = " + product.getProduct_id()
            );

            getProduct.next();

            Product validProduct = new Product(
                    String.format("%03d", getProduct.getInt("product_id")),
                    getProduct.getString("product_name"),
                    getProduct.getDouble("product_cost"),
                    String.format("%03d", getProduct.getInt("catagory_id")),
                    getProduct.getString("product_image"),
                    getProduct.getInt("product_amount_sold")
            );

            return validProduct;

        } catch (SQLException e) {
            System.err.println("getValidProduct : error");
            System.err.println("SQLException occured " + e);
        }

        return null;
    }

    public static void tallyProductSales() {
        //tally up how many of each product has been sold
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet product = stmt.executeQuery(
                    "SELECT product_id FROM products"
            );
            while (product.next()) {
                ResultSet amountOfProductsSold = stmt.executeQuery(
                        "SELECT SUM(product_amount) AS sumAmount FROM transactions_products "
                        + "WHERE product_id = '" + product.getString("product_id") + "'"
                );
                if (amountOfProductsSold.next()) {

                    stmt.executeUpdate(
                            "UPDATE products "
                            + "SET product_amount_sold  = " + amountOfProductsSold.getInt("sumAmount")
                            + " WHERE product_id = '" + product.getString("product_id") + "'"
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("tallyProductSales : error");
            System.err.println("SQL Exception occured " + e);
        }

    }

    public static ArrayList<Product> getPopularProducts(String catagory_id) {
        //gets the 9 most popular products of the given catagory
        
        ArrayList<Product> popularProducts = new ArrayList<Product>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getProduct = stmt.executeQuery(
                    "SELECT * FROM products "
                    + "WHERE "
                    + "catagory_id = " + catagory_id
                    + " ORDER BY product_amount_sold DESC "
                    + "LIMIT 9"
            );

            while (getProduct.next()) {
                Product product = new Product(
                        String.format("%03d", getProduct.getInt("product_id")),
                        getProduct.getString("product_name"),
                        getProduct.getDouble("product_cost"),
                        String.format("%03d", getProduct.getInt("catagory_id")),
                        getProduct.getString("product_image"),
                        getProduct.getInt("product_amount_sold")
                );
                popularProducts.add(product);
            }
        } catch (SQLException e) {
            System.err.println("getPopularProducts : error");
            System.err.println("SQL Exception occured " + e);
        }
        return popularProducts;
    }

    public static ArrayList<Product> getAllSearchResults(String searchFor) {
        //gets all the results of the search entered
        
        ArrayList<Product> searchResults = new ArrayList<Product>();

        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getProduct = stmt.executeQuery(
                    "SELECT product_id, product_name, product_cost FROM products"
                    + " WHERE "
                    + "product_name LIKE '%" + searchFor + "%'"
            );
            while (getProduct.next()) {
                Product product = new Product(
                        String.format("%03d", getProduct.getInt("product_id")),
                        getProduct.getString("product_name"),
                        getProduct.getDouble("product_cost")
                );
                searchResults.add(product);
            }
        } catch (SQLException e) {
            System.err.println("getAllSearchResults : error");
            System.err.println("SQLException occured " + e);
        }

        return searchResults;
    }

    public static String getProductIdFromName(String product_name) {
        //get the product id from the given product name
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getProductID = stmt.executeQuery(
                    "SELECT * FROM products "
                    + "WHERE "
                    + "product_name = '" + product_name + "'"
            );

            getProductID.next();

            return String.format("%03d", getProductID.getInt("product_id"));

        } catch (SQLException e) {
            System.err.println("getProductIdFromName : error");
            System.err.println("SQL Exception occured " + e);
        }

        return null;
    }
}
