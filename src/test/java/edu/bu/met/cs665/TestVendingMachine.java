/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/26/2024
 * File Name: TestVendingMachine.java
 * Description: This class is responsible for testing methods/classes for creating beverages.
 */

package edu.bu.met.cs665;

import org.junit.Test;
import edu.bu.met.cs665.coffeemachine.*;

import static org.junit.Assert.*;

/**
 * Some Unit tests for the vending machine.
 */

public class TestVendingMachine {

    @Test
    public void testAmericanoWithCondiments() {
        /*
         * Given: A medium-sized $3.00 light roast Americano beverage object.
         * When: User a adds 2 milk and  1 sugar.
         * Then: we confirm the expected result is the same as the value obtained from the  method.
         */

        Beverage coffee = new Americano("Medium", 3.00, new CondimentHandler(),
            "Light Roast");


        // Assert that the correct amount of condiments has been added.
        coffee.prepareBeverage(new Condiment(2, 1));

        assertEquals("Expected Milk units = 2", 2,
            coffee.getCondimentHandler().getTotalAddedMilk());
        assertEquals("Expected Sugar units = 1", 1,
            coffee.getCondimentHandler().getTotalAddedSugar());
    }
    @Test
    public void testAmericanoWithCondimentsPrice() {
        /*
         * Given: A large-sized $5.00 dark roast Americano beverage object.
         * When: User a adds 3 milk and  1 sugar.
         * Then: Confirm the expected result is the same as the value obtained from the  method.
         */

        Beverage coffee = new Americano("Large", 5.00, new CondimentHandler(),
            "Dark Roast");
        coffee.prepareBeverage(new Condiment(3, 1));

        // Check the final price with condiments---Base price + condiment price
        double expectedPrice = coffee.getBasePrice() + ((3 + 1) * 0.50);
        assertEquals("Expected price with condiments: ",expectedPrice,
            coffee.calculateFinalPrice(), 0.01);
        assertNotEquals("Expect final price with condiment charge Not base charge: ",
            5.00, coffee.calculateFinalPrice(), 0.01);
    }
    @Test
    public void testBrewEspressoWithCondiments() {
        /*
         * Given: A medium-sized $3.00 light roast Espresso beverage object.
         * When: User a adds 3 milk and  2 sugar.
         * Then: we confirm the expected result is the same as the value obtained from the method.
         */

        Coffee espresso = new Espresso("Medium", 2.00, new CondimentHandler(),
            "Light Roast",2);

         VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.prepareBeverageForVending(espresso,new Condiment(3, 2));

        // Assert that the correct amount of condiments has been added
        assertEquals("Expected Milk units = 3", 3,
            espresso.getCondimentHandler().getTotalAddedMilk(),0.1);
        assertEquals("Expected Sugar units = 2", 2,
            espresso.getCondimentHandler().getTotalAddedSugar(),0.1);
    }

    @Test
    public void testGreenTeaWithoutCondiments() {
        /*
         * Given: A medium-sized $2.50 caffeinated Green Tea beverage object.
         * When: User a adds no milk and sugar.
         * Then: Confirm the expected result is the same as the value obtained from the  method.
         */

        Beverage tea = new GreenTea("Medium",
            2.50, new CondimentHandler(), true);
        tea.prepareBeverage(new Condiment(0, 0));
        assertEquals("Expected Milk units = 0", 0,
            tea.getCondimentHandler().getTotalAddedMilk());
        assertEquals("Expected Sugar units = 0", 0,
            tea.getCondimentHandler().getTotalAddedSugar());
    }
    @Test
    public void testGreenTeaWithoutCondimentsPrice() {
        /*
         * Given: A medium-sized $2.50 caffeinated Green Tea beverage object
         * When: User a adds no milk and sugar.
         * Then: Confirm the expected result is the same as the value obtained from the  method.
         */

        Beverage beverage = new GreenTea("Medium",
            2.50, new CondimentHandler(), true);
//        Condiment con = new Condiment(0, 0);
//        beverage.addCondiments(con);
        // No condiments are added, so base price should be unchanged
        assertEquals(2.50, beverage.getBasePrice(), 0.01);
        assertEquals(2.50, beverage.calculateFinalPrice(), 0.01);
    }
    @Test
    public void testAddBeverageToVendingMachine() {
        /*
         * Given: A new VendingMachine object.
         * When: A large-sized $4.00 Americano beverage object is added.
         * Then: We confirm that the beverage has been added to the vending machine.
         */

        VendingMachine vendingMachine = new VendingMachine();
        Beverage latte = new LatteMacchiato("Large", 4.00,
            new CondimentHandler(), "Medium Roast");

        // Add beverage to vending machine
        vendingMachine.addBeverage(latte);

        // Check if the beverage was added successfully
        vendingMachine.displayAvailableBeverages(); // This will print the available beverages
        // Since we're not capturing output, we can only check if it doesn't throw an error.

        // Verify the beverage was added correctly by checking if the size and price match
        assertEquals("Expected Beverage Size", "Large", latte.getBeverageSize());
        assertEquals("Expected Beverage Price", 4.00,
            latte.getBasePrice(), 0.01);
    }


}