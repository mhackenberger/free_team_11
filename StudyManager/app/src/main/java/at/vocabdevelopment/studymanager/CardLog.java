package at.vocabdevelopment.studymanager;

import com.orm.SugarRecord;

/**
 * Created by Magdalena on 07.04.2017.
 */

public class CardLog extends SugarRecord{
    boolean correct_answer;
    Flashcard card;

    public CardLog(){}

    public CardLog(boolean corr, Flashcard car) {
        this.correct_answer = corr;
        this.card = car;
    }
}

