package com.tax.sales.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.Properties;

public final class TaxConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(TaxConfiguration.class);
    private static final Properties properties = new Properties();

    public static final double SALES_TAX_RATE;
    public static final double IMPORT_DUTY_RATE;

    static {
        // Use try-with-resources to ensure the input stream is closed automatically.
        try (InputStream input = TaxConfiguration.class.getClassLoader().getResourceAsStream("tax.properties")) {
            if (input == null) {
                // Log a warning and use hard-coded defaults if the file is not found.
                logger.warn("tax.properties not found. Using default tax rates.");
                properties.setProperty("sales.tax.rate", "0.10");
                properties.setProperty("import.duty.rate", "0.05");
            } else {
                // Load the properties from the file.
                properties.load(input);
            }
        } catch (Exception e) {
            // Log an error and use defaults if an exception occurs during loading.
            logger.error("Error loading tax properties file. Using default tax rates.", e);
            properties.setProperty("sales.tax.rate", "0.10");
            properties.setProperty("import.duty.rate", "0.05");
        }

        // Assign the final, guaranteed values to the public fields.
        SALES_TAX_RATE = Double.parseDouble(properties.getProperty("sales.tax.rate"));
        IMPORT_DUTY_RATE = Double.parseDouble(properties.getProperty("import.duty.rate"));
    }

    // A private constructor prevents external instantiation.
    private TaxConfiguration() {}
}