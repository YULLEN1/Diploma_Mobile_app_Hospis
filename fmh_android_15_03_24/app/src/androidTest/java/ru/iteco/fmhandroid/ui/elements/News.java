package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class News {
    public static Matcher<View> getNewsButton() {
       return allOf(withId(android.R.id.title), withText("News"));
    }

    public static Matcher<View> getNewsTitleOnPageNews() {
        return  allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))));
    }

    public static Matcher<View> getRefreshButton() {
        return withId(R.id.news_retry_material_button);
    }

    public static Matcher<View> getSortNewsButton() {
        return withId(R.id.sort_news_material_button);
    }

    }