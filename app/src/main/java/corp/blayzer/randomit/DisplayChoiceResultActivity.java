package corp.blayzer.randomit;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayChoiceResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_choices);

        /** Get the Intent that started this activity and extract the integer*/
        Intent intent= getIntent();
        String strChoiceVal = intent.getExtras().getString("strChoiceVal");

        /** Capture the layout's TextView and set the Integer as its text*/
        TextView textChoiceView = findViewById(R.id.textChoiceView);
        textChoiceView.setText(strChoiceVal);
    }
}
