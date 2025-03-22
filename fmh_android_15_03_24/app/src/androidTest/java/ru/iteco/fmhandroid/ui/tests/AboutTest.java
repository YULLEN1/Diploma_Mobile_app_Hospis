package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;

import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\".")
public class AboutTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AboutSteps aboutSteps = new AboutSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainSteps.mainScreenLoad();
        } catch (Exception e) {
            authorizationSteps.fillLoginField(getLogin());
            authorizationSteps.fillPasswordField(getPassword());
            authorizationSteps.clickButtonSignIn();
            mainSteps.mainScreenLoad();
        }
    }

    @After
    public void tearDown() {
        aboutSteps.clickButtonPressBack();
    }


    //  TC - 53 - Просмотр ссылки "Политика конфиденциальности" (Privacy policy) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 53")
    @Description("Просмотр ссылки \"Политика конфиденциальности\" (Privacy policy) во вкладке \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void watchingPrivacyPolicy() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonPrivacyPolicy();
        intended(hasData("https://vhospice.org/#/privacy-policy/")); // Проверка Intent
        intended(hasAction(Intent.ACTION_VIEW));
    }

    //  TC - 54 - Просмотр ссылки "Пользовательское соглашение"  (Terms of use) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 53")
    @Description("Просмотр ссылки \"Пользовательское соглашение\"  (Terms of use) во вкладке \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void watchingTermsOfUse() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonTermsOfUse();
        intended(hasData("https://vhospice.org/#/terms-of-use")); // Проверка Intent
        intended(hasAction(Intent.ACTION_VIEW));
    }
}
