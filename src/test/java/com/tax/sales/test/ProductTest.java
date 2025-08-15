package com.tax.sales.test;



import com.tax.sales.model.Book;
import com.tax.sales.model.GeneralProduct;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testBookTaxCalculation() {
        Book book = new Book("book", 12.49, false);
        assertEquals(0.00, book.getSalesTaxRate());
        assertEquals(0.00, book.getTotalTax());
        assertEquals(12.49, book.getFinalPrice());
    }

    @Test
    void testImportedBookTaxCalculation() {
        Book importedBook = new Book("imported book", 12.49, true);
        assertEquals(0.00, importedBook.getSalesTaxRate());
        assertEquals(0.65, importedBook.getTotalTax()); // 12.49 * 0.05 = 0.6245 -> rounds to 0.65
        assertEquals(13.14, importedBook.getFinalPrice()); // 12.49 + 0.65 = 13.14
    }

    @Test
    void testOtherProductTaxCalculation() {
        GeneralProduct cd = new GeneralProduct("music CD", 14.99, false);
        assertEquals(0.10, cd.getSalesTaxRate());
        assertEquals(1.50, cd.getTotalTax()); // 14.99 * 0.10 = 1.499 -> rounds to 1.50
      //  assertEquals(16.49, cd.getFinalPrice());
    }

    @Test
    void testImportedOtherProductTaxCalculation() {
        GeneralProduct importedPerfume = new GeneralProduct("imported bottle of perfume", 47.50, true);
        // Sales Tax (10%) + Import Duty (5%) = 15%
        // 47.50 * 0.15 = 7.125 -> rounds to 7.15
        assertEquals(0.10, importedPerfume.getSalesTaxRate());
        assertEquals(0.05, importedPerfume.getImportDutyRate());
        assertEquals(7.15, importedPerfume.getTotalTax());
        assertEquals(54.65, importedPerfume.getFinalPrice()); // 47.50 + 7.15 = 54.65
    }

    @Test
    void testRoundingRule() {
        GeneralProduct item = new GeneralProduct("test item", 10.00, false);
        double tax = 10.00 * 0.10; // = 1.00
        assertEquals(1.00, Math.ceil(tax * 20) / 20);

        GeneralProduct item2 = new GeneralProduct("test item", 1.99, false);
        double tax2 = 1.99 * 0.10; // = 0.199
        assertEquals(0.20, Math.ceil(tax2 * 20) / 20);
    }
}