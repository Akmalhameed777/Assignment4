/**
 * Author: Akmal Hameed
 * Date: 07/25/24

 * Description: This is the main program file that handles user interaction and menu-driven operations.
 * It allows the creation, editing, deletion, and display of products, including perishable products.

 * References: https://www.digitalocean.com/community/tutorials/inheritance-java-example
 * https://www.programiz.com/java-programming/inheritance
 * https://www.w3schools.com/java/java_inheritance.asp
 *
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    protected static List<Product> productList = new ArrayList<>(); // List to store products

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // Flag to control the loop

        while (running) {
            // Display menu options
            System.out.println("1) Create Product");
            System.out.println("2) Create Perishable Product");
            System.out.println("3) Edit Product by SKU");
            System.out.println("4) Delete Product by SKU");
            System.out.println("5) Display Product by SKU");
            System.out.println("6) Display all Products");
            System.out.println("7) Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Process menu choice
            if (choice == 1) {
                createProduct(scanner);
            } else if (choice == 2) {
                createPerishableProduct(scanner);
            } else if (choice == 3) {
                editProduct(scanner);
            } else if (choice == 4) {
                deleteProduct(scanner);
            } else if (choice == 5) {
                displayProduct(scanner);
            } else if (choice == 6) {
                displayAllProducts();
            } else if (choice == 7) {
                running = false; // Exit the loop
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); // Close scanner
    }

    protected static void createProduct(Scanner scanner) {
        try {
            // Gather product details from user
            System.out.print("Enter SKU: ");
            String sku = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Unit Cost: ");
            double unitCost = scanner.nextDouble();
            System.out.print("Enter Sale Price: ");
            double salePrice = scanner.nextDouble();
            System.out.print("Enter Quantity on Hand: ");
            int quantityOnHand = scanner.nextInt();
            System.out.print("Enter Quantity Needed: ");
            int quantityNeeded = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Special Instructions: ");
            String specialInstructions = scanner.nextLine();

            // Create and add product to the list
            Product product = new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
            productList.add(product);
            System.out.println("Product created successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
            scanner.next(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected static void createPerishableProduct(Scanner scanner) {
        try {
            // Gather perishable product details from user
            System.out.print("Enter SKU: ");
            String sku = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Unit Cost: ");
            double unitCost = scanner.nextDouble();
            System.out.print("Enter Sale Price: ");
            double salePrice = scanner.nextDouble();
            System.out.print("Enter Quantity on Hand: ");
            int quantityOnHand = scanner.nextInt();
            System.out.print("Enter Quantity Needed: ");
            int quantityNeeded = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Special Instructions: ");
            String specialInstructions = scanner.nextLine();
            System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
            String expiryDateString = scanner.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date expiryDate = dateFormat.parse(expiryDateString);

            // Create and add perishable product to the list
            PerishableProduct perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions, expiryDate);
            productList.add(perishableProduct);
            System.out.println("Perishable product created successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
            scanner.next(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
    }

    protected static void editProduct(Scanner scanner) {
        try {
            System.out.print("Enter SKU of the product to edit: ");
            String sku = scanner.nextLine();
            Product product = findProductBySku(sku);

            if (product == null) {
                System.out.println("Product not found.");
                return;
            }

            // Gather new details for the product
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Unit Cost: ");
            double unitCost = scanner.nextDouble();
            System.out.print("Enter new Sale Price: ");
            double salePrice = scanner.nextDouble();
            System.out.print("Enter new Quantity on Hand: ");
            int quantityOnHand = scanner.nextInt();
            System.out.print("Enter new Quantity Needed: ");
            int quantityNeeded = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Special Instructions: ");
            String specialInstructions = scanner.nextLine();

            // Update product details
            product.setName(name);
            product.setUnitCost(unitCost);
            product.setSalePrice(salePrice);
            product.setQuantityOnHand(quantityOnHand);
            product.setQuantityNeeded(quantityNeeded);
            product.setSpecialInstructions(specialInstructions);
            System.out.println("Product updated successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
            scanner.next(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected static void deleteProduct(Scanner scanner) {
        System.out.print("Enter SKU of the product to delete: ");
        String sku = scanner.nextLine();
        Product product = findProductBySku(sku);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        productList.remove(product);
        System.out.println("Product deleted successfully!");
    }

    protected static void displayProduct(Scanner scanner) {
        System.out.print("Enter SKU of the product to display: ");
        String sku = scanner.nextLine();
        Product product = findProductBySku(sku);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println(product);
    }

    protected static void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : productList) {
            System.out.println(product);
            System.out.println("-------------------------------");
        }
    }

    protected static Product findProductBySku(String sku) {
        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                return product;
            }
        }
        return null;
    }
}
