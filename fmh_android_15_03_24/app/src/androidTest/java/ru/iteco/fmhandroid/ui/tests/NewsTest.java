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
import ru.iteco.fmhandroid.ui.elements.Authorization;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
    @RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

    @Epic("Тест-кейсы для проведения функционального тестирования вкладки Новости мобильного приложения Мобильный хоспис")
    public class NewsTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Authorization.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        Authorization.textAuthorization();
        Authorization.fillLoginField("login2");
        Authorization.fillPasswordField("password2");
        SystemClock.sleep(1000);
        AuthorizationSteps.clickButtonSignIn();
    }

    @After
    public void Exit() {
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonExit();
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonLogOut();
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "Новости" (News) мобильного приложения "Мобильный хоспис".

    //  TC - 14 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 14")
    @Description(" Переход во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainMenu() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.showPanelNews();
    }


    //  TC - 15 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 15")
    @Description("Переход во вкладку Все новости (ALL NEWS) через вкладку Главная страница (Main) мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        MainSteps.clickButtonMain();
        SystemClock.sleep(2000);
        MainSteps.showButtonAllNews();
        MainSteps.clickButtonAllNews();
        SystemClock.sleep(2000);
        NewsSteps.showPanelNews();
    }

    //  TC - 16 - Просмотр новостей на вкладке "Все новости" (ALL NEWS) мобильного приложения "Мобильный хоспис" (Позитивный).
    //  @Test
//    @Story("TC - 16")
//    @Description("Просмотр новостей на вкладке \"Все новости\" (ALL NEWS) мобильного приложения \"Мобильный хоспис\".")
//    public void viewingNewsOnPageNews() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        MainSteps.clickButtonMainMenu();
//        NewsSteps.clickButtonNews();
//        SystemClock.sleep(2000);
//        NewsSteps.showPanelNews();
//    }


    //TC - 17 -  Сортировка новостей во вкладке "Все новости" (ALL NEWS) мобильного приложения "Мобильный хоспис". (Позитивный).
    @Test
    @Story("TC - 17")
    @Description("Сортировка новостей во вкладке \"Все новости\" (ALL NEWS) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void newsSorting() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.showPanelNews();
        NewsSteps.clickSortingNewsButton();
        //onView(withId(R.id.news_list_swipe_refresh)).check(Pattern.matches(isDisplayed()));
        //Как проверить результат?


    }
}
