package ru.iteco.fmhandroid.ui.util;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    ViewInteraction textAuthorization = onView(
            allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
    ViewInteraction loginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    ViewInteraction passwordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    ViewInteraction buttonEnter = onView(withId(R.id.enter_button));
    ViewInteraction newsText = onView(allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
    ViewInteraction buttonExit = onView(
            withId(R.id.authorization_image_button));
    ViewInteraction buttonLogOut = onView(
            allOf(withId(android.R.id.title), withText("Log out")));
    String rightLogin = "login2";
    String rightPassword = "password2";


    // Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" (Authorization) мобильного приложения "Мобильный хоспис".

    //  TC - 1 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
    @Test
    public void SuccessfulAuthorization() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(rightLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(rightPassword), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        newsText.check(matches(isDisplayed()));
        newsText.check(matches(withText("News")));
        // Выход
        SystemClock.sleep(2000);
        buttonExit.perform(click());
        SystemClock.sleep(2000);
        buttonLogOut.perform(click());
    }

    //  TC - 2 - Поле "Логин" (Login) пустое, при авторизации, в мобильном приложении "Мобильный хоспис".
    @Test
    public void loginFieldIsEmpty() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(""), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(rightPassword), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    // TC - 3 -  Поле "Логин" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void loginFieldUnregisteredUser() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText("login253"), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(rightPassword), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    //  TC - 4 - Поле "Логин" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис".
    @Test
    public void loginFieldWithSpecialCharacters() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText("№;%:?*(!^№;"), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(rightPassword), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    //  Поле "Логин" (Login) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void loginFieldOneLetter() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText("l"), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(rightPassword), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));

    }

    //  TC - 6 -  TC - 6 - Поле "Логин" (Login) состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void loginFieldLettersOfDifferentCase() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText("LoGin2"), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(rightPassword), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    //  TC - 7 -Поле "Пароль" (Password) пустое, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void passwordFieldIsEmpty() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(rightLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText(""), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    //  TC - 8 - Поле "Пароль" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void passwordFieldUnregisteredUser() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(rightLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText("password123"), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    //  TC - 9 - Поле "Пароль" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void passwordFieldWithSpecialCharacters() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(rightLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText("%:;%№*%:?"), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    //  TC - 10 - Поле "Пароль" (Password) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис".
    @Test
    public void passwordFieldOneLetter() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(rightLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText("p"), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    //  TC - 11 - Поле "Пароль" (Password) состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"
    @Test
    public void passwordFieldLettersOfDifferentCase() {
        SystemClock.sleep(5000);
        textAuthorization.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        loginField.perform(replaceText(rightLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
        passwordField.perform(replaceText("PassWord2"), closeSoftKeyboard());
        buttonEnter.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }
}
