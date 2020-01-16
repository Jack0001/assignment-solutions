import java.util.*;
/**
 * Lithium pricing - Generates tray and prices according to given table
 *
 * @author Jack Oliver JO343
 * @version 24/10/19
 */
public class LithiumPricing
{
    /**
     * To avoid duplicates the key contains the combination of the i and j indicies of the tray
     */
    private HashMap<String, Double> gradePricing = new HashMap<>();
    private GenerateLithium generate;

    /**
     * Constructor for objects of class LithiumPricing
     * Executes the methods for testing
     */
    public LithiumPricing(GenerateLithium generate)
    {
        this.generate = generate;
        setPrice(generate.getTray());
        printPrice();
    }

    /**
     * Takes a tray as a parameter and sets the correct price, according to grade and adds it to the hashmap
     * 
     * @param tray - The lithium tray
     */    
    public void setPrice(int[][] tray)
    {
        Double price = 0.0;

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tray[i][j] >= 1 && tray[i][j] <=9)
                {
                    price = 300.00;
                }
                else if (tray[i][j] >= 10 && tray[i][j] <=19)
                {
                    price = 600.00;
                }
                else if (tray[i][j] >= 20 && tray[i][j] <= 29)
                {
                    price = 900.00;
                }
                else
                {
                    price = 1250.00;
                }
                gradePricing.put(Integer.toString(i) + Integer.toString(j) + " " + tray[i][j], price);
            }
        }
    }

    /**
     * Prints the hashmap and associated keys and values (grading and prices)
     * 
     * Un
     */    
    public void printPrice()
    {
        for (Map.Entry<String, Double> entry : gradePricing.entrySet())
        {
            String temp = entry.getKey();    
            int grading = Integer.parseInt(temp.split(" ")[1]);
            System.out.println(grading + " " + entry.getValue());  
        }

    }

    /**
     * Get method for the gradePricing to use in other classes
     */

    public HashMap<String, Double> getGradePricing()
    {
        return gradePricing;
    }
}
