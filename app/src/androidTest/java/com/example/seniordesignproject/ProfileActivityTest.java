package com.example.seniordesignproject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ProfileActivityTest {

    String name = "Test";
    String address = "Address";
    String email ="test@live.com";


    @Rule
    public ActivityScenarioRule<ProfileActivity> activityTestRule =
            new ActivityScenarioRule<>(ProfileActivity.class);

    @Test
    public void updateProfile() throws InterruptedException {
        onView(withId(R.id.profile_nameedit)).perform(ViewActions.replaceText(name)).check(matches(isDisplayed()));
        onView(withId(R.id.profileaddressedit)).perform(ViewActions.replaceText(address)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_emailedit)).perform(ViewActions.replaceText(email)).check(matches(isDisplayed()));
        Thread.sleep(250);
        onView(withId(R.id.update)).perform(scrollTo(), click());


    }



    @Test
    public void backNavigationToHomeTest() {
        Intents.init();
        onView(withId(R.id.back)).perform(scrollTo(), click());
        intended(hasComponent(HomeActivity.class.getName()));
        Intents.release();


    }

}