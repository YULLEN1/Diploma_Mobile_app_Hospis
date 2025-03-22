package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

public class NewsPage {

    public ViewInteraction getNewsButton;

    public NewsPage() {
        getNewsButton = onView(allOf(withId(android.R.id.title), withText("News")));
    }

}