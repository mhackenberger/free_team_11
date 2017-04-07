package at.vocabdevelopment.studymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.Context;
import java.util.List;

public class ChallengeOverviewActivity extends AppCompatActivity  implements View.OnClickListener {

    final Context context = this;
    Button new_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_overview);

        new_button = (Button) findViewById(R.id.new_button);
        new_button.setOnClickListener(this);


        List<Deck> decks = Deck.listAll(Deck.class);
        //check if there are any challenges/decks yet
        if(decks.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Time to add a new one!").setTitle("No challenges");
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.new_button){
            Intent AddChallengeActivity = new Intent(ChallengeOverviewActivity.this, AddChallengeActivity.class);
            startActivity(AddChallengeActivity);
        }
    }

}
