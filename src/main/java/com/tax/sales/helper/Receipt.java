
package com.tax.sales.helper;

import com.tax.sales.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * The Receipt class is responsible for calculating and printing the final receipt.
 * It encapsulates the logic for summing up total taxes and costs for a list of products.
 * @author Bashar
 */
public class Receipt {

    // Initializes a logger for the class to handle all output and messages.
    private static final Logger logger = LoggerFactory.getLogger(Receipt.class); // LoggerFactory is from SLF4J

    // A list to hold the products for which the receipt is being generated.
    private List<Product> products;

    public Receipt(List<Product> products) {
        this.products = products;
    }


    /**
     * Calculates the total sales tax for all products in the list.
     * It iterates through each product and sums up their individual taxes.
     *
     * @return The total sales tax, rounded to two decimal places.
     */
    public double calculateTotalTax() {
        double totalTax = 0.0;
        for (Product product : products) {
            totalTax += product.getTotalTax();
        }
        return Math.round(totalTax * 100.0) / 100.0;
    }


    /**
     * Calculates the total cost for all products, including tax.
     * It iterates through each product and sums up their final prices.
     *
     * @return The total cost of all products, rounded to two decimal places.
     */
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Product product : products) {
            totalCost += product.getFinalPrice();
        }
        return Math.round(totalCost * 100.0) / 100.0;
    }


    /**
     * Prints a formatted receipt to the console using the logger.
     * The receipt includes a list of all items with their final prices,
     * followed by the total sales taxes and the final total cost.
     * The method utilizes the `String.format` method to ensure prices are displayed
     * with exactly two decimal places.
     */
    public void printReceipt() {
        logger.info("Receipt:");
        for (Product product : products) {
            logger.info("1 {}: {}", product.getName(), String.format("%.2f", product.getFinalPrice()));
        }
        logger.info("Sales Taxes: {}", String.format("%.2f", calculateTotalTax()));

        logger.info("Total: {}", String.format("%.2f", calculateTotalCost()));

        logger.info("--------------------");
    }
}