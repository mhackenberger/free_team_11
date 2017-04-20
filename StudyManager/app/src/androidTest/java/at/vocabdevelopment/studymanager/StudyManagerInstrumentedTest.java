package at.vocabdevelopment.studymanager;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class StudyManagerInstrumentedTest {

    @Rule
    public ActivityTestRule<StudyManager> mActivityRule = new ActivityTestRule<>(StudyManager.class);

    @Test
    public void testButtons() throws Exception {
        onView(withText("Continue Challenge")).perform(click());
        onView(withText("Browse Challenges")).perform(click());
    }

    @Test
    public void testBrowseChallengesRedirect() throws  Exception {
        onView(withText("Browse Challenges")).perform(click());
        onView(withId(R.id.searchViewChallenges)).check(matches(isDisplayed()));
        onView(withId(R.id.listViewChallanges)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddChallenge)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonSelectChallenge)).check(matches(isDisplayed()));
    }
}
