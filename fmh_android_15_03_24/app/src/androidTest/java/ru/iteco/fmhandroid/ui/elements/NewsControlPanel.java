package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.util.NewsTest.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;


public class NewsControlPanel extends NewsControlPanelSteps {

    public static Matcher<View> getNewsControlPanelElementsButtonControlPanel() {
        return withId(R.id.edit_news_material_button);
    }

    public static Matcher<View> getNewsControlPanelElementsAddNews() {
        return withId(R.id.add_news_image_view);
    }


    public static Matcher<View> getNewsControlPanelElementsButtonTitleCreatingNews() {
        return withId(R.id.news_item_title_text_input_edit_text);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonDateCreatingNews() {
        return withId(R.id.news_item_publish_date_text_input_edit_text);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkDateCreatingNews() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonTimeCreatingNews() {
        return withId(R.id.news_item_publish_time_text_input_edit_text);
    }

    public static Matcher<View> getNewsControlPanelElementsDescriptionCreatingNews() {
        return withId(R.id.news_item_description_text_input_edit_text);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkTimeCreatingNews() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSaveCreatingNews() {
        return withId(R.id.save_button);
    }

    public static Matcher<View> getNewsControlPanelElementsCategoryText() {
        return withId(R.id.news_item_category_text_auto_complete_text_view);
    }

    public static Matcher<View> getNewsControlPanelElementsInputTime() {
        return allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to text input mode for the time input."));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSortingControlPanel() {
        return withId(R.id.sort_news_material_button);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonToExpandNews() {
        return withIndex(withId(R.id.news_item_material_card_view), 0);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonToDeleteNews() {
        return withIndex(withId(R.id.delete_news_item_image_view), 0);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonToOkDeleteNews() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonToEditNews() {
        return withIndex(withId(R.id.edit_news_item_image_view), 0);
    }

    public static Matcher<View> getNewsControlPanelElementsButtonToSwitchStatusNews() {
        return withId(R.id.switcher);
    }


}


