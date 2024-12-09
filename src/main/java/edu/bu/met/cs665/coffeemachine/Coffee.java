/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/7/2024 updated
 * File Name: Coffee.java
 * Description:This class is responsible for the methods/attributes of a Coffee.
 */

package edu.bu.met.cs665.coffeemachine;

public abstract class Coffee extends Beverage {
  /**
   * This is Coffee class which  is responsible for representing a Coffee.
   * Coffee is type of Beverage and why its child class of Beverage class
   * Update: now its implements template method's abstract method brew.
   *  Also, it now an abstract class so that it's subclasses can override for custom brew details.
   */
  private String roastType;

  /**
   * Create a Coffee object using size,price,condimentHandler,& roastType parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param roastType        coffee roast type
   */
  public Coffee(String beverageSize, double basePrice, CondimentHandler
      condimentHandler, String roastType) {
    super(beverageSize, basePrice, condimentHandler);
    this.roastType = roastType;
  }

  /**
   * Brew method that all coffees classes use.
   * Updated to call abstract method
   */
  @Override
  public void brew() {
    // Shared Initial base brewing message for coffee types.
    System.out.println("Brewing coffee beans: ");
    System.out.println(customBrew()); //specific brewing process
  }

  /**
   * Abstract method that subclasses must have for specific brewing details.
   */
  protected abstract String customBrew();

  /**
   * Get method that to get roast type of coffee.
   *
   * @return roastType  string roast type of the coffee being made.
   */
  public String getRoastType() {
    return roastType;
  }

  /**
   * Set method that to set roast type of coffee.
   *
   * @param roastType roast type of the coffee beans being made.
   */
  public void setRoastType(String roastType) {
    this.roastType = roastType;
  }
}


