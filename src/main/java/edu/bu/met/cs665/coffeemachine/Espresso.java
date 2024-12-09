/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/7/2024 updated
 * File Name: Espresso.java
 * Description: This class is responsible for the methods and attributes of an Espresso.
 */

package edu.bu.met.cs665.coffeemachine;

public class Espresso extends Coffee {
  /**
   * This is Espresso class which  is responsible for representing an Espresso.
   * This is type of Coffee drink and why its child class of Coffee class.
   */
  private final int numOfShots; // Number of espresso shots

  /**
   * Create an Espresso object using super() and numOfShots parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param roastType        coffee roast type
   * @param numOfShots       number of espresso shots used
   */
  public Espresso(String beverageSize, double basePrice,
                  CondimentHandler condimentHandler, String roastType,
                  int numOfShots) {
    super(beverageSize, basePrice, condimentHandler, roastType);
    this.numOfShots = numOfShots;
  }

  /**
   * Custom Espresso Brew method to brew the coffee beans.
   *
   * @return String message about espresso brewed details.
   */
  @Override
  protected String customBrew() {
    return " \tBrewing an Espresso " + getBeverageSize() + " with " + getRoastType()
        + " with " + numOfShots + " espresso shots.";
  }

  /**
   * Get method that to get numOfShots.
   *
   * @return numOfShots  number of shots of espresso being made.
   */
  public int getNumOfShots() {
    return numOfShots;
  }

}
