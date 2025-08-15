
package com.tax.sales.model;

/**
 *
 * @author Bashar
 */
public class Book extends Product {
    public Book(String name, double shelfPrice, boolean isImported) {
        super(name, shelfPrice, isImported);
    }
    
    @Override
    public double getSalesTaxRate() {
        return 0.0; // Books are exempt from basic sales tax.
    }
}