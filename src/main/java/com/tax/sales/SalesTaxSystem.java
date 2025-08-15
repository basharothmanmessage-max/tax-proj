
package com.tax.sales;

import com.tax.sales.helper.Receipt;
import com.tax.sales.model.Book;
import com.tax.sales.model.Food;
import com.tax.sales.model.GeneralProduct;
import com.tax.sales.model.MedicalProduct;
import com.tax.sales.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class of the Sales Tax System application.
 * This class handles user input, parses item details,
 * and orchestrates the creation of products and the final receipt.
 * @author Bashar
 */


public class SalesTaxSystem {

    private static final Logger logger = LoggerFactory.getLogger(SalesTaxSystem.class); // LoggerFactory is from SLF4J


    /**
     * The main entry point of the application.
     * It manages the entire sales process from reading input to printing the receipt.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {


        logger.info("\n Enter sales items (one per line). Enter a blank line to finish: \n");

      List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputLine;


        // A loop to continuously read input lines until an empty line is entered.
        while (scanner.hasNextLine() && !(inputLine = scanner.nextLine()).isEmpty()) {
            try {
                // Parse the line to determine product details
                String[] parts = inputLine.split(" at ");
                double price = Double.parseDouble(parts[1]);
                String name = parts[0].substring(parts[0].indexOf(' ') + 1);
                boolean isImported = name.contains("imported");

                // Uses conditional logic to dynamically instantiate the correct Product subclass.
                // This is a key demonstration of polymorphism and dynamic processing.

                if (name.contains("book")) {
                    products.add(new Book(name, price, isImported));
                } else if (name.contains("chocolate")) {
                    products.add(new Food(name, price, isImported));
                } else if (name.contains("pills")) {
                    products.add(new MedicalProduct(name, price, isImported));
                } else {
                    products.add(new GeneralProduct(name, price, isImported));
                }

            } catch (Exception e) {
                logger.error("Invalid input format. Please try again.");
            }
        }

        // Checks if any products were entered before attempting to generate a receipt.
        if (!products.isEmpty()) {
            Receipt receipt = new Receipt(products);
            receipt.printReceipt();
        } else {
            logger.info("No items entered. Receipt is empty.");
        }

        // Closes the scanner to release system resources.
        scanner.close();
    }
  
}