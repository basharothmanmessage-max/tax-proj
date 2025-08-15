
package com.tax.sales.model;

import com.tax.sales.config.TaxConfiguration;

/**
 * An abstract class representing a generic product. This class serves as the
 * foundation for all specific product types and enforces a contract for tax
 * calculation.
 * @author Bashar
 */
public abstract class Product {

    // The name of the product ("book", "music CD").
    protected String name;

    // The price of the product before any taxes are applied.
    protected double shelfPrice;

    // A flag indicating whether the product is imported.
    protected boolean isImported;


    /**
     * Constructs a new Product.
     * @param name The name of the product.
     * @param shelfPrice The price of the product.
     * @param isImported A boolean indicating if the product is imported.
     */
    public Product(String name, double shelfPrice, boolean isImported) {
        this.name = name;
        this.shelfPrice = shelfPrice;
        this.isImported = isImported;
    }

    /**
     * An abstract method that forces all concrete subclasses to define their
     * own basic sales tax rate. This is the core of the polymorphism in this
     * application.
     *
     * @return The basic sales tax rate as a decimal (e.g., 0.10 for 10%).
     */
    public abstract double getSalesTaxRate();


    /**
     * Calculates the import duty rate based on whether the product is imported.
     * This method is shared by all product types.
     *
     * @return The import duty rate (0.05 if imported, 0.0 otherwise).
     */

    public double getImportDutyRate() {
        // Use the configurable rate from the TaxConfiguration class
        return isImported ? TaxConfiguration.IMPORT_DUTY_RATE : 0.0;
    }
    /**
     * Calculates the total tax on the product by summing the basic sales tax
     * and import duty, then applying the specific rounding rule.
     *
     * @return The total tax amount.
     */
    public double calculateTax() {
        double basicTax = shelfPrice * getSalesTaxRate();
        double importTax = shelfPrice * getImportDutyRate();
        double totalTax = basicTax + importTax;

        // Rounding up to the nearest 0.05
        return Math.ceil(totalTax * 20) / 20;
    }


    /**
     * Calculates the final price of the product by adding the calculated tax
     * to the original shelf price.
     *
     * @return The final price including all applicable taxes.
     */
    public double getFinalPrice() {
        return shelfPrice + calculateTax();
    }

    public String getName() {
        return name;
    }


    /**
     * Retrieves the shelf price of the product (price before tax).
     *
     * @return The product's shelf price.
     */
    public double getShelfPrice() {
        return shelfPrice;
    }

    public double getTotalTax() {
        return calculateTax();
    }

}
