/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/05/2024
 * File Name: Tea.java
 * Description: This class is responsible for the methods and attributes of a Tea.
 */

package edu.bu.met.cs665.coffeemachine;

public abstract class Tea extends Beverage {
  /**
   * This is Tea abstract class which  is responsible for representing a Tea.
   * Tea is type of Beverage and why its child class of Beverage class.
   * Update: now its implements template method's abstract method brew.
   * Also, it now an abstract class so that it's subclasses can override for custom brew details.
   */
  private boolean isCaffeinated;

  /**
   * Create a Tea object using size,price,condimentHandler,& isCaffeinated parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param isCaffeinated    if tea is caffeinated
   */
  public Tea(String beverageSize, double basePrice,
             CondimentHandler condimentHandler, boolean isCaffeinated) {
    super(beverageSize, basePrice, condimentHandler);
    this.isCaffeinated = isCaffeinated;
  }

  /**
   * Brew method for steeping the tea.
   * Updated to call abstract method
   */
  @Override
  public void brew() {
    System.out.println("Steeping the tea in boiling water: ");
    System.out.println(customSteeping()); //specific tea type brewing process
   }

  /**
   * Abstract method that subclasses must have for specific steeping details.
   */
  protected abstract String customSteeping();

  /**
   * Boolean method for beverage base cost.
   *
   * @return isCaffeinated checks if tea is caffeinated or not
   */
  public boolean isCaffeinated() {
    return isCaffeinated;
  }
}
