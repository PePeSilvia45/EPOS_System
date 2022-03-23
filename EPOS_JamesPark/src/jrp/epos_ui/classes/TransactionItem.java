package jrp.epos_ui.classes;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class TransactionItem {

    private Product product;
    private int amount;
    private double subtotal;

//============================GETTERS AND SETTERS===============================
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSubtotal() {
        this.subtotal = product.getProduct_cost() * amount;
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
//==============================================================================

//===============================CLASS=========================================
    public TransactionItem() {

    }

    public TransactionItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
//==============================================================================
}
