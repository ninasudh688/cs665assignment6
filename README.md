
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | NINA SUDHEESH              |
| Date         | 12/04/2024                 |
| Course       | Fall                       |
| Assignment # | 6                          |

# Assignment Overview

The goal is to  identify issues in previous assignment 1-4.
Once we identified them we are supposed to refactor the code,JUnits, this readme.md and the UML.
I selected assignment 1 where is we had to create a machine that was supposed to manage creating different types of
coffee and tea beverages. 


# GitHub Repository Link:
https://github.com/ninasudh688/cs665assignment6
 
# Refactored Description 

- Looking back at my assignment one, one opportunity for improvement is to implement design patterns.
1) Which is why first change I made  was to add a design pattern.
When I did assignment 1, I only used inheritance,encapsulation,abstraction, and polymorphism instead
of a design pattern. I noticed looking at my code that all beverages uses common steps and methods and method order.
This led me to refactor the code to use the template Method pattern:
  - The Template Method Pattern allows for the common steps of the brewing or preparation process to be defined once
    in the abstract class ensuring that all subclasses follow the same structure.
  - This avoids code duplication and centralizes common logic.
  - For instance, all coffee or tea must go through steps like brewing,condiments,and getting served final price
    which can be shared among all subclasses. By implementing the template method,it also ensures that no beverage
    forgets to perform one of those steps.
  - As more drinks are added in the future, there will be more similar steps to add but different processes.
  - Therefore, with template method abstract methods like customBrew() and customSteeping() each subclasses can just
    modify their own processes. All of this reduces the risk of bugs and inconsistencies across different beverage types.
  - Code changed due to template pattern:
    - In doing so, I added  template method prepareBeverage() to Beverage class, which calls the brew(), 
addCondiments(), and serveBeverage() methods.
    - ServeBeverage is method I added that calls calculate final price and along with beverage details to
    signal end of beverage creation process.
    - I also modified  Coffee and Tea abstract classes that have implements the brew() method,and have each abstract
customBrew or customSteeping method so that each subclasses can override them to extract the custom brew process.
  2)  Another opportunities that I noticed were was CondimentHandler method addCondiments was  
are becoming too large and was doing multiple responsibilities. 
 - This mean that were not following single responsibility principle. This made me want to refactor it
into smaller, more manageable methods. 
 - But first, I noticed that the method has conditionals in that are quite similar to each other since they share same 
condiment unit range, which is essentially code duplication. 
 - So first I separate and extracted this method into single validation method called validateCondimentUnit(). 
I made it private and adjusted it parameters so that any condiment can call it to validate unit amount.
 - Then I called this method back into addCondiment(). 
 - I also then extracted the summing of the total valid condiments amounts into new private 
method called calculateCondimentTotalAmount(). Then this method is called in addCondiment after validateCondimentUnit()
 - Now there is less redundancy and code duplication within the class. All 3 methods addCondiment,
validateCondimentUnit() , and calculateCondimentTotalAmount().
each have single responsibility to focus on. 
 - They are more maintainable, and easy to update in the future.
3) Temporary variables:
   - I had uses temporary variables like milkUnitsToAdd and sugarUnitsToAdd that were only used within 
this method addCondiments in Condiment Handler and not needed or used elsewhere.
   - So I modified it to directly pass the condiment.getMilk() and condiment.getSugar() values into the 
validateCondimentUnit() method, making the code cleaner.
   - This de-clutters the code and make its more readable and maintainable.
4) Removal
  - I also noticed that I had some setters that were not implemented anywhere.
  - So I removed setBeverageSize,setBasePrice,setNumberOfShots() since these values are set once 
during the creating of the Beverage object and as of current version of project they aren't expected to change.
- If I were to re-refactor this refactored code I think I would try to implement the strategy pattern instead in 
order to increase flexibility and promote composition among beverage types. 


# How the code is set up 
- The design is straightforward and simple. The Beverage class handles drink-specific logic,
  CondimentHandler manages condiments, and VendingMachine does beverage brewing. The
  Beverage class simplifies the structure by allowing code reuse across different beverage subclasses.
