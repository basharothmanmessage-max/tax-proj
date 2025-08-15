package com.tax.sales.helper.test;



import com.tax.sales.helper.Receipt;
import com.tax.sales.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

public class ReceiptTest {

    // Mock objects for our test
    @Mock
    private Product product1;
    @Mock
    private Product product2;

    @BeforeEach
    void setUp() {
        // Initialize mock objects for each test method
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTotalTaxCalculation() {
        // Define the behavior of our mock objects
        when(product1.getTotalTax()).thenReturn(1.50);
        when(product2.getTotalTax()).thenReturn(7.15);

        List<Product> products = Arrays.asList(product1, product2);
        Receipt receipt = new Receipt(products);

        // Verify the total tax is correctly calculated
        assertEquals(8.65, receipt.calculateTotalTax());
    }

    @Test
    void testTotalCostCalculation() {
        // Define the behavior of our mock objects
        when(product1.getFinalPrice()).thenReturn(16.49);
        when(product2.getFinalPrice()).thenReturn(54.65);

        List<Product> products = Arrays.asList(product1, product2);
        Receipt receipt = new Receipt(products);

        // Verify the total cost is correctly calculated
        assertEquals(71.14, receipt.calculateTotalCost());
    }
}