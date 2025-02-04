package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static ru.iteco.fmhandroid.ui.util.NewsTest.withIndex;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.Authorization;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования Панели Управления Новостей (Control panel) мобильного приложения Мобильный хоспис")
public class NewsControlPanelTest {

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
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonSignIn();
    }

    @After
    public void Exit() {
        SystemClock.sleep(5000);
        AuthorizationSteps.clickButtonExit();
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonLogOut();
    }


    //  ТC - 19 - Создание активной новости с категорией "Объявление" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 19")
    @Description("Создание активной новости во вкладке Панели управления новостей (Control panel) в мобильном приложении Мобильный хоспис (Позитивный).")
    public void creationNewsInControlPanelAdvertisement() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Объявление");
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("Объявлен сбор");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Строительство бассейна");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(ViewAssertions.matches(isDisplayed()));
    }

    //  ТC - 20 - Создание активной новости с категорией "Зарплата" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 20")
    @Description("Создание активной новости с категорией \"Зарплата\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPanelSalary() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Зарплата");
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("Начислен аванс");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Перечислен аванс");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(ViewAssertions.matches(isDisplayed()));
        pressBack();
    }



    //  TC - 21 - Поле "Категория" (Category) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 21")
    @Description("Поле Категория (Category) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("Пожертвования");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Собираются пожертвования");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(Matchers.allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }
    //  TC - 22 - Поле "Заголовок" (Title) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 22")
    @Description("Поле Заголовок (Title) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("День рождения");
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Петр Иванов");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(Matchers.allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    // TC - 23 - Поле "Дата публикации" (Publication date) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 23")
    @Description("Поле \"Дата публикации\" (Publication date) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный)")
    public void  fieldDateEmptyCreationNewsInControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("Зарплата");
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("Начисление зарплаты");
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Зарплата перчислена");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(Matchers.allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }
    //  ТC - 24 - Поле "Время" (Time) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 24")
    @Description("Поле \"Время\" (Time) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный)")
    public void fieldTimeEmptyCreationNewsInControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("Профсоюз");
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("Расписание собраний");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Первое собрание");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(Matchers.allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }
    //  ТC - 25 - Поле "Описание" (Description) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 25")
    @Description("Поле \"Описание\" (Description) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("Праздник");
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillTitleCreatingNews("С Новым годом");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillDescriptionCreatingNews("");
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(Matchers.allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }
    //  ТC - 26 - Ввод в поле "Категория" (Category) собственного названия категории, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 26")
    @Description("Ввод в поле Категория (Category) собственного названия категории, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void  customCategoryName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("Пожертвования");
        NewsControlPanelSteps.fillTitleCreatingNews("Объявлен сбор");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillDescriptionCreatingNews("На модернизацию корпуса");
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  ТC - 27 - Поле "Категория" (Category) состоит из цифр, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 27")
    @Description("Поле \"Категория\" (Category) состоит из цифр, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void  fieldCategoryConsistsOfNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("123456");
        NewsControlPanelSteps.fillTitleCreatingNews("Объявление");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Собрание профсоюза");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }
    //  ТC - 28 - Поле "Категория" (Category) состоит из спецсимволов, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 28")
    @Description("Поле \"Категория\" (Category) состоит из спецсимволов, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void  fieldCategoryConsistsOfSpecialCharacters() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("%:?*;№%:?");
        NewsControlPanelSteps.fillTitleCreatingNews("Открытие корпуса");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Корпус построен");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  ТC - 29 - Поле "Дата публикации" (Publication date) состоит из даты будущего года, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 29")
    @Description("Поле \"Дата публикации\" (Publication date) состоит из даты будущего года, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void  fieldDateConsistsOfNextYearDate() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("Благодарность");
        NewsControlPanelSteps.fillTitleCreatingNews("Юлии Ивановой");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("За заслуги");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(ViewAssertions.matches(isDisplayed()));;
        pressBack();
    }

    //  TC - 30 - Ручной ввод времени в поле "Время" (Time), при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 30")
    @Description("TC - 30 - Ручной ввод времени в поле \"Время\" (Time), при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void  manualInputTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.fillInNewsCategoryField("Нужна помощь");
        NewsControlPanelSteps.fillTitleCreatingNews("Пациентам");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.manualInputTime();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Сбор");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(ViewAssertions.matches(isDisplayed()));;
        pressBack();
    }

    //  TC - 32 - Сортировка новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 32")
    @Description("Сортировка новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void  sortingNewsControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonSortingNews();
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //   TC - 33 - Просмотр новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 33")
    @Description(" TC - 33 - Просмотр новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void  watchingNewsControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    //  TC - 34 - Удаление активной новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 34")
    @Description("Удаление активной новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void deletingNewsControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }








}
