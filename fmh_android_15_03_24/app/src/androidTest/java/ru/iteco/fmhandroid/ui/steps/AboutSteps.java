package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.iteco.fmhandroid.ui.elements.About.getABoutElementButtonAbout;
import static ru.iteco.fmhandroid.ui.elements.About.getABoutElementButtonPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.elements.About.getABoutElementButtonTermsOfUse;

import io.qameta.allure.kotlin.Allure;

public class AboutSteps {

    public static void clickButtonAboutMainMenu() {
        Allure.step("Нажать кнопку О приложении (About) в Главном меню");
        onView(getABoutElementButtonAbout())
                .perform(click());
    }

    public static void clickButtonPrivacyPolicy() {
        Allure.step(" Нажать на ссылку Политика конфиденциальности (Privacy policy).");
        onView(getABoutElementButtonPrivacyPolicy())
                .perform(click());
    }

    public static void clickButtonTermsOfUse() {
        Allure.step("Нажать на ссылку Пользовательское соглашение (Terms of use).");
        onView(getABoutElementButtonTermsOfUse())
                .perform(click());
    }


}

