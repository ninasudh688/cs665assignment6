/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/05/2024
 * File Name: YellowTea.java
 * Description: This class is responsible for the methods and attributes of a Yellow Tea.
 */

package edu.bu.met.cs665.coffeemachine;

/**
 * This is YellowTea class which  is responsible for representing a Yellow tea.
 * Yellow Tea is type of Tea and why its child class of Tea class.
 */
public class YellowTea extends Tea {

  /**
   * Create an YellowTea object using Tea via super() parameters.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price of base drink as double.
   * @param condimentHandler condimentHandler
   * @param isCaffeinated    checks if tea is caffeinated or not via boolean.
   */
  public YellowTea(String beverageSize, double basePrice,
                   CondimentHandler condimentHandler, boolean isCaffeinated) {
    super(beverageSize, basePrice, condimentHandler, isCaffeinated);
  }

  /**
   * Brew method to steep the tea leaves.
   *
   * @return String message about tea steeping.
   */
  @Override
  protected String customSteeping() {
    return "Brewing an Yellow Tea " + getBeverageSize() + " with that Caffeine:"
        + isCaffeinated() + ".";
  }
}
