package at.vocabdevelopment.studymanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity implements View.OnClickListener{

    String challenge_id;

    Button save;
    EditText question;
    EditText answer;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_add);

        challenge_id = getIntent().getStringExtra("CHALLENGE_ID");

        save = (Button) findViewById(R.id.save_button);
        save.setOnClickListener(this);

        question = (EditText) findViewById(R.id.question_textview);
        answer = (EditText) findViewById(R.id.answer_textview);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_button){
            if (question.getText().toString().equals("")){
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Please type in a question!").setTitle("No challenges");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if(answer.getText().toString().equals("")){
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Please type in an answer!").setTitle("No challenges");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else{
                String qu = question.getText().toString();
                String ans = answer.getText().toString();

                Deck deck = Deck.findById(Deck.class, Long.parseLong(challenge_id));
                Flashcard card = new Flashcard(qu, ans, 1, true, deck);
                card.save();

                Intent EditChallengeActivity = new Intent(AddCardActivity.this, EditChallengeActivity.class);
                EditChallengeActivity.putExtra("CHALLENGE_ID", challenge_id);
                startActivity(EditChallengeActivity);

            }
        }
    }

}
