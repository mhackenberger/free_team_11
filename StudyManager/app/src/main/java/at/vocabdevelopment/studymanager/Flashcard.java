package at.vocabdevelopment.studymanager;

import com.orm.SugarRecord;

/**
 * Created by Magdalena on 07.04.2017.
 */

public class Flashcard extends SugarRecord {
    String question;
    String answer;
    int level;
    boolean active;
    Deck deck;

    public Flashcard(){}

    public Flashcard(String qu, String ans, int lev, boolean ac, Deck de){
        this.question = qu;
        this.answer = ans;
        this.level = lev;
        this.active = ac;
        this.deck = de;
    }
}
