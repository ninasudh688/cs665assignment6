/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/7/2024 updated
 * File Name: Americano.java
 * Description: This class is responsible for the methods and attributes of an Americano.
 */

package edu.bu.met.cs665.coffeemachine;

/**
 * This is Americano class which  is responsible for representing an Americano.
 * This is type of Coffee drink and why its child class of Coffee class.
 */

public class Americano extends Coffee {

  /**
   * Create an Americano object using super() parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param roastType        coffee roast type
   */
  public Americano(String beverageSize, double basePrice, CondimentHandler
      condimentHandler, String roastType) {
    super(beverageSize, basePrice, condimentHandler, roastType);
  }

  /**
   * Brew method to brew the coffee beans for americano.
   *
   * @return String message about americano roast brewed.
   */
  @Override
  protected String customBrew() {
    return "\tBrewing an Americano " + getBeverageSize() + " with " + getRoastType() + ".";
  }

}
