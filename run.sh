#!/bin/bash

# Define the project directory
PROJECT_DIR="."

# Define the JAR name and version from the pom.xml.
# This makes the script more flexible.
JAR_NAME="sales-tax-system-1.0-SNAPSHOT.jar"

echo "Building the project with Maven..."
# Navigate to the project directory and clean & package the project
cd "$PROJECT_DIR" || { echo "Error: Project directory not found."; exit 1; }
mvn clean package

# Check if the build was successful
if [ $? -eq 0 ]; then
    echo "Build successful. Running the application..."
    # Navigate to the target directory and run the JAR
    cd target || { echo "Error: target directory not found."; exit 1; }
    java -jar "$JAR_NAME"
else
    echo "Maven build failed. Aborting."
fi