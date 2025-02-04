package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.iteco.fmhandroid.ui.elements.News.getNewsButton;
import static ru.iteco.fmhandroid.ui.elements.News.getNewsTitleOnPageNews;
import static ru.iteco.fmhandroid.ui.elements.News.getRefreshButton;
import static ru.iteco.fmhandroid.ui.elements.News.getSortNewsButton;

import io.qameta.allure.kotlin.Allure;

public class NewsSteps {

    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости в Главном меню");
        onView(getNewsButton())
                .perform(click());
    }

    public static void showPanelNews() {
        Allure.step("Отобразилась панель с текстом Новости");
        onView(getNewsTitleOnPageNews())
                .perform(click());
    }

    public static void clickRefreshButton() {
        Allure.step("Нажать на кнопку Обновить новости");
        onView(getRefreshButton())
                .perform(click());
    }

    public static void clickSortingNewsButton() {
        Allure.step("Нажать на кнопку сортировки новостей");
        onView(getSortNewsButton())
                .perform(click());

    }


}
