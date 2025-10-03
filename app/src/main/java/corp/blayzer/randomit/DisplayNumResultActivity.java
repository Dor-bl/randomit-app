package corp.blayzer.randomit;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

import java.text.NumberFormat;

public class DisplayNumResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_numbers);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setTitle("Result");

        /** Get the Intent that started this activity and extract the integer*/
        Intent intent= getIntent();
        int intValue = intent.getIntExtra("intValName",0);
        String tipStrVal = intent.getStringExtra("tipStrHolder");

        /**Covert the integer of the result to proper string*/

        String randString= NumberFormat.getInstance().format(intValue);

        /** Capture the layout's TextView and set the Integer as its text*/
        TextView textNumView = findViewById(R.id.textNumView);
        TextView textTip = findViewById(R.id.textTip) ;
        textNumView.setText(randString);
        textTip.setText(tipStrVal);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back to the previous activity
        return true;
    }
}
