import java.util.*;
/**
 * Write a description of class BuyLithium here.
 *
 * @author Jack Oliver - JO343  
 * @version 24/10/19
 */
public class BuyLithium
{
    LithiumPricing priceList;

    /**
     * Constructor for objects of class BuyLithium
     */
    public BuyLithium(LithiumPricing priceList)
    {
        this.priceList = priceList;
    }

    /**
     * Finds prices under the value entered by the buyer
     * 
     * @param buyerPrice - The price the buyer wants to compare against
     */

    public void findBestPrice(Double buyerPrice)
    {
        int count = 0;
        for (Map.Entry<String, Double> entry : priceList.getGradePricing().entrySet())
        {
            if(entry.getValue() <= buyerPrice){
                String temp = entry.getKey();    
                int grading = Integer.parseInt(temp.split(" ")[1]);
                System.out.println(grading + " " + entry.getValue()); 
                count++;
            }
        }
        System.out.println("There are " + count +  " choices available to you. ");
    }

    /**
     * Finds grades higher than the value entered by the buyer
     * 
     * @param buyerGrade - The grade the buyer wants to compare against
     */
    public void findHighQuality(Integer buyerGrade)
    {
        if(buyerGrade >= 1 && buyerGrade <= 50)
        {

            int count = 0;

            for (Map.Entry<String, Double> entry : priceList.getGradePricing().entrySet())
            {
                String temp = entry.getKey();    
                int grading = Integer.parseInt(temp.split(" ")[1]);
                if(grading >= buyerGrade){

                    System.out.println(grading + " " + entry.getValue());
                    count++;
                }
            }
            System.out.println("There are " + count +  " choices available to you. ");
        }
        else
        {
            System.out.println("enter a value between 1 and 50");
        }
    }
}
