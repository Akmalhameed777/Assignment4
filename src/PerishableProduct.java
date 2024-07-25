/**
 * Author: Akmal Hameed
 * Date: 07/24/24

 * Description: This child class representing a perishable product in a retail store.
 * It extends the Product class and includes an additional property for the expiry date.

 * References: https://www.digitalocean.com/community/tutorials/inheritance-java-example
 * https://www.programiz.com/java-programming/inheritance
 * https://www.w3schools.com/java/java_inheritance.asp
 *
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class PerishableProduct extends Product {
    private Date expiryDate;

    public PerishableProduct() {
        super();
        this.expiryDate = new Date();
    }

    public PerishableProduct(String sku, String name, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions, Date expiryDate) {
        super(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return super.toString() + "\n" +
                "Expiry Date: " + dateFormat.format(expiryDate);
    }
}
