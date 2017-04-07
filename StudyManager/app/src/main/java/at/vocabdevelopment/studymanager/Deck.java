package at.vocabdevelopment.studymanager;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Magdalena on 07.04.2017.
 */

public class Deck extends SugarRecord {
    String challenge_name;

    public Deck(){}

    public Deck(String name){
        this.challenge_name = name;
    }

    List<Flashcard> getCards() {
        String id = Long.toString(getId());
        return Flashcard.find(Flashcard.class, "deck = ?", id);
    }
}