- Beverage.java = Abstract Class (Template Method):
  - This class defines the overall structure of the beverage preparation process.
  - This class method were modified to use template method prepareBeverage(), 
  which calls the brew(), addCondiments(), and serveBeverage() methods in a fixed order because it doesn't make sense
for the order of this common steps to change between each cofee or tea type.
  - It is extended by Coffee and Tea.
  -This design allows for the easy addition of new beverage types such as
    Hot Chocolate by creating new subclasses that extend the Beverage class.
    It allows me to define common attributes and methods, such as brew() and calculateFinalPrice(),
    that subclasses of different types of coffee or tea can override for unique usage.


- Coffee.java and Tea.java are abstract classes that extend from the Beverage class.
     - They implement the brew() method with the shared, generic steps for brewing coffee and tea, respectively.
     - Coffee and Tea are also using inheritance as the parents classes for specific coffee
       or tea beverages such as espresso or black tea.
      - It also makes easy to add different types of coffee or tea classes like OolongTea or Cappuccino since
        subclasses inherit common properties (like size or base price) and behaviors like adding condiments),which
        is good for code reuse.
      - Coffee.java = Abstract Class (Subclass of Beverage):provides the basics for specific coffee beverages.
      It implements the brew() method, which defines how gerneic coffee is brewed. 
      - Tea.java = Abstract Class (Subclass of Beverage) = basics for specific tea beverages.
        It implements the brew() method, which defines how tea is brewed.
      - Concrete coffee &  tea types classes will extend this class.
- LatteMacchiato.java, Espresso.java, Americano.java = Concrete Classes (Subclasses of Coffee)
  - Each of these classes extends Coffee and implements the customBrew() method to provide the specific brewing process 
  for each type of coffee.
- GreenTea.java, YellowTea.java, BlackTea.java = Concrete Classes (Subclasses of Tea)
  - Each of these classes extends Tea and implements the customSteeping() method to provide the specific brewing process
for each type of tea.
  
- Condiment.java = Model Class This class represents a condiment, holding properties such as milk and sugar.
- CondimentHandler.java = Helper Class 
  - This class manages the condiments within beverages making it simple to add new condiments in the future. 
  - It contains methods for adding condiments like milk and sugar and for calculating the price of those condiments.
  - By separating beverage types from condiment handling,
  the system is designed to deal with new condiment modifications without redoing a lot of code.
  The code is modular or flexible because it uses composition with the CondimentHandler and the Beverage class.
  Since each beverage controls its own condiment handler, that deals with the condiments added.

- VendingMachine.java = Context Class 
  - The VendingMachine class uses the prepareBeverage() method from Beverage to handle beverage preparation. 
  - It has a composition relationship with Beverage, allowing it to create and manage beverage instances 
  - It stores the total count of beverages served and tracks the prices


My code & Running it And UML:
- I placed my UML diagram in cs665_assignment6_UMLDiagram_andRefactoringScreenshots_Sudheesh.PDF 
within this zipped folder. 
  - It also shows comparison of refactoring between the assignment as screenshots.
- I placed my code in package coffee machine under the edu.bu.met.cs665 package.
- The Main class is outside this package.
- I placed code to test in junit test TestingVendingMachine as well as Main class.
  The code compiles using mvn clean compile.


Previous Assumptions that I made during assignment 1:

- I assumed that for now the vending machine will offer a predefined set of beverages
- (e.g., Americano, Espresso, Green Tea,etc) and that any additional beverage types can be
- easily added by creating new subclasses of the Beverage class. This design promotes flexibility
- when for the future. I also assumed that assumes that each beverage has a base price, and the final price
- is calculated by adding the cost of condiments. I also assumed that each condiment adds a fixed price
- ($0.50)  multiplied by total number of condiments used in the drink.
- I assumed that beverages have size, and base price. I also assumed that coffee has roast type and that
  not all teas are caffeinated.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




