# Selenium Automation Setup (Java)

## Setup

1. Ensure you have Java (JDK 8+) and Maven installed.

2. Add the following dependencies to your `pom.xml`:

   ```xml
   <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>selenium-java</artifactId>
     <version>4.19.1</version>
   </dependency>
   <dependency>
     <groupId>io.github.bonigarcia</groupId>
     <artifactId>webdrivermanager</artifactId>
     <version>5.7.0</version>
   </dependency>
   <dependency>
     <groupId>org.junit.jupiter</groupId>
     <artifactId>junit-jupiter</artifactId>
     <version>5.10.2</version>
     <scope>test</scope>
   </dependency>
   ```

3. Place your test in `src/test/java/` as shown below.

## Running Tests

```
mvn test
```

## Notes

- Chrome browser must be installed.
- The sample test opens Google and searches for "Selenium".
