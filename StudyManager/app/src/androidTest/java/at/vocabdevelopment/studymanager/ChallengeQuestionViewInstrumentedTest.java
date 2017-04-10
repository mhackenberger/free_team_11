package at.vocabdevelopment.studymanager;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ChallengeQuestionViewInstrumentedTest {
    @Rule
    public ActivityTestRule<ChallengeQuestionActivity> mActivityRule = new ActivityTestRule<>(
            ChallengeQuestionActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.vocabdevelopment.studymanager", appContext.getPackageName());
    }

    @Test
    public void testButtons() {
        onView(withText("Show Answer")).perform(click());
        Espresso.pressBack();
        onView(withText("Quit Challenge")).perform(click());
    }
}
