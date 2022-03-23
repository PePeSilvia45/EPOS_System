package jrp.epos_ui.db_handler;

/**
 * @author James Park
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import jrp.epos_ui.classes.Transaction;
import jrp.epos_ui.classes.TransactionItem;
import static jrp.epos_ui.db_handler.DB_Handler.getConnection;

public class Transactions_DB_Handler {

    public static String getNextTransactionID() {
        //gets the id the next transaction dhould be.
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getID = stmt.executeQuery(
                    "SELECT transaction_id FROM transactions"
            );

            int id = 0;
            while (getID.next()) {
                id = getID.getInt("transaction_id");
            }
            return String.format("%03d", id + 1);
        } catch (SQLException e) {
            System.err.println("getNextTransactionID : error");
            System.err.println("SQL Exception occured " + e);
        }
        return null;
    }

    public static boolean saveSuccessfullTransaction(Transaction transaction) {
        //saves the transaction to the database
        //returns true if transaction is successfull and false if not
        String transaction_id = transaction.getTransaction_id();
        String transactionDate = transaction.getDate();
        double total = transaction.getTotal();
        String employee_id = transaction.getEmployee_id();
        
        String saveTransaction = "INSERT INTO transactions (transaction_id, transaction_date, transaction_total, employee_id) "
                + "VALUES "
                + "('" + transaction_id + "', ?, '" + total + "', '" + employee_id + "')";
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(saveTransaction);
            pstmt.setDate(1, java.sql.Date.valueOf(transactionDate));
            pstmt.executeUpdate();
            recordItemsBought(transaction);
            return true;

        } catch (SQLException e) {
            System.err.println("saveSuccessfullTransaction : error");
            System.err.println("SQLException occured " + e);
            return false;
        }
    }

    public static void recordItemsBought(Transaction transaction) {
        //records the items bought and the amount in the database
        ArrayList<TransactionItem> items = transaction.getItems();
        String transaction_id = transaction.getTransaction_id();

        items.forEach(item -> {
            String product_id = item.getProduct().getProduct_id();
            int amount = item.getAmount();

            try {
                Connection con = getConnection();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(
                        "INSERT INTO transactions_products "
                        + "(transaction_id, product_id, product_amount)"
                        + " VALUES "
                        + "('" + transaction_id + "', '" + product_id + "', " + amount + ")"
                );

            } catch (SQLException e) {
                System.err.println("recordItemsBought : error");
                System.err.println("SQL Exception occured " + e);
            }
        });
    }

    public static int getAmountOfSalesForEmployee(String employee_id) {
        //gets the amount of sales an employee has made.
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet count = stmt.executeQuery(
                    "SELECT COUNT (transaction_id) AS transactionCount "
                    + " FROM transactions "
                    + "WHERE employee_id = '" + employee_id + "'"
            );
            if (count.next()) {
                return count.getInt("transactionCount");
            }
            return -1;

        } catch (SQLException e) {
            System.err.println("getTotal : error");
            System.err.println("SQL Exception occured " + e);
            return -1;
        }
    }

    public static double getSumOfSalesForEmployee(String employee_id) {
        //gets the sum of all sales made by an employee
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet sum = stmt.executeQuery(
                    "SELECT SUM(transaction_total) AS transactionSum "
                    + "FROM transactions "
                    + "WHERE employee_id = '" + employee_id + "'"
            );
            if (sum.next()) {
                return sum.getDouble("transactionSum");
            }
            return -1.00;

        } catch (SQLException e) {
            System.err.println("getAvarageSale : error");
            System.err.println("SQL Exception occured " + e);
            return -1.00;
        }
    }

    public static double avarageSaleForEmployee(String employee_id) {
        //gets the avarage sale the employee has made
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet avg = stmt.executeQuery(
                    "SELECT AVG(transaction_total) AS avg_total "
                    + "FROM transactions "
                    + "WHERE employee_id = '" + employee_id + "'"
            );
            if (avg.next()) {
                return avg.getDouble("avg_total");
            }
            return -1.00;

        } catch (SQLException e) {
            System.err.println("avarageSaleForEmployee : error");
            System.err.println("SQL Exception occured " + e);
            return -1.00;
        }
    }

    public static double minSaleForEmployee(String employee_id) {
        //gets the minnimum sale an employee has made
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet min = stmt.executeQuery(
                    "SELECT transaction_total AS min"
                    + " FROM transactions "
                    + "WHERE employee_id = '" + employee_id + "' "
                    + "ORDER BY transaction_total ASC"
            );
            if (min.next()) {
                return min.getDouble("min");
            }
            return 0.00;

        } catch (SQLException e) {
            System.err.println("minSale : error");
            System.err.println("SQL Exception occured " + e);
            return 0.00;
        }
    }

    public static double maxSaleForEmployee(String employee_id) {
        //gets the maximum sale an employee has made.
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet max = stmt.executeQuery(
                    "SELECT transaction_total AS max "
                    + "FROM transactions "
                    + "WHERE employee_id = '" + employee_id + "' "
                    + "ORDER BY transaction_total DESC"
            );
            if (max.next()) {
                return max.getDouble("max");
            }
            return 0.00;
        } catch (SQLException e) {
            System.err.println("maxSale : error");
            System.err.println("SQL Exception occured " + e);
            return 0.00;
        }
    }
}
