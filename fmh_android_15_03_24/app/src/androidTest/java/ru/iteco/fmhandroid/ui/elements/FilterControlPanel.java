package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class FilterControlPanel {

    public static Matcher<View> getFilterElementButtonToFilterNewsPanel() {
        return withId(R.id.filter_news_material_button);
    }

    public static Matcher<View> getFilterElementCheckboxNotActive() {
        return withId(R.id.filter_news_inactive_material_check_box);
    }

    public static Matcher<View> getFilterElementButtonToFilterNews() {
        return allOf(withId(R.id.filter_button), withText("Filter"));
    }

    public static Matcher<View> getFilterElementCheckboxActive() {
        return withId(R.id.filter_news_active_material_check_box);
    }

    public static Matcher<View> getFilterElementFieldCategoryFilter() {
        return withId(R.id.news_item_category_text_auto_complete_text_view);
    }

    public static Matcher<View> getFilterElementStartDateFilter() {
        return withId(R.id.news_item_publish_date_start_text_input_edit_text);
    }

    public static Matcher<View> getFilterElementEndDateFilter() {
        return withId(R.id.news_item_publish_date_end_text_input_edit_text);
    }

    public static Matcher<View> getFilterElementButtonOKWrongPeriod() {
        return withId(android.R.id.button1);
    }

    public static Matcher<View> getFilterElementButtonCancelFilter() {
        return withId(R.id.cancel_button);
    }


}
