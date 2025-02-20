package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.elements.ThematicQuote.getQuoteElementButtonThematicQuote;
import static ru.iteco.fmhandroid.ui.elements.ThematicQuote.getQuoteElementButtonToExpandThematicQuote;
import static ru.iteco.fmhandroid.ui.elements.ThematicQuote.getQuoteElementTitleThematicQuote;

import io.qameta.allure.kotlin.Allure;

public class ThematicQuoteSteps {
    public static void clickButtonThematicQuote() {
        Allure.step("На главной странице экрана приложения нажать на кнопку Бабочка (Тематические цитаты).");
        onView(getQuoteElementButtonThematicQuote())
                .perform(click());
    }

    public static void checkTitleThematicQuote() {
        Allure.step("Проверить заголовок Love is all на вкладке Тематические цитаты.");
        onView(getQuoteElementTitleThematicQuote())
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public static void clickButtonToExpandThematicQuote() {
        Allure.step("Нажать на кнопку развернуть тематическую цитату.");
        onView(getQuoteElementButtonToExpandThematicQuote())
                .perform(click());
    }
}
