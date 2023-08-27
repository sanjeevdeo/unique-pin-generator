# Spring Boot Library for Generating Unique Pin

Java Library to generate the unique 4 digits random pins.

## Requirements
- Java 17
- Any IDE (Intellij or Eclipse) to view the code

## Build and Test Locally

- Clone the code on your local workstation (Mac/Windows etc)
- Open Terminal (on Mac) or Command Prompt / PowerShell (on Windows)
- Change you directory to the source code location (cloned in first step)
- Execute below command
  - On Terminal (Mac) / PowerShell (Windows): 
  ```
  ./gradlew clean build
  ```
  - On Command Prompt (Windows):
  ```
  gradlew.bat clean build
  ```

<b>Note:</b> You can observe all the test case execution events on console

## Usage
- Once build is successful it will generate the jar file (unique-pin-generator-0.0.1-SNAPSHOT.jar) in `build/libs/unique-pin-generator-0.0.1-SNAPSHOT.jar` 
- Copy the jar into different project and add it as a Gradle dependencies
  - Call below method to generate single pin
  ```
  UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();
  uniquePinGenerator.getUniquePin()
  ```
- Call below method to generate pin in batch
  ```
  UniquePinGenerator uniquePinGenerator = new UniquePinGenerator();
  uniquePinGenerator.getUniquePin(inputBatchSize)
  ```

<b>Note:</b> Max value for the batch size can be between 1 - 9000. Input lower bath size to generate random pin and avoid sequencing.