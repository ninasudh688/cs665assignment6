/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/7/2024 updated
 * File Name: Main.java
 * Description: THis main class to help with testing outside JUnits.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.coffeemachine.Americano;
import edu.bu.met.cs665.coffeemachine.Beverage;
import edu.bu.met.cs665.coffeemachine.Condiment;
import edu.bu.met.cs665.coffeemachine.CondimentHandler;
import edu.bu.met.cs665.coffeemachine.Espresso;
import edu.bu.met.cs665.coffeemachine.LatteMacchiato;
import edu.bu.met.cs665.coffeemachine.VendingMachine;
import edu.bu.met.cs665.coffeemachine.YellowTea;


/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    System.out.println("This is a test message for Main.java file)");
    System.out.println("Beverage vending machine is running...");

    // You can initialize some basic objects here if needed for setup purposes
    CondimentHandler condimentHandler = new CondimentHandler();
    Beverage americano1 = new Americano("Large", 4.0, condimentHandler,
        "Medium Roast");
    americano1.prepareBeverage(new Condiment(2, 1)); // Add condiments
    VendingMachine vendingMachine = getVendingMachine();
    vendingMachine.displayAvailableBeverages();
  }

  private static VendingMachine getVendingMachine() {
    Beverage espresso = new Espresso("Medium", 2.00, new CondimentHandler(),
        "Dark Roast", 2);
    Beverage latte = new LatteMacchiato("Medium", 3.00, new CondimentHandler(),
        "Light Roast");
    Beverage yellowTea = new YellowTea("small", 2.00, new CondimentHandler(),
        false);
    Condiment condiment = new Condiment(3, 2);
    Condiment condiment1 = new Condiment(1, 2);
    Condiment condiment2 = new Condiment(0, 0);

    VendingMachine vendingMachine = new VendingMachine();
    vendingMachine.prepareBeverageForVending(espresso, condiment);
    vendingMachine.prepareBeverageForVending(latte, condiment1);
    vendingMachine.prepareBeverageForVending(yellowTea, condiment2);
    vendingMachine.addBeverage(espresso);
    vendingMachine.addBeverage(latte);
    vendingMachine.addBeverage(yellowTea);
    return vendingMachine;
  }

}
