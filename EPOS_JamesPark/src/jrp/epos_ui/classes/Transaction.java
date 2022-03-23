package jrp.epos_ui.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static jrp.epos_ui.db_handler.Transactions_DB_Handler.getNextTransactionID;
import static jrp.epos_ui.db_handler.Transactions_DB_Handler.saveSuccessfullTransaction;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class Transaction {

    private String transaction_id;
    private ArrayList<TransactionItem> items = new ArrayList<TransactionItem>();
    private double total = 0.00;
    private String date;
    private String employee_id;

//===========================GETTERS AND SETTERS================================
    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public ArrayList<TransactionItem> getItems() {
        return items;
    }

    public void setProducts(ArrayList<TransactionItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date unformattedDate = new Date();
        this.date = formatter.format(unformattedDate);
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
//==============================================================================
    
//===========================CLASS==============================================
    public Transaction() {
        this.transaction_id = getNextTransactionID();
        setDate();
    }

    public Transaction(String employee_id) {
        this.transaction_id = getNextTransactionID();
        setDate();
        this.employee_id = employee_id;
    }

    public Transaction(String transaction_id, ArrayList<TransactionItem> items, Double total, String date, String employee_id) {
        this.transaction_id = getNextTransactionID();
        this.items = items;
        this.total = total;
        this.date = date;
        this.employee_id = employee_id;
    }
//==============================================================================
    
//==========================METHODS=============================================
    public void addItem(TransactionItem item) {

        items.add(item);
    }

    public void calculateTotal() {
        total = 0.00;
        items.forEach(item -> {
            total += item.getSubtotal();
        });
    }

    public void checkID() {
        String id = getNextTransactionID();
        setTransaction_id(id);
    }
    
    public static boolean saveTransaction(Transaction transaction){
        return saveSuccessfullTransaction(transaction);
    }
//==============================================================================
}
