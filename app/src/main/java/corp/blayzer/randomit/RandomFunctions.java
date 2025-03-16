package corp.blayzer.randomit;

/**
 * Created by Dor-B on 26/05/2017.
 */

import com.google.android.material.textfield.TextInputLayout;
import android.view.View;

import java.util.Random;

import static corp.blayzer.randomit.SubmitStringsActivity.choicesArr;


public class RandomFunctions {
    /**
     *  This Function returns a random number between 2 given numbers.
     * @param lowVal - low value param for random number purposes, must be smaller or equal than highVal of course.
     * @param highVal - high value param for random number purposes, must be bigger or equal than lowVal of course.
     * @return A random number to display
     */
    public int calculateNumbers(Integer lowVal, Integer highVal)
    {

        Random rand = new Random(); /** Create a new object of type random */
        int resultVal = rand.nextInt((highVal - lowVal) + 1) + lowVal;  /**highVal is the maximum and lowVal is our minimum value*/
        return resultVal; /** return the random value */
    }

    /**
     *
     * @param rolledNum - An integer we use in the switch case to select a proper string.
     * @return A string that represent the fact which related to the given number
     */
    public String tipStrGenerator(Integer rolledNum)
    {
        String tipOfTheNum; /** the string that the function will return eventually */
        switch (rolledNum){

            case 1:
                tipOfTheNum= "You're number " +rolledNum ;
                break;
            case 8:
                tipOfTheNum= rolledNum+"% of people have an extra rib";
                break;
            case 20:
                tipOfTheNum= "You are " +rolledNum+"% Accurate";
                break;
            case 22:
                tipOfTheNum= "Alabama became the " +rolledNum+"nd state of the U.S.A on December 14, 1819.";
                break;
            case 85:
                tipOfTheNum= "Dark matter makes up about "+rolledNum+"% of the matter in our universe";
                break;
            case 6000:
                tipOfTheNum= "lightning strikes the Earth " +rolledNum+ " times every minute";
                break;
            default:
                tipOfTheNum= "";
                break;
        }

        return tipOfTheNum;
    }

    public static void addChoiceOption(TextInputLayout inputLayout)
    {

        //int optionIndex= choicesArr.length;
        choicesArr= expandArr(choicesArr);    /* expand the current array*/
        inputLayout.setVisibility(View.VISIBLE);
        inputLayout.invalidate();
    }

    public static String[] expandArr(String[] OrigArray){
        String[] newArray = new String[OrigArray.length + 1];
        System.arraycopy(OrigArray,0,newArray,0,OrigArray.length);
        return newArray;
    }

}



