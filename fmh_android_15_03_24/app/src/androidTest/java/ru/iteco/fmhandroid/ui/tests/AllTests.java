package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.resources.Timeout.waitDisplayed;
import static ru.iteco.fmhandroid.ui.util.NewsTest.withIndex;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Flaky;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.ThematicQuoteSteps;


@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)
public class AllTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        activityRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Before
    public void Authorization() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.fillLoginField("login2");
        AuthorizationSteps.fillPasswordField("password2");
        AuthorizationSteps.clickButtonSignIn();
    }

    @After
    public void Exit() {
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        AuthorizationSteps.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();
    }

    //   TC - 12 - Переход на вкладку "Главная страница" (Main) через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 12")
    @Description("Переход на вкладку \"Главная страница\" (Main) через главное меню мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void Main() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        onView(withText("News")).check(matches(isDisplayed()));
        MainSteps.clickButtonMainMenu();
        MainSteps.clickButtonMain();
        onView(withText("News")).check(matches(isDisplayed()));
    }

    //  ТС - 13 - Свернуть/развернуть вкладку "Новости" (News)  на  вкладке "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 13")
    @Description("Свернуть/развернуть вкладку \"Новости\" (News)  на  вкладке \"Главная страница\" (Main) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void extendNews() {
        onView(isRoot()).perform(waitDisplayed(R.id.expand_material_button, 5000));
        MainSteps.clickButtonToExpandNews();
        MainSteps.clickButtonToExpandNews();
        onView(withId(R.id.all_news_text_view)).check(matches(withText("ALL NEWS")));
    }


    //  TC - 14 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 14")
    @Description(" Переход во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainMenu() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }


    //  TC - 15 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 15")
    @Description("Переход во вкладку Все новости (ALL NEWS) через вкладку Главная страница (Main) мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainPage() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.showButtonAllNews();
        MainSteps.clickButtonAllNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }

    //  ТC - 19 - Создание активной новости с категорией "Объявление" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 19")
    @Description("Создание активной новости с категорией \"Объявление\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPanelAdvertisement() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Объявление");
        NewsControlPanelSteps.fillTitleCreatingNews("Объявлен сбор");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Строительство бассейна");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Строительство бассейна")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  ТC - 20 - Создание активной новости с категорией "Зарплата" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 20")
    @Description("Создание активной новости с категорией \"Зарплата\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPanelSalary() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Зарплата");
        NewsControlPanelSteps.fillTitleCreatingNews("Начислен аванс");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Перечислен аванс");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Перечислен аванс")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }


    //  TC - 21 - Поле "Категория" (Category) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 21")
    @Description("Поле Категория (Category) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillTitleCreatingNews("Пожертвования");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Собираются пожертвования");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  TC - 22 - Поле "Заголовок" (Title) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 22")
    @Description("Поле Заголовок (Title) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("День рождения");
        NewsControlPanelSteps.fillTitleCreatingNews("");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Петр Иванов");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    // TC - 23 - Поле "Дата публикации" (Publication date) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 23")
    @Description("Поле \"Дата публикации\" (Publication date) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Зарплата");
        NewsControlPanelSteps.fillTitleCreatingNews("Начисление зарплаты");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Зарплата перечислена");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  ТC - 24 - Поле "Время" (Time) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 24")
    @Description("Поле \"Время\" (Time) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный)")
    public void fieldTimeEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Профсоюз");
        NewsControlPanelSteps.fillTitleCreatingNews("Расписание собраний");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Первое собрание");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  ТC - 25 - Поле "Описание" (Description) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 25")
    @Description("Поле \"Описание\" (Description) пустое, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Праздник");
        NewsControlPanelSteps.fillTitleCreatingNews("С Новым годом");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.fillDescriptionCreatingNews("");
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  ТC - 26 - Ввод в поле "Категория" (Category) собственного названия категории, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 26")
    @Description("Ввод в поле Категория (Category) собственного названия категории, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void customCategoryName() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Пожертвования");
        NewsControlPanelSteps.fillTitleCreatingNews("Объявлен сбор");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.fillDescriptionCreatingNews("На модернизацию корпуса");
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  ТC - 27 - Поле "Категория" (Category) состоит из цифр, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 27")
    @Description("Поле \"Категория\" (Category) состоит из цифр, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldCategoryConsistsOfNumbers() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("123456");
        NewsControlPanelSteps.fillTitleCreatingNews("Объявление");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Собрание профсоюза");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  ТC - 28 - Поле "Категория" (Category) состоит из спецсимволов, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 28")
    @Description("Поле \"Категория\" (Category) состоит из спецсимволов, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("%:?*;№%:?");
        NewsControlPanelSteps.fillTitleCreatingNews("Открытие корпуса");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Корпус построен");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
        pressBack();
    }

    //  ТC - 29 - Поле "Дата публикации" (Publication date) состоит из даты будущего года, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 29")
    @Description("Поле \"Дата публикации\" (Publication date) состоит из даты будущего года, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void fieldDateConsistsOfNextYearDate() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Благодарность");
        NewsControlPanelSteps.fillTitleCreatingNews("Юлии Ивановой");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("За заслуги");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("15.04.2026")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  TC - 30 - Ручной ввод времени в поле "Время" (Time), при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 30")
    @Description("TC - 30 - Ручной ввод времени в поле \"Время\" (Time), при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void manualInputTime() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Нужна помощь");
        NewsControlPanelSteps.fillTitleCreatingNews("Пациентам");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.manualInputTime();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Посещение");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Посещение")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  TC - 32 - Сортировка новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("TC - 32")
    @Description("Сортировка новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void sortingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonSortingNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("24.02.2025")));
    }

    //   TC - 33 - Просмотр новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 33")
    @Description(" TC - 33 - Просмотр новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void watchingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    //  TC - 34 - Удаление активной новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 34")
    @Description("Удаление активной новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void deletingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Благодарность");
        NewsControlPanelSteps.fillTitleCreatingNews("Ивану Сидорову");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("За пожертвования");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("За пожертвования")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText("За пожертвования"))).check(doesNotExist());
    }

    //  TC - 35 - Редактирование новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 35")
    @Description("Редактирование новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void editingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonToEditNews();
        NewsControlPanelSteps.fillInNewsCategoryField("День рождения");
        NewsControlPanelSteps.fillTitleCreatingNews("Петр Иванов");
        NewsControlPanelSteps.fillDescriptionCreatingNews("Юбилей");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Юбилей")));
        pressBack();
    }

    //  TC - 36 - Смена статуса новости, находящейся в статусе "АКТИВНА" (Active), на статус "НЕ АКТИВНА" (Not active), во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 36")
    @Description("Смена статуса новости, находящейся в статусе \"АКТИВНА\" (Active), на статус \"НЕ АКТИВНА\" (Not active), во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void changingStatusNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonToEditNews();
        NewsControlPanelSteps.clickButtonToSwitchStatusNews();
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  ТC - 52 - Развернуть/свернуть тематическую цитату, во вкладке "Love is all", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 52")
    @Description("Развернуть/свернуть тематическую цитату, во вкладке \"Love is all\", мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void expandThematicQuote() {
        onView(isRoot()).perform(waitDisplayed(R.id.our_mission_image_button, 5000));
        ThematicQuoteSteps.clickButtonThematicQuote();
        ThematicQuoteSteps.checkTitleThematicQuote();
        ThematicQuoteSteps.clickButtonToExpandThematicQuote();
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(isDisplayed()));
    }
}
