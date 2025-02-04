package ru.iteco.fmhandroid.ui.tests;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Главная (Main) мобильного приложения Мобильный хоспис")
public class MainTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            AuthorizationSteps.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("password2");
        SystemClock.sleep(1000);
        AuthorizationSteps.clickButtonSignIn();
    }

    @After
    public void Exit () {
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonExit();
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonLogOut();
    }

// Тест-кейсы для проведения функционального тестирования вкладки "Главная" (Main) мобильного приложения "Мобильный хоспис".

    //   TC - 12 - Переход на вкладку "Главная страница" (Main) через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 12")
    @Description("Переход на вкладку Главная страница (Main) через главное меню мобильного приложения Мобильный хоспис (Позитивный)")
    public void Main (){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonNews();
        NewsSteps.showPanelNews();
        SystemClock.sleep(2000);
        MainSteps.clickButtonMainMenu();
        MainSteps.clickButtonMain();
        SystemClock.sleep(2000);
        MainSteps.showTitleNewsOnMain();
    }

    //  ТС - 13 - Свернуть/развернуть вкладку "Новости" (News)  на  вкладке "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 13")
    @Description("Свернуть/развернуть вкладку Новости (News)  на  вкладке Главная страница (Main) мобильного приложения Мобильный хоспис (Позитивный).")
    public void extendNews(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SystemClock.sleep(2000);
        MainSteps.clickButtonToExpandNews();
        MainSteps.allNewsUnexpanded();

        MainSteps.clickButtonToExpandNews();
        MainSteps.allNewsExpanded();
    }
}