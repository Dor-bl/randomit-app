package corp.blayzer.randomit;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by Dor-B on 26/01/2018.
 */

public class CheckValidation implements TextWatcher {
    public void afterTextChanged(Editable s){
        try {
            Log.d("maxVal", "input: " + s);
            if(Integer.parseInt(s.toString()) > 100) {
                s.replace(0, s.length(), "100");
            }
        }
        catch(NumberFormatException nfe){}
    }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Not used, details on text just before it changed
        // used to track in detail changes made to text, e.g. implement an undo
    }
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Not used, details on text at the point change made
    }
}

