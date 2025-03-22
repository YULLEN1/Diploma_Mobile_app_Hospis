package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ThematicQuotePage {

    public ViewInteraction getQuoteElementButtonThematicQuote;
    public ViewInteraction getQuoteElementTitleThematicQuote;
    public ViewInteraction getQuoteElementButtonToExpandThematicQuote;
    public int missionImageButton;


    public ThematicQuotePage() {

        getQuoteElementButtonThematicQuote = onView(withId(R.id.our_mission_image_button));
        getQuoteElementTitleThematicQuote = onView(withId(R.id.our_mission_title_text_view));
        getQuoteElementButtonToExpandThematicQuote = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
        missionImageButton = R.id.our_mission_image_button;

    }
}