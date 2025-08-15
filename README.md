Sales Tax Application

This is a Java Maven application that calculates sales tax and total cost for a list of items, demonstrating key Object-Oriented Programming (OOP) principles like abstraction, inheritance, and polymorphism.

***********************************************

***********************************************

Features
Tax Calculation: Automatically applies a 10% basic sales tax and a 5% import duty based on item type and origin.

Tax Exemptions: Items categorized as books, food, or medical products are exempt from basic sales tax.

Dynamic Processing: The application reads item details from the command line, processes each item, and generates a formatted receipt.


Configurable Tax rate :

tax.properties : use this to configure the desired values

<img width="1104" height="159" alt="image" src="https://github.com/user-attachments/assets/d94d46d5-9652-4054-8351-8a3192a49f40" />


***********************************************

***********************************************


OOP Design:

Abstraction: The Product abstract class defines a common interface for all items.

Inheritance: Specific product types (Book, Food, OtherProduct, etc.) inherit from Product to implement their unique tax rules.

Polymorphism: The Receipt class treats all items as the generic Product type, calling the correct tax calculation method for each specific item automatically.

Logging: Uses the SLF4J and Logback frameworks for clean, configurable logging instead of System.out.println.

***********************************************

***********************************************

How to Run
Prerequisites
Java Development Kit (JDK) 17 or higher

***********************************************

***********************************************

Apache Maven

>> mvn clean package
>> java -jar target/sales-tax-system-1.0-SNAPSHOT.jar

or use  run.bat / run.sh 



<img width="454" height="107" alt="image" src="https://github.com/user-attachments/assets/66d26c69-1585-4e52-a477-b9d7a6b26009" />

NOTE : make sure to the target folder has been created by MVN command 

***********************************************


***********************************************

Running the Application
After building, you can run the application from the target/ directory.

(Bash)
java -jar target/sales-tax-system-1.0-SNAPSHOT.jar
The application will prompt you to enter items. After entering all items, press Enter on an empty line to receive the final receipt.

Example Input and Output:

Input:

1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Output:

Enter sales items (one per line). Enter a blank line to finish:
Receipt:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
--------------------
