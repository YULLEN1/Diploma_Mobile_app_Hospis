package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.elements.Main.getMainElementsButtonAllNews;
import static ru.iteco.fmhandroid.ui.elements.Main.getMainElementsButtonMain;
import static ru.iteco.fmhandroid.ui.elements.Main.getMainElementsButtonMainMenu;
import static ru.iteco.fmhandroid.ui.elements.Main.getMainElementsButtonToRollUpAllNews;
import static ru.iteco.fmhandroid.ui.elements.Main.getMainElementsTitleNews;

import io.qameta.allure.kotlin.Allure;

public class MainSteps {

    public static void clickButtonAllNews() {
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        onView(getMainElementsButtonAllNews())
                .perform(click());
    }

    public static void showButtonAllNews() {
        Allure.step("Отобразилась кнопка ВСЕ НОВОСТИ");
        onView(getMainElementsButtonAllNews())
                .check(matches(withText("ALL NEWS")));
    }

    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главного меню");
        onView(getMainElementsButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonMain() {
        Allure.step("Нажать на кнопку Главная в Главном меню");
        onView(getMainElementsButtonMain())
                .perform(click());
    }

    public static void clickButtonToExpandNews() {
        Allure.step("Нажать на кнопку Свернуть/развернуть ВСЕ НОВОСТИ на Главной странице");
        onView(getMainElementsButtonToRollUpAllNews())
                .perform(click());
    }

    public static void allNewsExpanded() {
        Allure.step("Содержание вкладки - кнопка Все Новости  (All NEWS) - свернулось");
        onView(getMainElementsButtonAllNews())
                .check(matches(isNotEnabled()));
    }

    public static void allNewsUnexpanded() {
        Allure.step(" Отобразилось содержание вкладки - кнопка Все новости (ALL NEWS)");
        onView(getMainElementsButtonAllNews())
                .check(matches(isDisplayed()));
    }

    public static void showTitleNewsOnMain() {
        Allure.step(" Отобразилась панель Новости (News)");
        onView(getMainElementsTitleNews())
                .check(matches(isDisplayed()));

    }
}