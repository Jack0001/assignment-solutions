import java.util.ArrayList;

/**
 * Lithium Grading class for sorting trays in to low and high grades
 * Sorts low and high grades in to ascending order
 *
 * @author Jack Oliver - JO343
 * @version 23/10/19
 */
public class LithiumGrading
{
    private ArrayList<Integer> lowGrade = new ArrayList<Integer>();
    private ArrayList<Integer> highGrade = new ArrayList<Integer>();
    private GenerateLithium generate;
    /**
     * Constructor for objects of class LithiumGrading();
     * Executes the methods for testing
     */    
    public LithiumGrading(GenerateLithium generate)
    {
        this.generate = generate;
        generateGrades(generate.getTray());
        sortingLithium();
        printLists();
    }
    
     /**
     * Put the values of the tray in to high and low grade as needed
     * 
     * @param tray - The tray of lithium values
     */
    
    public void generateGrades(int tray[][])
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tray[i][j] > 25)
                {
                    highGrade.add(tray[i][j]); 
                }
                else
                {
                    lowGrade.add(tray[i][j]);
                }
            }
        }
    }

    /**
     * Bubble sort on the low and high grade lists
     */
    public void sortingLithium()
    {

        for (int lst=lowGrade.size()-1; lst>0; lst--) {
            for (int i=0; i<lst; i++) {
                if (lowGrade.get(i)>lowGrade.get(i+1)) { //swap
                    int k=lowGrade.get(i); 
                    lowGrade.set(i, lowGrade.get(i+1)); 
                    lowGrade.set(i+1, k);}
            }}

        for (int lst=highGrade.size()-1; lst>0; lst--) {
            for (int i=0; i<lst; i++) {
                if (highGrade.get(i)>highGrade.get(i+1)) { //swap
                    int k=highGrade.get(i); 
                    highGrade.set(i, highGrade.get(i+1)); 
                    highGrade.set(i+1, k);}
            }}

    }

    /**
     * Prints both the high grade and low grade lists
     */
    public void printLists()
    {
        System.out.println("Contents of low grade tray: ");
        for(int x = 0; x < lowGrade.size(); x++)
            System.out.println(lowGrade.get(x));
        System.out.println("Contents of high grade tray: ");
        for(int x = 0; x < highGrade.size(); x++)
            System.out.println(highGrade.get(x));

    }
}
