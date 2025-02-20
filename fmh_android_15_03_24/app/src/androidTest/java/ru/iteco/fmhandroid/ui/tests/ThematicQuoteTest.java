package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.resources.Timeout.waitDisplayed;
import static ru.iteco.fmhandroid.ui.util.NewsTest.withIndex;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ThematicQuoteSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Тематические цитаты\" мобильного приложения \"Мобильный хоспис\".")
public class ThematicQuoteTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void Authorization() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
    }

    @After
    public void Exit() {
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        AuthorizationSteps.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();
    }

    //  ТC - 52 - Развернуть/свернуть тематическую цитату, во вкладке "Love is all", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 52")
    @Description("Развернуть/свернуть тематическую цитату, во вкладке \"Love is all\", мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void expandThematicQuote() {
        onView(isRoot()).perform(waitDisplayed(R.id.our_mission_image_button, 5000));
        ThematicQuoteSteps.clickButtonThematicQuote();
        ThematicQuoteSteps.checkTitleThematicQuote();
        ThematicQuoteSteps.clickButtonToExpandThematicQuote();
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(isDisplayed()));
    }
}

