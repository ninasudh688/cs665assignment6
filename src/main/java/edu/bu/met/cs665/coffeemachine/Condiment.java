/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2024
 * File Name: Condiment.java
 * Description: This class is responsible for handling the methods and attributes of a Condiment.
 */

package edu.bu.met.cs665.coffeemachine;

public class Condiment {
  /**
   * This is Condiment class which is responsible for representing Condiments.
   * Condiments such as milk & sugar that can be are toppings for a Beverage.
   */
  private int milk;
  private int sugar;

  /**
   * Create a Condiment object using milk and sugar parameters.
   *
   * @param milk  amount of milk to be added.
   * @param sugar sugar packet units to be added.
   */
  public Condiment(int milk, int sugar) {
    this.milk = milk;
    this.sugar = sugar;
  }

  /**
   * Getter method for Condiment milk.
   *
   * @return milk units to be added to the drink.
   */
  public int getMilk() {
    return milk;
  }

  /**
   * Setter method for Condiment milk.
   *
   * @param milk units to be added to the drink.
   */
  public void setMilk(int milk) {
    this.milk = milk;
  }

  /**
   * Getter method for Condiment sugar.
   *
   * @return sugar units to be added to the drink.
   */
  public int getSugar() {
    return sugar;
  }

  /**
   * Setter method for Condiment sugar.
   *
   * @param sugar units to be added to the drink.
   */
  public void setSugar(int sugar) {
    this.sugar = sugar;
  }
}
