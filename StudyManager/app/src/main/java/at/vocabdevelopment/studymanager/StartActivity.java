package at.vocabdevelopment.studymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    Button continue_button;
    Button overview_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        continue_button = (Button) findViewById(R.id.continue_challenge);
        continue_button.setOnClickListener(this);

        overview_button = (Button) findViewById(R.id.challenge_overview);
        overview_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.continue_challenge:
                Intent ChallengeQuestionActivity = new Intent(StartActivity.this, ChallengeQuestionActivity.class);
                startActivity(ChallengeQuestionActivity);
                //finish();
                break;

            case R.id.challenge_overview:
                Intent ChallengeOverviewActivity = new Intent(StartActivity.this, ChallengeOverviewActivity.class);
                startActivity(ChallengeOverviewActivity);
                //finish();
                break;
        }
    }

}
