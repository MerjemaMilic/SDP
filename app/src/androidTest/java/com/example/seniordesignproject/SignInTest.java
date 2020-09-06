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
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SignInTest {

    String email = "merjema.milic@gmail.com";
    String password = "asd123#ASD";


    @Rule
    public ActivityScenarioRule<SignIn> activityTestRule = new ActivityScenarioRule<>(SignIn.class);


    @Test
    public void loginFormSuccess() {
       onView(allOf(withId(R.id.email_rinput), withHint("E-mail")));
        onView(allOf(withId(R.id.password_input), withHint("Password")));
        onView(allOf(withId(R.id.login_button), withText("Sign in")));


    }

    @Test
    public void forgotPassword() {
        onView(withId(R.id.forgotpassword));



    }


}
