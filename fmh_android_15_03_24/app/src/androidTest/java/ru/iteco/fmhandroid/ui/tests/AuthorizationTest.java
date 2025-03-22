package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getDifferentRegexLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getDifferentRegexPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLoginWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getOneLetterLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getOneLetterPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPasswordWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getUnregisteredLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getUnregisteredPassword;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
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

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Авторизация\" мобильного приложения \"Мобильный хоспис\".")
public class AuthorizationTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.loadAuthorizationPage();
        } catch (
                Exception e) {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
            authorizationSteps.loadAuthorizationPage();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
        } catch (Exception ignored) {
        }
    }

// Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" (Authorization) мобильного приложения "Мобильный хоспис".

    //  TC - 1 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 1")
    @Description("Авторизация в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void successfulAuthorization() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        mainSteps.showTitleNewsOnMain();
        authorizationSteps.clickButtonExit();
        authorizationSteps.clickButtonLogOut();
    }


    //  TC - 2 - Поле "Логин" (Login) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 2")
    @Description("Поле \"Логин\" (Login) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldIsEmpty() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField("");
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 3 -  Поле "Логин" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 3")
    @Description("Поле \"Логин\" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldUnregisteredUser() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUnregisteredLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 4 - Поле "Логин" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 4")
    @Description("Поле \"Логин\" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldWithSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLoginWithSpecialCharacters());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  Поле "Логин" (Login) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 5")
    @Description("Поле \"Логин\" (Login) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldOneLetter() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getOneLetterLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 6 - Поле "Логин" (Login) состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 6")
    @Description("Поле \"Логин\" (Login) состоит из букв разного регистра, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldLettersOfDifferentCase() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getDifferentRegexLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 7 -Поле "Пароль" (Password) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 7")
    @Description("Поле \"Пароль\" (Password) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void passwordFieldIsEmpty() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField("");
        authorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 8 - Поле "Пароль" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 8")
    @Description("Поле \"Пароль\" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void passwordFieldUnregisteredUser() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getUnregisteredPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 9 - Поле "Пароль" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 9")
    @Description("Поле \"Пароль\" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void passwordFieldWithSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPasswordWithSpecialCharacters());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 10 - Поле "Пароль" (Password) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 10")
    @Description("Поле \"Пароль\" (Password) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный)")
    public void passwordFieldOneLetter() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getOneLetterPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 11 - Поле "Пароль" (Password) состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 11")
    @Description("Поле \"Пароль\" (Password) состоит из букв разного регистра, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный). ")
    public void passwordFieldLettersOfDifferentCase() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getDifferentRegexPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
}
