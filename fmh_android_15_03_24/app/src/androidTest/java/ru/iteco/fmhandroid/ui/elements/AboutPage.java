package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    public ViewInteraction getABoutElementButtonAbout;
    public ViewInteraction getABoutElementButtonPrivacyPolicy;
    public ViewInteraction getABoutElementButtonTermsOfUse;
    public ViewInteraction getPressBackButton;

    public AboutPage() {
        getABoutElementButtonAbout = onView(allOf(withId(android.R.id.title), withText("About")));

        getABoutElementButtonPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));

        getABoutElementButtonTermsOfUse = onView(withId(R.id.about_terms_of_use_value_text_view));
        getPressBackButton = onView(withContentDescription("Navigate up"));
    }
}
