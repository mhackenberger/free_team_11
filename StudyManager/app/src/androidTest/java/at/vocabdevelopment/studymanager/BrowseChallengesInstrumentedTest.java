package at.vocabdevelopment.studymanager;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class BrowseChallengesInstrumentedTest {

    @Rule
    public ActivityTestRule<BrowseChallenges> mActivityRule = new ActivityTestRule<>(BrowseChallenges.class);

    @Test
    public void testButtons() throws Exception {
        onView(withText("Add Challenge")).perform(click());
        onView(withText("Select Challenge")).perform(click());
    }
}
