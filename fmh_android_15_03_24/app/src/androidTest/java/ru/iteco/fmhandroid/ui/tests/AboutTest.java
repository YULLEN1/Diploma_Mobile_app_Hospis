package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.resources.Timeout.waitDisplayed;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\".")
public class AboutTest {
    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(AppActivity.class);

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


    //  TC - 53 - Просмотр ссылки "Политика конфиденциальности" (Privacy policy) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 53")
    @Description("Просмотр ссылки \"Политика конфиденциальности\" (Privacy policy) во вкладке \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void watchingPrivacyPolicy() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAboutMainMenu();
        AboutSteps.clickButtonPrivacyPolicy();
        intended(hasData("https://vhospice.org/#/privacy-policy/")); // Проверка Intent
        intended(hasAction(Intent.ACTION_VIEW));
        pressBack();
    }

    //  TC - 54 - Просмотр ссылки "Пользовательское соглашение"  (Terms of use) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 53")
    @Description("Просмотр ссылки \"Пользовательское соглашение\"  (Terms of use) во вкладке \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void watchingTermsOfUse() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAboutMainMenu();
        AboutSteps.clickButtonTermsOfUse();
        intended(hasData("https://vhospice.org/#/terms-of-use")); // Проверка Intent
        intended(hasAction(Intent.ACTION_VIEW));
        pressBack();
    }
}
