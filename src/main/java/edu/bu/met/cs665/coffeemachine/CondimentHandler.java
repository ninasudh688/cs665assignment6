/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2024
 * File Name: CondimentHandler.java
 * Description: This class is responsible for handling the methods and attributes of a Condiments.
 */

package edu.bu.met.cs665.coffeemachine;

public class CondimentHandler {
  /**
   * This is CondimentHandler class which is responsible for handling a Condiments.
   * It handles Condiment handling for milk or sugar which can be added to a Beverage.
   */
  private int totalAddedMilk;
  private int totalAddedSugar;
  private static final int MAX_UNITS = 3; // Maximum units for each condiment
  private static final double CONDIMENT_PRICE = 0.50; // Price per condiment unit

  /**
   * Create a CondimentHandler object that initializes milkToAdd,and sugarToAdd.
   * milkToAdd: units of milk to add to drink.
   * sugarToAdd: units of sugar to add to drink.
   */
  public CondimentHandler() {
    this.totalAddedMilk = 0;
    this.totalAddedSugar = 0;
  }

  /**
   * Method to add milk or sugar amounts.
   * Used to ensure that they are not greater than 3 units per condiment.
   * Updated by refactoring extract methods
   *
   * @param condiment Condiment object to get milk/sugar units.
   */
  public void addCondiments(Condiment condiment) {
    // removed temporary variables
    // Check the amounts of each condiment available per drink.
    int milkUnits = validateCondimentUnit("Milk", condiment.getMilk(),
        totalAddedMilk);
    int sugarUnits = validateCondimentUnit("Sugar", condiment.getSugar(),
        totalAddedSugar);
    // Update the condiment total counts
    calculateCondimentTotalAmount(milkUnits, sugarUnits);
  }

  /**
   * Validate an individual condiment (milk/sugar) based on current and limited amount of units.
   *
   * @param condimentName Name of the condiment (milk or sugar).
   * @param unitsToAdd    Units to be added.
   * @param totalAddedUnits    Current total units added.
   */
  private int validateCondimentUnit(String condimentName, int unitsToAdd, int totalAddedUnits) {
    // input: must be between 0 and MAX_UNITS
    if (unitsToAdd < 0 || unitsToAdd > MAX_UNITS) {
      throw new IllegalArgumentException(condimentName + " units must be between 0 and "
          + MAX_UNITS);
    }
    // Check total units do not exceed the maximum allowed
    if (totalAddedUnits + unitsToAdd > MAX_UNITS) {
      throw new IllegalArgumentException("Cannot exceed " + MAX_UNITS
          + " units of " + condimentName + ".");
    }
    return unitsToAdd;
  }


  /**
   * Update the total milk and sugar amounts.
   *
   * @param milkUnitsToAdd  Units of milk to add.
   * @param sugarUnitsToAdd Units of sugar to add.
   */
  private void calculateCondimentTotalAmount(int milkUnitsToAdd, int sugarUnitsToAdd) {
    // Update the condiment counts
    this.totalAddedMilk += milkUnitsToAdd;
    this.totalAddedSugar += sugarUnitsToAdd;
    System.out.println("\tAdded " + totalAddedMilk
        + " units of Milk and " + totalAddedSugar + " units of Sugar.");
  }

  /**
   * Calculate the total milk or sugar amounts cost
   * The condiment price is added to base price.
   */
  public double calculateCondimentPrice() {
    return (totalAddedMilk + totalAddedSugar) * CONDIMENT_PRICE;
  }

  /**
   * Gets Condiments to be added to a beverage.
   *
   * @return String displays number of condiments units
   */
  public String getCondiments() {
    return "Milk: " + totalAddedMilk + " units, Sugar: " + totalAddedSugar + " units";
  }

  /**
   * Gets total Milk to be added to a beverage.
   *
   * @return int totalAddedMilk units
   */
  public int getTotalAddedMilk() {
    return totalAddedMilk;
  }

  /**
   * Setter method for total milk added  to a beverage.
   *
   * @param totalAddedMilk units to be added to the drink.
   */
  public void setTotalAddedMilk(int totalAddedMilk) {
    this.totalAddedMilk = totalAddedMilk;
  }

  /**
   * Getter method for total Sugar added  to a beverage.
   *
   * @return sugar units to be added to the drink.
   */
  public int getTotalAddedSugar() {
    return totalAddedSugar;
  }

  /**
   * Setter method for total Sugar added  to a beverage.
   *
   * @param totalAddedSugar units to be added to the drink.
   */
  public void setTotalAddedSugar(int totalAddedSugar) {
    this.totalAddedSugar = totalAddedSugar;
  }
}


