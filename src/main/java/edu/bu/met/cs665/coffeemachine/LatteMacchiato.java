/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/7/2024 updated
 * File Name: LatteMacchiato.java
 * Description: This class is responsible for the methods and attributes of a LatteMacchiato.
 */

package edu.bu.met.cs665.coffeemachine;

/**
 * This is LatteMacchiato class which  is responsible for representing a Latte Macchiato.
 * Latte Macchiato is type of Beverage and why its child class of Coffee class
 */

public class LatteMacchiato extends Coffee {

  /**
   * Create a Coffee object using size,price,condimentHandler,& roastType parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param roastType        coffee roast type
   */
  public LatteMacchiato(String beverageSize, double basePrice,
                        CondimentHandler condimentHandler, String roastType) {
    super(beverageSize, basePrice, condimentHandler, roastType);
  }

  /**
   * Custom Latte Macchiato Brew method to brew the coffee beans.
   *
   * @return String message about latte brewed details.
   */
  @Override
  protected String customBrew() {
    return "\tBrewing an Latte Macchiato " + getBeverageSize() + " with " + getRoastType() + ".";
  }
}