package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    public void mainScreenLoad() {
        Allure.step("Загрузка страницы");
        onView(isRoot()).perform(waitDisplayed(mainPage.allNews, 5000));
    }

    public void clickButtonAllNews() {
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        mainPage.getMainElementsButtonAllNews
                .perform(click());
    }

    public void showButtonAllNews() {
        Allure.step("Отобразилась кнопка ВСЕ НОВОСТИ");
        mainPage.getMainElementsButtonAllNews
                .check(matches(withText("ALL NEWS")));
    }

    public void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главного меню");
        mainPage.getMainElementsButtonMainMenu
                .perform(click());
    }

    public void clickButtonMain() {
        Allure.step("Нажать на кнопку Главная в Главном меню");
        mainPage.getMainElementsButtonMain
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step("Нажать на кнопку Свернуть/развернуть ВСЕ НОВОСТИ на Главной странице");
        mainPage.getMainElementsButtonToRollUpAllNews
                .perform(click());
    }


    public void showTitleNewsOnMain() {
        Allure.step(" Отобразилась панель Новости (News)");
        mainPage.getMainElementsTitleNews
                .check(matches(isDisplayed()));

    }

    public int getMainMenuButton() {
        return mainPage.mainMenuButton;
    }

    public int getButtonToExpandNews() {
        return mainPage.buttonToExpandNews;
    }
}