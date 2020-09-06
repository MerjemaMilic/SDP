package com.example.seniordesignproject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class NewRateActivityTest {

    String city = "Sarajevo";
    String neighborhood = "Skenderija";
    String content = "Review";

    @Rule
    public ActivityScenarioRule<NewRateActivity> activityTestRule =
            new ActivityScenarioRule<>(NewRateActivity.class);

    @Test
    public void createReview() {
        onView(withId(R.id.cityedit)).perform(ViewActions.replaceText(city)).check(matches(isDisplayed()));
        onView(withId(R.id.contentedit)).perform(ViewActions.replaceText(content)).check(matches(isDisplayed()));
        onView(withId(R.id.submitreview)).perform(click());


    }


}