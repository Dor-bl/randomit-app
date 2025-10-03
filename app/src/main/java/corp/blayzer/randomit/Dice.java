package corp.blayzer.randomit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.Random;

public class Dice extends AppCompatActivity {

    private TextView diceResultTextView;
    private Button rollDiceButton;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view to your new layout
        setContentView(R.layout.activity_dice);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Dice Roller");
        }

        // Initialize views
        diceResultTextView = findViewById(R.id.diceResultTextView);
        rollDiceButton = findViewById(R.id.rollDiceButton);

        // Set a click listener on the button to roll the die
        rollDiceButton.setOnClickListener(v -> rollDice());
    }

    private void rollDice() {
        // Generate a random number between 1 and 6
        int result = random.nextInt(6) + 1;
        // Update the TextView with the result
        diceResultTextView.setText(String.valueOf(result));
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button in the toolbar
        onBackPressed();
        return true;
    }
}