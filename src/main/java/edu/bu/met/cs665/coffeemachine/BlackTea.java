/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/05/2024
 * File Name: BlackTea.java
 * Description: This class is responsible for the methods and attributes of a BlackTea.
 */

package edu.bu.met.cs665.coffeemachine;

/**
 * This is BlackTea class which is responsible for representing a Black tea.
 * BlackTea is type of Tea and why its child class of Tea class.
 */

public class BlackTea extends Tea {

  /**
   * Create an BlackTea object using Tea via super() parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param isCaffeinated    checks if tea is caffeinated or not via boolean.
   */
  public BlackTea(String beverageSize, double basePrice, CondimentHandler
      condimentHandler, boolean isCaffeinated) {
    super(beverageSize, basePrice, condimentHandler, isCaffeinated);
  }

  /**
   * Brew method to steep the tea leaves.
   *
   * @return String message about tea steeping.
   */
  @Override
  protected String customSteeping() {
    return "Brewing an Black Tea " + getBeverageSize() + " with that Caffeine:"
        + isCaffeinated() + ".";
  }
}
