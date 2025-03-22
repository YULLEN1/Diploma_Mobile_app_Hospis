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
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryBirthday;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryCelebration;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryGratitude;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryNeedHelp;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategorySalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryUnion;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCustomCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCustomCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCustomCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionBirthday;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionBirthdayEdit;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionDonations;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionGratitude;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionGratitudeDonations;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionNeedHelp;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionSalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionUnion;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getNumbersCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getNumbersCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getNumbersCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleBirthdayEdit;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleCelebration;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleDonations;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleGratitude;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleGratitudeDonations;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleNeedHelp;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleSalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleUnion;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
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
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class AllTests {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    NewsControlPanelSteps newsControlPanelSteps = new NewsControlPanelSteps();
    ThematicQuoteSteps thematicQuoteSteps = new ThematicQuoteSteps();
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        try {
            mainSteps.mainScreenLoad();
        } catch (Exception e) {
            authorizationSteps.fillLoginField(getLogin());
            authorizationSteps.fillPasswordField(getPassword());
            authorizationSteps.clickButtonSignIn();
            mainSteps.mainScreenLoad();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    // Тест-кейсы для проведения функционального тестирования вкладки "Главная" (Main) мобильного приложения "Мобильный хоспис".

    //   TC - 12 - Переход на вкладку "Главная страница" (Main) через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 12")
    @Description("Переход на вкладку \"Главная страница\" (Main) через главное меню мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void Main() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(withText("News")).check(matches(isDisplayed()));
        mainSteps.clickButtonMainMenu();
        mainSteps.clickButtonMain();
        onView(withText("News")).check(matches(isDisplayed()));
    }

    //  ТС - 13 - Свернуть/развернуть вкладку "Новости" (News)  на  вкладке "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 13")
    @Description("Свернуть/развернуть вкладку \"Новости\" (News)  на  вкладке \"Главная страница\" (Main) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void extendNews() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getButtonToExpandNews(), 5000));
        mainSteps.clickButtonToExpandNews();
        mainSteps.clickButtonToExpandNews();
        onView(withId(R.id.all_news_text_view)).check(matches(withText("ALL NEWS")));
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "Новости" (News) мобильного приложения "Мобильный хоспис".

    //  TC - 14 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 14")
    @Description(" Переход во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainMenu() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }


    //  TC - 15 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 15")
    @Description("Переход во вкладку Все новости (ALL NEWS) через вкладку Главная страница (Main) мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainPage() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.showButtonAllNews();
        mainSteps.clickButtonAllNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }

    //  ТC - 19 - Создание активной новости с категорией "Объявление" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 19")
    @Description("Создание активной новости с категорией \"Объявление\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPaneAdvertisement() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionAdvertisement());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Строительство бассейна")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  ТC - 20 - Создание активной новости с категорией "Зарплата" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 20")
    @Description("Создание активной новости с категорией \"Зарплата\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPanelSecondCategory() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategorySalary());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleSalary());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionSalary());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Перечислен аванс")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }


    //  TC - 21 - Поле "Категория" (Category) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 21")
    @Description("Поле Категория (Category) пустое, при создании новости, во вкладке Панель управления (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillTitleCreatingNews(getTitleDonations());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionDonations());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryBirthday());
        newsControlPanelSteps.fillTitleCreatingNews("");
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthday());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategorySalary());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleSalaryEnumerated());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionSalaryEnumerated());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryUnion());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleUnion());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionUnion());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryCelebration());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleCelebration());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews("");
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCustomCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getCustomCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.fillDescriptionCreatingNews(getCustomCategoryDescription());
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getNumbersCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getNumbersCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getNumbersCategoryDescription());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getSpecialCharactersCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getSpecialCharactersCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getSpecialCharactersCategoryDescription());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
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
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryGratitude());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleGratitude());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionGratitude());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("15.04.2026")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  TC - 30 - Ручной ввод времени в поле "Время" (Time), при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 30")
    @Description("TC - 30 - Ручной ввод времени в поле \"Время\" (Time), при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void manualInputTime() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryNeedHelp());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleNeedHelp());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.manualInputTime();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionNeedHelp());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Посещение")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  TC - 32 - Сортировка новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("TC - 32")
    @Description("Сортировка новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void sortingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonSortingNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("19.03.2025")));
    }

    //   TC - 33 - Просмотр новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 33")
    @Description(" TC - 33 - Просмотр новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void watchingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    //  TC - 34 - Удаление активной новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 34")
    @Description("Удаление активной новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void deletingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryGratitude());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleGratitudeDonations());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionGratitudeDonations());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("За пожертвования")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText("За пожертвования"))).check(doesNotExist());
    }

    //  TC - 35 - Редактирование новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 35")
    @Description("Редактирование новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void editingNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryBirthday());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleBirthdayEdit());
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthdayEdit());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Юбилей")));
        pressBack();
    }

    //  TC - 36 - Смена статуса новости, находящейся в статусе "АКТИВНА" (Active), на статус "НЕ АКТИВНА" (Not active), во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 36")
    @Description("Смена статуса новости, находящейся в статусе \"АКТИВНА\" (Active), на статус \"НЕ АКТИВНА\" (Not active), во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void changingStatusNewsControlPanel() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.clickButtonToSwitchStatusNews();
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }


    //  ТC - 52 - Развернуть/свернуть тематическую цитату, во вкладке "Love is all", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 52")
    @Description("Развернуть/свернуть тематическую цитату, во вкладке \"Love is all\", мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void expandThematicQuote() {
        onView(isRoot()).perform(waitDisplayed(thematicQuoteSteps.getMissionImageButton(), 5000));
        thematicQuoteSteps.clickButtonThematicQuote();
        thematicQuoteSteps.checkTitleThematicQuote();
        thematicQuoteSteps.clickButtonToExpandThematicQuote();
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(isDisplayed()));
    }
}
