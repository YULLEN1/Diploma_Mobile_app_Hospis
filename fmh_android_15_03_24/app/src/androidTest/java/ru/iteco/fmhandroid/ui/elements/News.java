package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

public class News {
    public static Matcher<View> getNewsButton() {
        return allOf(withId(android.R.id.title), withText("News"));
    }

}