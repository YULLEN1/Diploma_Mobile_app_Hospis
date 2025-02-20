package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.util.NewsTest.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class ThematicQuote {

    public static Matcher<View> getQuoteElementButtonThematicQuote() {
        return withId(R.id.our_mission_image_button);
    }

    public static Matcher<View> getQuoteElementTitleThematicQuote() {
        return withId(R.id.our_mission_title_text_view);
    }

    public static Matcher<View> getQuoteElementButtonToExpandThematicQuote() {
        return withIndex(withId(R.id.our_mission_item_open_card_image_button), 0);
    }
}
