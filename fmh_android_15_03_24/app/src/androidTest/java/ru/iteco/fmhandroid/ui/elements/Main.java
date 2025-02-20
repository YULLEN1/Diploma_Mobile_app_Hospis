package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

public class Main extends MainSteps {

    public static Matcher<View> getMainElementsButtonMainMenu() {
        return withId(R.id.main_menu_image_button);
    }

    public static Matcher<View> getMainElementsButtonMain() {
        return allOf(withId(android.R.id.title), withText("Main"));
    }


    public static Matcher<View> getMainElementsButtonToRollUpAllNews() {
        return withId(R.id.expand_material_button);
    }

    public static Matcher<View> getMainElementsTitleNews() {
        return allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main))));
    }

    public static Matcher<View> getMainElementsButtonAllNews() {
        return allOf(withId(R.id.all_news_text_view), withText("ALL NEWS"));
    }

}
