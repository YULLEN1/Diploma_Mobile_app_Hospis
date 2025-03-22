package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.differentRegexLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.differentRegexPassword;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.loginWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.oneLetterLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.oneLetterPassword;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.passwordWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.rightLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.rightPassword;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.unregisteredLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.unregisteredPassword;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AuthorizationPage;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    public void loadAuthorizationPage() {
        Allure.step("Загрузка страницы авторизации");
        onView(isRoot()).perform(waitDisplayed((authorizationPage.enterButton), 5000));
    }

    public void clickButtonSignIn() {
        Allure.step("Нажать на кнопку Войти");
        authorizationPage.getAuthorizationElementsButton
                .perform(click());
    }

    public void clickButtonExit() {
        Allure.step("Нажать на кнопку Выход");
        authorizationPage.getAuthorizationElementsButtonExit
                .perform(click());
    }

    public void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        authorizationPage.getAuthorizationElementsButtonLogOut
                .perform(click());
    }

    public void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        authorizationPage.getAuthorizationElementsTextAuthorization
                .check(matches(isDisplayed()));
    }

    public void fillLoginField(String text) {
        Allure.step("Поле Логин - ввод данных" + text);
        authorizationPage.getAuthorizationElementsLoginField.perform(replaceText(text));
    }

    public void fillPasswordField(String text) {
        Allure.step("Поле Пароль - ввод данных" + text);
        authorizationPage.getAuthorizationElementsPasswordField.perform(replaceText(text));
    }

    public static String getLogin() {
        return rightLogin;
    }

    public static String getPassword() {
        return rightPassword;
    }

    public static String getUnregisteredLogin() {
        return unregisteredLogin;
    }

    public static String getLoginWithSpecialCharacters() {
        return loginWithSpecialCharacters;
    }

    public static String getOneLetterLogin() {
        return oneLetterLogin;
    }

    public static String getDifferentRegexLogin() {
        return differentRegexLogin;
    }

    public static String getUnregisteredPassword() {
        return unregisteredPassword;
    }

    public static String getPasswordWithSpecialCharacters() {
        return passwordWithSpecialCharacters;
    }

    public static String getOneLetterPassword() {
        return oneLetterPassword;
    }

    public static String getDifferentRegexPassword() {
        return differentRegexPassword;
    }

    public int getLoginLayout() {
        return authorizationPage.loginLayout;
    }


}
