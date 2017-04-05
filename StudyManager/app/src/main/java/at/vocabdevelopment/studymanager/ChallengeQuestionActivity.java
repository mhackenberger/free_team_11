package at.vocabdevelopment.studymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChallengeQuestionActivity extends AppCompatActivity implements View.OnClickListener{

    Button show_answer_button;
    Button quit_challenge_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_question);

        show_answer_button = (Button) findViewById(R.id.show_answer_button);
        show_answer_button.setOnClickListener(this);

        quit_challenge_button = (Button) findViewById(R.id.quit_challenge_button);
        quit_challenge_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.show_answer_button:
                Intent ChallengeAnswerActivity = new Intent(ChallengeQuestionActivity.this, ChallengeAnswerActivity.class);
                startActivity(ChallengeAnswerActivity);
                //finish();
                break;

            case R.id.challenge_overview:
                Intent StartActivity = new Intent(ChallengeQuestionActivity.this, StartActivity.class);
                startActivity(StartActivity);
                //finish();
                break;
        }
    }

}
