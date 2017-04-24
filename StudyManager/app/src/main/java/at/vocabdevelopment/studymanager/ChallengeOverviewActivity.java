package at.vocabdevelopment.studymanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class ChallengeOverviewActivity extends AppCompatActivity  implements View.OnClickListener {

    final Context context = this;
    Button new_button;
    LinearLayout linearLayout;

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
        else{
            linearLayout = (LinearLayout) findViewById(R.id.challege_overview_linear_layout);
            for(int i = 0; i < decks.size(); i++){
                Deck current_deck = decks.get(i);
                Button button = new Button(this);
                button.setText(current_deck.getName());
                button.setId((int) (long) current_deck.getId());
                button.setOnClickListener(this);
                linearLayout.addView(button);
            }
        }
    }

    @Override
    public void onClick(View v) {
        //if the presses the button to add a new challenge, navigate to AddChallengeActivity
        if (v.getId() == R.id.new_button){
            Intent AddChallengeActivity = new Intent(ChallengeOverviewActivity.this, AddChallengeActivity.class);
            startActivity(AddChallengeActivity);
        }
        else{
            //if the user clicks on a existing challenge, navigate to ChallengeSetupActivity
            String challenge_id = Integer.toString(v.getId());
            Intent ChallengeSetupActivity = new Intent(ChallengeOverviewActivity.this, ChallengeSetupActivity.class);
            ChallengeSetupActivity.putExtra("CHALLENGE_ID", challenge_id);
            startActivity(ChallengeSetupActivity);
        }
    }

}
