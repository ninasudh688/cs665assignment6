/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/05/2024
 * File Name: Beverage.java
 * Description: This class is responsible for methods/attributes of a Beverage.
 */

package edu.bu.met.cs665.coffeemachine;

public abstract class Beverage {
  /**
   * This is the abstract Beverage class.
   * This class is responsible for representing a Beverage.
   */
  private String beverageSize;
  private double basePrice;
  protected CondimentHandler condimentHandler; // Composition

  /**
   * Create a Beverage object using size, price,and condiment handler.
   *
   * @param beverageSize     size of drink as string
   * @param basePrice        price oof base drink  as double
   * @param condimentHandler condimentHandler
   */
  public Beverage(String beverageSize, double basePrice,
                  CondimentHandler condimentHandler) {
    this.beverageSize = beverageSize;
    this.basePrice = basePrice;
    this.condimentHandler = condimentHandler;
  }

  /**
   * Template Method, that all beverages use for the preparation process.
   *
   * @param condiment condiment to be added .
   */
  public final void prepareBeverage(Condiment condiment) {
    brew(); // Abstract step
    addCondiments(condiment); // Concrete step 1
    serveBeverage(); //concrete step2
  }

  /**
   * Abstract brew method that all beverages types use.
   */
  public abstract void brew();

  /**
   * Calculates final price with condiment price charges included.
   *
   * @param condiment the milk pr sugar to be added tp drink.
   */
  public void addCondiments(Condiment condiment) {
    condimentHandler.addCondiments(condiment);
  }

  /**
   * Method that all beverages use containing service details.
   * Prints String message about beverage size and price.
   */
  public void serveBeverage() {
    System.out.println("Serving the " + getBeverageSize() + " beverage,\n"
        + "Final Price: $" + calculateFinalPrice() + "\n");
  }

  /**
   * Calculates final price with condiment price charges included.
   *
   * @return the base cost of drink + condiment total price.
   */
  public double calculateFinalPrice() {
    return basePrice + condimentHandler.calculateCondimentPrice();
  }

  /**
   * Getter method for Condiments.
   *
   * @return all the condiments
   */
  public String getCondimentDetails() {
    return condimentHandler.getCondiments();
  }

  /**
   * Getter method for beverage base cost.
   *
   * @return the base cost of drink
   */
  public double getBasePrice() {
    return basePrice;
  }

  /**
   * Getter method for Beverage size.
   *
   * @return the size of the drink.
   */
  public String getBeverageSize() {
    return beverageSize;
  }



  /**
   * Getter method for instance of condiment handler.
   *
   * @return t
   */
  public CondimentHandler getCondimentHandler() {
    return condimentHandler;
  }

  /**
   * Setter method for base price of beverage.
   *
   * @param condimentHandler set instance of condiment handler.
   */
  public void setCondimentHandler(CondimentHandler condimentHandler) {
    this.condimentHandler = condimentHandler;
  }
}
