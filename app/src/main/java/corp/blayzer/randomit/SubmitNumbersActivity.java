package corp.blayzer.randomit;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class SubmitNumbersActivity extends AppCompatActivity {

    EditText minVal, maxVal;
    TextInputLayout minVal_layout, maxVal_layout;
    RandomFunctions randomFunc = new RandomFunctions();
    FloatingActionButton btn_go;
    String emptyErrMin, emptyErrMax, largerErr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_numbers);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        minVal = findViewById(R.id.minVal);
        minVal_layout = findViewById(R.id.minVal_layout);
        maxVal = findViewById(R.id.maxVal);
        maxVal.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    btn_go.performClick();
                    return true;
                }
                return false;
            }
        });
        maxVal_layout = findViewById(R.id.maxVal_layout);

        btn_go = findViewById(R.id.button);
        btn_go.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(v.getContext(), DisplayNumResultActivity.class);
                                          // Clean any errors
                                          minVal_layout.setError(null);
                                          // minVal_layout.setErrorEnabled(false);
                                          maxVal_layout.setError(null);
                                          // maxVal_layout.setErrorEnabled(false);
                                          //       _End_
                                          if (minVal.getText().toString().equals("")) {
                                              emptyErrMin = getString(R.string.emptyMinVal);   /**Get the error string from the res*/
                                              minVal_layout.setError(emptyErrMin);    /**Set error in case minimum value is empty*/
                                              return;
                                          } else if (maxVal.getText().toString().equals("")) {
                                              emptyErrMax = getString(R.string.emptyMaxVal);
                                              maxVal_layout.setError(emptyErrMax);    /**Set error in case maximum value is empty*/
                                              return;
                                          }
                                          if (Integer.parseInt(minVal.getText().toString()) > Integer.parseInt(maxVal.getText().toString())) {
                                              largerErr = getString(R.string.biggerVal);
                                              minVal_layout.setError(largerErr);    ///**Set error in case minimum value is bigger than maximum value
                                          } else {
                                              /** Called when the user taps the Go button */
                                              int lowVal = Integer.parseInt(minVal.getText().toString()); /* Get user input to var lowVal */
                                              int highVal = Integer.parseInt(maxVal.getText().toString()); /* Get user input to var highVal */
                                              int myVal = randomFunc.calculateNumbers(lowVal, highVal);
                                              String tipStr = randomFunc.tipStrGenerator(myVal);
                                              intent.putExtra("intValName", myVal);
                                              intent.putExtra("tipStrHolder", tipStr);
                                              startActivity(intent);
                                              //finish();
                                          }
                                      }
                                  }

        );
    }
}



