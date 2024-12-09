/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2024
 * File Name: VendingMachine.java
 * Description: This class is responsible for methods/attributes of a Vending Machine.
 */

package edu.bu.met.cs665.coffeemachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
  /**
   * This is VendingMachine class which is responsible for handling a Vending Machine operations.
   * It handles Beverage brewing and creating list of VendingMachine beverages.
   */

  private List<Beverage> availableBeverages;

  /**
   * Create a VendingMachine object that initializes list of available beverage.
   */
  public VendingMachine() {
    availableBeverages = new ArrayList<>();
  }

  /**
   * Method to add beverage to list of available beverages.
   *
   * @param beverage Beverage object to add.
   */
  public void addBeverage(Beverage beverage) {
    availableBeverages.add(beverage);
  }

  /**
   * Method to do all beverage prep,creation, pricing, and serving.
   * Update: replaced brewBeverage with this method to use template method again.
   * @param beverage Beverage object to add.
   * @param condiment Condiment object to add milk/sugar units.
   */
  public void prepareBeverageForVending(Beverage beverage, Condiment condiment) {
    // Prepare the beverage using the Template Method
    beverage.prepareBeverage(condiment);
  }

  /**
   * Method to display the list of available beverages with prices as Menu.
   */
  public void displayAvailableBeverages() {
    System.out.println("\nAll Beverages Available: ");
    for (Beverage beverage : availableBeverages) {
      System.out.println(beverage.getClass().getSimpleName()
          + ": $" + beverage.getBasePrice());
    }
  }
}
