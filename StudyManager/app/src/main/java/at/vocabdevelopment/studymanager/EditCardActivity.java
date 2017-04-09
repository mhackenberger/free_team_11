package at.vocabdevelopment.studymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCardActivity extends AppCompatActivity implements View.OnClickListener{

    //the flashcard that is about to be edited
    Flashcard card;

    String card_id;
    Button save_button;
    EditText question;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_edit);

        card_id = getIntent().getStringExtra("CARD_ID");
        card = Flashcard.findById(Flashcard.class, Long.parseLong(card_id));

        save_button = (Button) findViewById(R.id.save_edited_card_button);
        save_button.setOnClickListener(this);

        question = (EditText) findViewById(R.id.question_edittext);
        //retrieve the question from database
        question.setText(card.getQuestion());
        answer = (EditText) findViewById(R.id.answer_edittext);
        //retrieve the answer from database
        answer.setText(card.getAnswer());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_edited_card_button) {
            card.setQuestion(question.getText().toString());
            card.setAnswer(answer.getText().toString());
            card.save();
            Deck deck = card.getDeck();
            String challenge_id = deck.getId().toString();
            Intent EditChallengeActivity = new Intent(EditCardActivity.this, EditChallengeActivity.class);
            EditChallengeActivity.putExtra("CHALLENGE_ID", challenge_id);
            startActivity(EditChallengeActivity);
        }
    }

}
