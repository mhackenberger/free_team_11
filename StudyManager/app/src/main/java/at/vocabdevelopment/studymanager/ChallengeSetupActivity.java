package at.vocabdevelopment.studymanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static at.vocabdevelopment.studymanager.R.id.button4;
import static at.vocabdevelopment.studymanager.R.id.textView4;

public class ChallengeSetupActivity extends AppCompatActivity implements View.OnClickListener{

    String challenge_id;
    TextView challenge_name;
    Button edit_challenge;
    Button start_challenge;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_setup);

        challenge_id = getIntent().getStringExtra("CHALLENGE_ID");
        Deck deck = Deck.findById(Deck.class, Long.parseLong(challenge_id));

        challenge_name = (TextView) findViewById(textView4);
        challenge_name.setText(deck.getName());

        edit_challenge = (Button) findViewById(button4);
        edit_challenge.setOnClickListener(this);

        //notify user if deck is empty
        List<Flashcard> flashcards = deck.getCards();
        if(flashcards.size() == 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("No cards! Click \"edit\" to edit activity and add cards").setTitle("No cards");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button4) {
            Intent EditChallengeActivity = new Intent(ChallengeSetupActivity.this, EditChallengeActivity.class);
            EditChallengeActivity.putExtra("CHALLENGE_ID", challenge_id);
            startActivity(EditChallengeActivity);
        }
    }
}
