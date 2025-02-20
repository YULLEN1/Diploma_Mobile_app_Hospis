package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.resources.Timeout.waitDisplayed;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

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
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Новости\" (News) мобильного приложения \"Мобильный хоспис\".")
public class NewsTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

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
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
        AuthorizationSteps.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "Новости" (News) мобильного приложения "Мобильный хоспис".

    //  TC - 14 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 14")
    @Description(" Переход во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainMenu() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }


    //  TC - 15 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 15")
    @Description("Переход во вкладку Все новости (ALL NEWS) через вкладку Главная страница (Main) мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainPage() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.showButtonAllNews();
        MainSteps.clickButtonAllNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }
}
