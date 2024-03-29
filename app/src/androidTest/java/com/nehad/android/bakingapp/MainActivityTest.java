package com.nehad.android.bakingapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction recyclerView = onView(allOf(withId(R.id.recyclerView_recipeList), childAtPosition(withId(R.id.swipe_rv_con), 0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction view = onView(allOf(withId(R.id.click_area_ingredients), childAtPosition(childAtPosition(withId(R.id.card_header), 0), 8), isDisplayed()));
        view.perform(click());

        ViewInteraction view2 = onView(allOf(withId(R.id.click_area_steps), childAtPosition(childAtPosition(withId(R.id.card_header), 0), 13), isDisplayed()));
        view2.perform(click());

        ViewInteraction floatingActionButton = onView(allOf(withId(R.id.fab), childAtPosition(childAtPosition(withId(R.id.card_header), 0), 4), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatCheckBox = onView(allOf(withText("2 cup Graham Cracker crumbs"), childAtPosition(allOf(withId(R.id.ingredientsLayout), childAtPosition(withClassName(is("android.widget.LinearLayout")), 1)), 0), isDisplayed()));
        appCompatCheckBox.perform(click());
    }

    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
