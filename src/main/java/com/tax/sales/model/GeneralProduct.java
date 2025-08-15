
package com.tax.sales.model;

/**
 *
 * @author Bashar
 */
public class GeneralProduct extends Product {

    public GeneralProduct(String name, double shelfPrice, boolean isImported) {
        super(name, shelfPrice, isImported);
    }

    @Override
    // Other products have a 10% basic sales tax.
    public double getSalesTaxRate() {
        return 0.10;
    }
}
