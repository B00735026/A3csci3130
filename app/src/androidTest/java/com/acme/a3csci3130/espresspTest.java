package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

public class espresspTest {
@Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void test1CheckRulues() throws Exception{
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Test"));
        onView(withId(R.id.email)).perform(typeText("Test1234@gmail.com"));
        onView(withId(R.id.bussiness_num)).perform(typeText("123456789"));
        onView(withId(R.id.province)).perform(typeText("MB"),closeSoftKeyboard());
        onView(withId(R.id.primary_business)).perform(typeText("Distributor"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("133North street A12Jh3"),closeSoftKeyboard());
        Thread.sleep(500);
        onView(withId(R.id.submitButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        Thread.sleep(500);
        onView(withId(R.id.deleteButton)).perform(click());
        }

}
