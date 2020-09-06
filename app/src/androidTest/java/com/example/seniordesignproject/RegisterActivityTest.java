package com.example.seniordesignproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.TypeTextAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
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
public class RegisterActivityTest {

    String name = "Test";
    String address = "Address";
    String email = "test@uiadjakd.com";
    String password = "asd123ASD#$";



    @Rule
    public ActivityScenarioRule<RegisterActivity> activityTestRule =
            new ActivityScenarioRule<>(RegisterActivity.class);



    @Test
    public void registerTest()  {
       onView(withId(R.id.name_rinput_edit)).perform(ViewActions.replaceText(name)).check(matches(isDisplayed()));
        onView(withId(R.id.address_rinput_edit)).perform(ViewActions.replaceText(address)).check(matches(isDisplayed()));
         onView(withId(R.id.email_rinputedit)).perform(ViewActions.replaceText(email)).check(matches(isDisplayed()));
      onView(withId(R.id.pasword_rinputedit)).perform(ViewActions.replaceText(password)).check(matches(isDisplayed()));
       onView(withId(R.id.register_confirm)).perform(click());


    }


}