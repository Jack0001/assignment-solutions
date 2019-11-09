import java.util.*;
public class GenerateLithium

{
    private int tray [][] = new int [5][3];
    private int grading = 0;
    private Random randomGenerator;
    /**
     * Constructor for objects of class GenerateLithium
     */
    public GenerateLithium()
    {
        randomGenerator = new Random();
        generateSample();
    }

    /**
     * Generates sample of lithium and places it in the tray
     */
    public void generateSample()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grading = randomGenerator.nextInt(50);
                tray[i][j] = grading + 1;
            }
        }
    }

    /**
     * Prints the tray of lithium
     */
    public void printTray()
    {
        System.out.println("Contents of current tray: ");

        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<3; j++)
            {
                System.out.print("|| " + tray[i][j] + " || ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Returns the tray
     * 
     * @return the tray 2d array
     */
    public int[][] getTray()
    {
        return tray;
    }
}

