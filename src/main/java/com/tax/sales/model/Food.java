
package com.tax.sales.model;

/**
 *
 * @author Bashar
 */
public class Food extends Product {
    public Food(String name, double shelfPrice, boolean isImported) {
        super(name, shelfPrice, isImported);
    }
    
    @Override
    public double getSalesTaxRate() {
        return 0.0;
    }
}