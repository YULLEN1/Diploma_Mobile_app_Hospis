package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsAddNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonControlPanel;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonSortingControlPanel;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonToDeleteNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonToEditNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonToExpandNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonToOkDeleteNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsButtonToSwitchStatusNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsCategoryText;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanel.getNewsControlPanelElementsInputTime;

import io.qameta.allure.kotlin.Allure;

public class NewsControlPanelSteps {
    public static void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        onView(getNewsControlPanelElementsButtonControlPanel())
                .perform(click());
    }

    public static void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        onView(getNewsControlPanelElementsAddNews())
                .perform(click());
    }


    public static void fillTitleCreatingNews(String text) {
        Allure.step("Ввести в поле Заголовок заголовок новости");
        onView(getNewsControlPanelElementsButtonTitleCreatingNews())
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews() {
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonOkDateCreatingNews() {
        Allure.step("Нажать кнопку ОК Дата");
        onView(getNewsControlPanelElementsButtonOkDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews() {
        Allure.step("В поле Время выбрать время");
        onView(getNewsControlPanelElementsButtonTimeCreatingNews())
                .perform(click());
    }

    public static void clickButtonOkTimeCreatingNews() {
        Allure.step("Нажать кнопку ОК Время");
        onView(getNewsControlPanelElementsButtonOkTimeCreatingNews())
                .perform(click());
    }

    public static void fillDescriptionCreatingNews(String text) {
        Allure.step("Ввести в поле Описание описание новости");
        onView(getNewsControlPanelElementsDescriptionCreatingNews())
                .perform(replaceText(text), closeSoftKeyboard());
    }

    public static void clickButtonSaveCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        onView(getNewsControlPanelElementsButtonSaveCreatingNews())
                .perform(scrollTo(), click());
    }


    public static void fillInNewsCategoryField(String text) {
        Allure.step("Поле категория - ввод данных");
        onView(getNewsControlPanelElementsCategoryText()).perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    static String nextYear = "15.04.2026";

    public static void clickButtonDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(replaceText(nextYear));
    }

    public static void manualInputTime() {
        Allure.step("Вручную ввести время публикации новости");
        onView(getNewsControlPanelElementsInputTime())
                .perform(click());
    }

    public static void clickButtonSortingNews() {
        Allure.step("Нажать кнопку Сортировать новости в Панели управления");
        onView(getNewsControlPanelElementsButtonSortingControlPanel())
                .perform(click());
    }

    public static void clickButtonToExpandNews() {
        Allure.step("Нажать кнопку Развернуть новость в Панели управления");
        onView(getNewsControlPanelElementsButtonToExpandNews())
                .perform(click());
    }

    public static void clickButtonToDeleteNews() {
        Allure.step("Нажать кнопку Удалить новость в Панели управления");
        onView(getNewsControlPanelElementsButtonToDeleteNews())
                .perform(click());
    }

    public static void clickButtonToOkDeleteNews() {
        Allure.step("Нажать кнопку ОК Удалить новость в Панели управления");
        onView(getNewsControlPanelElementsButtonToOkDeleteNews())
                .perform(click());
    }

    public static void clickButtonToEditNews() {
        Allure.step("Нажать кнопку Редактировать новость в Панели управления");
        onView(getNewsControlPanelElementsButtonToEditNews())
                .perform(click());
    }

    public static void clickButtonToSwitchStatusNews() {
        Allure.step("Сменить статус Активная на статус Не активна (передвинуть рычажок).");
        onView(getNewsControlPanelElementsButtonToSwitchStatusNews())
                .perform(click());
    }


}
