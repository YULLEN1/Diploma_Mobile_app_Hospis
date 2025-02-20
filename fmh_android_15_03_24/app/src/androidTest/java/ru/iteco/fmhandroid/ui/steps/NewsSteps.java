package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.iteco.fmhandroid.ui.elements.News.getNewsButton;

import io.qameta.allure.kotlin.Allure;

public class NewsSteps {

    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости в Главном меню");
        onView(getNewsButton())
                .perform(click());
    }
}
