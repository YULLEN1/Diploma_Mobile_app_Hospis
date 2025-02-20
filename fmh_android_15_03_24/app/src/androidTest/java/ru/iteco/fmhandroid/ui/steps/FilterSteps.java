package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementButtonCancelFilter;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementButtonOKWrongPeriod;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementButtonToFilterNews;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementButtonToFilterNewsPanel;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementCheckboxActive;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementCheckboxNotActive;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementEndDateFilter;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementFieldCategoryFilter;
import static ru.iteco.fmhandroid.ui.elements.FilterControlPanel.getFilterElementStartDateFilter;

import io.qameta.allure.kotlin.Allure;

public class FilterSteps {

    public static void clickButtonToFilterNewsPanel() {
        Allure.step("Нажать на кнопку Фильтровать Новости (Filter News)");
        onView(getFilterElementButtonToFilterNewsPanel())
                .perform(click());
    }

    public static void clickCheckboxNotActiveToFilterNews() {
        Allure.step("Нажать чекбокс НЕ АКТИВНАЯ (NOT ACTIVE) в фильтре новостей");
        onView(getFilterElementCheckboxNotActive())
                .perform(click());
    }

    public static void clickButtonToFilterNews() {
        Allure.step("Нажать на кнопку Фильтровать (FILTER).");
        onView(getFilterElementButtonToFilterNews())
                .perform(click());

    }

    public static void clickCheckboxActiveToFilterNews() {
        Allure.step("Нажать чекбокс АКТИВНАЯ (ACTIVE) в фильтре новостей");
        onView(getFilterElementCheckboxActive())
                .perform(click());
    }

    public static void fillCategoryFilterNews(String text) {
        Allure.step("Заполнить поле Категория в Фильтре новостей");
        onView(getFilterElementFieldCategoryFilter())
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public static void fillStartDateFilterNews(String text) {
        Allure.step("Заполнить начальную дату в Фильтре новостей");
        onView(getFilterElementStartDateFilter())
                .perform(replaceText(text));
    }

    public static void fillEndDateFilterNews(String text) {
        Allure.step("Заполнить конечную дату в Фильтре новостей");
        onView(getFilterElementEndDateFilter())
                .perform(replaceText(text));
    }

    public static void clickOKWrongPeriodFilterNews() {
        Allure.step("Нажать ОК в cообщении Неправильный период (Wrong period)");
        onView(getFilterElementButtonOKWrongPeriod())
                .perform(click());
    }

    public static void clickCancelFilterNews() {
        Allure.step("Нажать кнопку Отменить (Cancel) в Фильтре новостей");
        onView(getFilterElementButtonCancelFilter())
                .perform(click());
    }
}
