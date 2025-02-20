package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.resources.Timeout.waitDisplayed;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
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
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Авторизация\" мобильного приложения \"Мобильный хоспис\".")
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        activityRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

// Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" (Authorization) мобильного приложения "Мобильный хоспис".

    //  TC - 1 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 1")
    @Description("Авторизация в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void successfulAuthorization() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        MainSteps.showTitleNewsOnMain();
        AuthorizationSteps.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();
    }


    //  TC - 2 - Поле "Логин" (Login) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 2")
    @Description("Поле \"Логин\" (Login) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldIsEmpty() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 3 -  Поле "Логин" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 3")
    @Description("Поле \"Логин\" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldUnregisteredUser() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login235");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 4 - Поле "Логин" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 4")
    @Description("Поле \"Логин\" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldWithSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("№;%:?*(!№");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  Поле "Логин" (Login) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 5")
    @Description("Поле \"Логин\" (Login) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldOneLetter() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("l");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 6 - Поле "Логин" (Login) состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 6")
    @Description("Поле \"Логин\" (Login) состоит из букв разного регистра, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginFieldLettersOfDifferentCase() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("LoGin2");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 7 -Поле "Пароль" (Password) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 7")
    @Description("Поле \"Пароль\" (Password) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void passwordFieldIsEmpty() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 8 - Поле "Пароль" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 8")
    @Description("Поле \"Пароль\" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void passwordFieldUnregisteredUser() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("password123");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 9 - Поле "Пароль" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 9")
    @Description("Поле \"Пароль\" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void passwordFieldWithSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("%:;%№*%:?");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 10 - Поле "Пароль" (Password) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 10")
    @Description("Поле \"Пароль\" (Password) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный)")
    public void passwordFieldOneLetter() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("p");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  TC - 11 - Поле "Пароль" (Password) состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 11")
    @Description("Поле \"Пароль\" (Password) состоит из букв разного регистра, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный). ")
    public void passwordFieldLettersOfDifferentCase() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("PassWord2");
        AuthorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
}
