package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class About {


    public static Matcher<View> getABoutElementButtonAbout() {
        return allOf(withId(android.R.id.title), withText("About"));
    }

    public static Matcher<View> getABoutElementButtonPrivacyPolicy() {
        return withId(R.id.about_privacy_policy_value_text_view);
    }

    public static Matcher<View> getABoutElementButtonTermsOfUse() {
        return withId(R.id.about_terms_of_use_value_text_view);
    }
}
