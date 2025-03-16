package corp.blayzer.randomit;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


public class SubmitStringsActivity extends AppCompatActivity {
    RandomFunctions randomFunc = new RandomFunctions();
    EditText choice1Val,choice2Val,choice3Val,choice4Val,choice5Val,choice6Val,choice7Val,choice8Val,choice9Val;
    TextInputLayout firstVal_layout,secVal_layout;
    public static TextInputLayout threeVal_layout,fourVal_layout,fiveVal_layout,sixVal_layout,sevenVal_layout,eightVal_layout,nineVal_layout;
    FloatingActionButton btn_go,btn_add;
    Integer minValOpt= 0;
    String firstChoErr,secChoErr;
    String strResult;
    TextInputLayout layoutPointer;
    //EditText[] editTextsArr = new EditText[3];

    public static String[] choicesArr = new String[2];    //Initialize array for 2 since minimum options is 2

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_strings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get all Layouts
        /*1st Value*/
        choice1Val = findViewById(R.id.firstVal);
        firstVal_layout = findViewById(R.id.firstVal_layout);
        /*2nd Value*/
        choice2Val = findViewById(R.id.secVal);
        secVal_layout = findViewById(R.id.secVal_layout);
        /*3rd Value*/
        choice3Val = findViewById(R.id.thirdVal);
        threeVal_layout = findViewById(R.id.threeVal_layout);
        /*4th Value*/
        choice4Val = findViewById(R.id.fourVal);
        fourVal_layout = findViewById(R.id.fourVal_layout);
        /*5th Value*/
        choice5Val = findViewById(R.id.fiveVal);
        fiveVal_layout = findViewById(R.id.fiveVal_layout);
        /*6th Value*/
        choice6Val = findViewById(R.id.sixVal);
        sixVal_layout = findViewById(R.id.sixVal_layout);
        /*7th Value*/
        choice7Val = findViewById(R.id.sevenVal);
        sevenVal_layout = findViewById(R.id.sevenVal_layout);
        /*8th Value*/
        choice8Val = findViewById(R.id.eightVal);
        eightVal_layout = findViewById(R.id.eightVal_layout);
        /*9th Value*/
        choice9Val = findViewById(R.id.nineVal);
        nineVal_layout = findViewById(R.id.nineVal_layout);

        final EditText[] editTextsArr = {choice1Val,choice2Val,choice3Val,choice4Val,choice5Val,choice6Val,choice7Val,choice8Val,choice9Val};
        final TextInputLayout[] layoutsArr= {firstVal_layout,secVal_layout,threeVal_layout,fourVal_layout,fiveVal_layout,sixVal_layout,sevenVal_layout,eightVal_layout,nineVal_layout};

        btn_add = findViewById(R.id.fab_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layoutPointer= getLastInvisibleLayout(layoutsArr);
                RandomFunctions.addChoiceOption(layoutPointer);  //call Add choiceOption function in order to make new option visible
            }
        });

        btn_go = findViewById(R.id.button);
        btn_go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayChoiceResultActivity.class);
                // Clean any errors
                firstVal_layout.setError(null);
                // minVal_layout.setErrorEnabled(false);
                secVal_layout.setError(null);
                // maxVal_layout.setErrorEnabled(false);
                //       _End_
                if (choice1Val.getText().toString().equals("")) {
                    firstChoErr= getString(R.string.emptyChoiceStr);   /**Get the error string from the res*/
                    firstVal_layout.setError(firstChoErr);    /**Set error in case minimum value is empty*/
                    return;
                }
                 else if (choice2Val.getText().toString().equals("")){
                    secChoErr= getString(R.string.emptyChoiceStr);
                    secVal_layout.setError(secChoErr);    /**Set error in case maximum value is empty*/
                    return;
                }

                else  {
                    /** Called when the user taps the Go button */

                        for (int i=0; i< choicesArr.length ; i++){
                            EditText currVal =editTextsArr[i];
                            choicesArr[i] = (currVal.getText().toString());
                        }

                        int resVal = randomFunc.calculateNumbers(minValOpt, choicesArr.length-1); //Send minimum and maximum values to random function
                        strResult = choicesArr[resVal];
                        intent.putExtra("strChoiceVal", strResult);
                        startActivity(intent);
                        //finish();
                        }
            }
        }

        );

    }
    private static TextInputLayout getLastInvisibleLayout(TextInputLayout[] layoutArray){

        TextInputLayout goneLayout;
        int visibleStatus;
        for (TextInputLayout layout: layoutArray) {
            visibleStatus = layout.getVisibility();
            if (visibleStatus == 8) { // Layout is Gone
                goneLayout =  layout;
                return goneLayout;      //Return the first gone layout
            }
        }
        return null;
    }

}



