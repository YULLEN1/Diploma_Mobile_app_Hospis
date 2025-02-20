package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.elements.Authorization.getAuthorizationElementsButton;
import static ru.iteco.fmhandroid.ui.elements.Authorization.getAuthorizationElementsButtonExit;
import static ru.iteco.fmhandroid.ui.elements.Authorization.getAuthorizationElementsButtonLogOut;
import static ru.iteco.fmhandroid.ui.elements.Authorization.getAuthorizationElementsLoginField;
import static ru.iteco.fmhandroid.ui.elements.Authorization.getAuthorizationElementsPasswordField;
import static ru.iteco.fmhandroid.ui.elements.Authorization.getAuthorizationElementsTextAuthorization;

import io.qameta.allure.kotlin.Allure;

public class AuthorizationSteps {

    public static void clickButtonSignIn() {
        Allure.step("Нажать на кнопку Войти");
        onView(getAuthorizationElementsButton())
                .perform(click());
    }

    public static void clickButtonExit() {
        Allure.step("Нажать на кнопку Выход");
        onView(getAuthorizationElementsButtonExit())
                .perform(click());
    }

    public static void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        onView(getAuthorizationElementsButtonLogOut())
                .perform(click());
    }

    public static void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        onView(getAuthorizationElementsTextAuthorization())
                .check(matches(isDisplayed()));
    }

    public static void fillLoginField(String text) {
        Allure.step("Поле Логин - ввод данных + text");
        onView(getAuthorizationElementsLoginField()).perform(replaceText(text));
    }

    public static void fillPasswordField(String text) {
        Allure.step("Поле Пароль - ввод данных + text");
        onView(getAuthorizationElementsPasswordField()).perform(replaceText(text));
    }
}
