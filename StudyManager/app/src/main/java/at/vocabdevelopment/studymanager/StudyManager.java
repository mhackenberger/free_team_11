package at.vocabdevelopment.studymanager;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class StudyManager extends Activity implements View.OnClickListener{

    public Button buttonContinueChallenge;
    public Button buttonSearchChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_manager);

        buttonContinueChallenge = (Button) findViewById(R.id.buttonContinueChallenge);
        buttonSearchChallenge = (Button) findViewById(R.id.buttonBrowseChallenges);

        buttonContinueChallenge.setOnClickListener(this);
        buttonSearchChallenge.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Button clickedButton = (Button) v;

        switch(clickedButton.getId())
        {
            case R.id.buttonContinueChallenge:
                //TODO: still needs to be implemented...
                System.out.println("Continue Button clicked");
                break;

            case R.id.buttonBrowseChallenges:
                Intent browseChallenges = new Intent(getApplicationContext(), BrowseChallenges.class);
                startActivity(browseChallenges);
                break;
            default:
                //TODO: still needs to be implemented...
                System.out.println("Default behaviour not handled yet...");
                break;
        }
    }


}
