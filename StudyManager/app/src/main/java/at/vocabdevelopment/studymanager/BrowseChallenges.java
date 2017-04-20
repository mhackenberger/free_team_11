package at.vocabdevelopment.studymanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class BrowseChallenges extends Activity implements View.OnClickListener{

    public Button buttonAddChallenge;
    public Button buttonSelectChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_challenges);

        buttonAddChallenge = (Button) findViewById(R.id.buttonAddChallenge);
        buttonSelectChallenge = (Button) findViewById(R.id.buttonSelectChallenge);

        buttonAddChallenge.setOnClickListener(this);
        buttonSelectChallenge.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Button clickedButton = (Button) v;

        switch(clickedButton.getId())
        {
            case R.id.buttonAddChallenge:
                //TODO: still needs to be implemented...
                System.out.println("Add Button clicked");
                break;
            case R.id.buttonSelectChallenge:
                //TODO: still needs to be implemented...
                System.out.println("Select Button clicked");
                break;
            default:
                //TODO: still needs to be implemented...
                System.out.println("Default behaviour not handled yet...");
                break;
        }
    }


}
