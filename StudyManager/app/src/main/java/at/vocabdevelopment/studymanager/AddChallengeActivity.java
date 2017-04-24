package at.vocabdevelopment.studymanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddChallengeActivity extends AppCompatActivity implements View.OnClickListener {

    final Context context = this;

    Button save_button;
    EditText challenge_name;

    String challenge_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_challenge);

        save_button = (Button) findViewById(R.id.button);
        save_button.setOnClickListener(this);

        challenge_name = (EditText) findViewById(R.id.challenge_name);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            //check if user entered name. show dialog if he didn't
            if(challenge_name == null || challenge_name.getText().toString().equals("")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Please enter a challenge name!").setTitle("Name empty");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            //save challenge in database
            else{
                String name = challenge_name.getText().toString();
                List<Deck> decks_same_name = Deck.find(Deck.class, "challengename = ?", name);
                if(!decks_same_name.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("deck exists already - please enter a unique name").setTitle("redundant deck");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else{
                    Deck deck = new Deck(name);
                    deck.save();
                    challenge_id = Long.toString(deck.getId());

                    Intent EditChallengeActivity = new Intent(AddChallengeActivity.this, EditChallengeActivity.class);
                    EditChallengeActivity.putExtra("CHALLENGE_ID", challenge_id);
                    startActivity(EditChallengeActivity);
                }
            }
        }
    }

}
