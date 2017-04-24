package at.vocabdevelopment.studymanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import static at.vocabdevelopment.studymanager.R.id.button4;
import static at.vocabdevelopment.studymanager.R.id.textView4;

public class ChallengeSetupActivity extends AppCompatActivity implements View.OnClickListener{

    String challenge_id;
    TextView challenge_name;
    Button edit_challenge;
    Button start_challenge;

    RadioGroup deck_radiogroup;
    RadioGroup difficulty_radiogroup;

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

        deck_radiogroup = (RadioGroup) findViewById(R.id.select_deckmode_radiogroup);
        deck_radiogroup.check(R.id.radioButton6);

        difficulty_radiogroup = (RadioGroup) findViewById(R.id.select_difficulty_radiogroup);
        difficulty_radiogroup.check(R.id.radioButton8);

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
        else if(v.getId() == R.id.button10) {
            int selected_deck_mode = deck_radiogroup.getCheckedRadioButtonId();
            int selected_difficulty_mode = difficulty_radiogroup.getCheckedRadioButtonId();

            String challenge_deck = "active";
            String difficulty = "easy";

            //check, which radio buttons are selected to configure the challenge
            switch (selected_deck_mode){
                case R.id.radioButton6:
                    challenge_deck = "active";
                    break;
                case R.id.radioButton7:
                    challenge_deck = "full";
                    break;
            }
            switch (selected_difficulty_mode){
                case R.id.radioButton8:
                    difficulty = "easy";
                    break;
                case R.id.radioButton9:
                    difficulty = "medium";
                    break;
                case R.id.radioButton10:
                    challenge_deck = "hard";
                    break;
            }

            //put extras to be able to access deck mode, difficulty and challenge id in the next activity
            Intent ChallengeQuestionActivity = new Intent(ChallengeSetupActivity.this, ChallengeQuestionActivity.class);
            ChallengeQuestionActivity.putExtra("CHALLENGE_ID", challenge_id);
            ChallengeQuestionActivity.putExtra("CHALLENGE_DECK", challenge_deck);
            ChallengeQuestionActivity.putExtra("CHALLENGE_DIFFICULTY", difficulty);
            startActivity(ChallengeQuestionActivity);
        }
    }
}
