package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AboutPage;

public class AboutSteps {
    AboutPage aboutPage = new AboutPage();

    public void clickButtonAboutMainMenu() {
        Allure.step("Нажать кнопку О приложении (About) в Главном меню");
        aboutPage.getABoutElementButtonAbout
                .perform(click());
    }

    public void clickButtonPrivacyPolicy() {
        Allure.step(" Нажать на ссылку Политика конфиденциальности (Privacy policy).");
        aboutPage.getABoutElementButtonPrivacyPolicy
                .perform(click());
    }

    public void clickButtonTermsOfUse() {
        Allure.step("Нажать на ссылку Пользовательское соглашение (Terms of use).");
        aboutPage.getABoutElementButtonTermsOfUse
                .perform(click());
    }

    public void clickButtonPressBack() {
        Allure.step("Нажать на ссылку Пользовательское соглашение (Terms of use).");
        aboutPage.getPressBackButton.
                perform(click());
    }


}

