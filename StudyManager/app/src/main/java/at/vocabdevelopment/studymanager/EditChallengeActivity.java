package at.vocabdevelopment.studymanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class EditChallengeActivity extends AppCompatActivity implements View.OnClickListener{

    String challenge_id;
    Deck deck;
    Button active;
    Button inactive;
    Button save_and_home;
    Button new_b;
    Button delete;
    EditText challenge_name;

    LinearLayout linearLayout;
    List<Flashcard> flashcards;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_edit_view);

        challenge_id = getIntent().getStringExtra("CHALLENGE_ID");

        active = (Button) findViewById(R.id.button12);
        active.setOnClickListener(this);
        inactive = (Button) findViewById(R.id.button13);
        inactive.setOnClickListener(this);
        save_and_home = (Button) findViewById(R.id.button14);
        save_and_home.setOnClickListener(this);
        new_b = (Button) findViewById(R.id.button16);
        new_b.setOnClickListener(this);
        delete = (Button) findViewById(R.id.button11);
        delete.setOnClickListener(this);

        challenge_name = (EditText) findViewById(R.id.editText5);

        deck = Deck.findById(Deck.class, Long.parseLong(challenge_id));
        challenge_name.setText(deck.getName());
        flashcards = deck.getCards();

        //show all cards
        showCards(false);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button11:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you really want to delete this challenge?").setTitle("Delete?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deck.delete();
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                //finish();
                break;
            case R.id.button12:
                showCards(false);
                break;

            case R.id.button13:
                showCards(false);
                break;

            //check if user changed name (if yes, save new name to database) and go to start activity
            case R.id.button14:
                if(!deck.getName().equals(challenge_name.getText().toString())){
                    deck.setName(challenge_name.getText().toString());
                    deck.save();
                    Intent StartActivity = new Intent(EditChallengeActivity.this, StartActivity.class);
                    startActivity(StartActivity);
                    finish();
                }
                Intent StartActivity = new Intent(EditChallengeActivity.this, StartActivity.class);
                startActivity(StartActivity);
                finish();
                break;
            case R.id.button16:
                Intent AddCardActivity = new Intent(EditChallengeActivity.this, AddCardActivity.class);
                AddCardActivity.putExtra("CHALLENGE_ID", challenge_id);
                startActivity(AddCardActivity);
                //finish();
                break;
            default:
                String card_id = Integer.toString(v.getId());
                Intent EditCardActivity = new Intent(EditChallengeActivity.this, EditCardActivity.class);
                EditCardActivity.putExtra("CARD_ID", card_id);
                startActivity(EditCardActivity);
                break;
        }
    }

    //display cards. depending on boolean, display whole deck or only active cards
    public void showCards(boolean only_active){
        flashcards = deck.getCards();
        linearLayout = (LinearLayout) findViewById(R.id.questions);
        linearLayout.removeAllViews();
        //show only active cards
        if(only_active){
            for(int i=0; i<flashcards.size(); i++){
                Flashcard current_card = flashcards.get(i);
                if(current_card.getActive()){
                    Button button = new Button(this);
                    button.setText(current_card.getQuestion());
                    button.setId((int) (long) current_card.getId());
                    button.setOnClickListener(this);
                    linearLayout.addView(button);
                }
            }
        }
        //show all cards
        else{
            for(int i=0; i<flashcards.size(); i++){
                Flashcard current_card = flashcards.get(i);
                Button button = new Button(this);
                button.setText(current_card.getQuestion());
                button.setId((int) (long) current_card.getId());
                button.setOnClickListener(this);
                linearLayout.addView(button);
            }
        }

    }

}
