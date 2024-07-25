/**
 * Author: Akmal Hameed
 * Date: 07/23/24

 * Description: This parent class representing a product in the store with properties
 * such as SKU, name, unit cost, sale price, quantity on hand,
 * quantity needed, and special instructions.

 * References: https://www.digitalocean.com/community/tutorials/inheritance-java-example
 * https://www.programiz.com/java-programming/inheritance
 * https://www.w3schools.com/java/java_inheritance.asp
 *
 */

import java.util.Objects;

public class Product {
    protected String sku;
    protected String name;
    protected double unitCost;
    protected double salePrice;
    protected int quantityOnHand;
    protected int quantityNeeded;
    protected String specialInstructions;

    public Product() {
        this.sku = "";
        this.name = "";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantityOnHand = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "";
    }
// Parameterized constructor
    public Product(String sku, String name, double unitCost, double salePrice,
                   int quantityOnHand, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setName(name);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantityOnHand(quantityOnHand);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    // Getters and setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if (sku.length() >= 8){this.sku = sku;
        }else{
        throw new IllegalArgumentException("SKU must be at least 8 digits.");}

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be blank.");
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        if (unitCost < 0)
            throw new IllegalArgumentException("Unit cost cannot be negative.");
        this.unitCost = unitCost;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        if (salePrice < 0)
            throw new IllegalArgumentException("Sale price cannot be negative.");
        this.salePrice = salePrice;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand < 0)
            throw new IllegalArgumentException("Quantity on hand cannot be negative.");
        this.quantityOnHand = quantityOnHand;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded < 0)
            throw new IllegalArgumentException("Quantity needed cannot be negative.");
        this.quantityNeeded = quantityNeeded;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String toString() {
        return "SKU: " + sku + "\n" +
                "Product Name: " + name + "\n" +
                "Unit Cost: $" + unitCost + "\n" +
                "Sale Price: $" + salePrice + "\n" +
                "Quantity on hand: " + quantityOnHand + "\n" +
                "Quantity Needed: " + quantityNeeded + "\n" +
                "Special Instructions: " + specialInstructions;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    public int hashCode() {
        return Objects.hash(sku);
    }
}
