package com.example.seniordesignproject;

import com.example.seniordesignproject.Fragments.AccountFragment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class SubmitFeedbackActivityTest {

    private final static String MESSAGE = "Message";
    private final static String MESSAGE2 = "Message2";



    @Rule
    public ActivityScenarioRule<SubmitFeedbackActivity> activityTestRule =
            new ActivityScenarioRule<>(SubmitFeedbackActivity.class);

        @Test
        public void submitFeedbackTest() {
            onView(withId(R.id.formopinionedit)).perform(typeText(MESSAGE)).check(matches(isDisplayed()));
            onView(withId(R.id.submitform)).perform(scrollTo(), click());
        }

    @Test
    public void navigationToAccountFragmentTest() {
            Intents.init();
        onView(withId(R.id.formopinionedit)).perform(typeText(MESSAGE)).check(matches(isDisplayed()));
        onView(withId(R.id.backtomainfeedbackbutton)).perform(scrollTo(), click());
        intended(hasComponent(HomeActivity.class.getName()));
        Intents.release();


    }




}