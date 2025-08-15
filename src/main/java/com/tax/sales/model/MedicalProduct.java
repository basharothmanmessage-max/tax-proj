
package com.tax.sales.model;

/**
 *
 * @author Bashar
 */
public class MedicalProduct extends Product {
    public MedicalProduct(String name, double shelfPrice, boolean isImported) {
        super(name, shelfPrice, isImported);
    }
    
    @Override
    // Medical products are exempt.
    public double getSalesTaxRate() {
        return 0.0;
    }
}
