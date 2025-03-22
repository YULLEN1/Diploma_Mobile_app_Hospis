package ru.iteco.fmhandroid.ui.util;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import android.content.Intent;
import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

public class NewsTest extends TestCase {

    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(AppActivity.class);


    ViewInteraction loginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    ViewInteraction passwordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    ViewInteraction buttonEnter = onView(withId(R.id.enter_button));
    ViewInteraction newsText = onView(allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
    ViewInteraction buttonExit = onView(
            withId(R.id.authorization_image_button));
    ViewInteraction buttonLogOut = onView(
            allOf(withId(android.R.id.title), withText("Log out")));
    ViewInteraction buttonMainMenu = onView(
            allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu")));
    ViewInteraction buttonMain = onView(
            allOf(withId(android.R.id.title), withText("Main")));
    ViewInteraction buttonNews = onView(
            allOf(withId(android.R.id.title), withText("News")));
    ViewInteraction panelNews = onView(allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include)))));
    ViewInteraction buttonAllNews = onView(
            allOf(withId(R.id.all_news_text_view), withText("ALL NEWS")));
    ViewInteraction buttonToExpandNews = onView(
            withId(R.id.expand_material_button));
    ViewInteraction buttonControlPanel = onView(
            withId(R.id.edit_news_material_button));
    ViewInteraction buttonAddNews = onView(
            allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button")));
    ViewInteraction categoryText = onView(
            withId(R.id.news_item_category_text_auto_complete_text_view));
    ViewInteraction fieldCreatingTitle = onView(
            withId(R.id.news_item_title_text_input_edit_text));
    ViewInteraction buttonDateCreatingNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    ViewInteraction buttonOkDateCreatingNews = onView(
            allOf(withId(android.R.id.button1), withText("OK")));
    ViewInteraction buttonTimeCreatingNews = onView(
            withId(R.id.news_item_publish_time_text_input_edit_text));
    ViewInteraction buttonOkTimeCreatingNews = onView(
            allOf(withId(android.R.id.button1), withText("OK")));
    ViewInteraction fieldDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    ViewInteraction buttonSaveCreatingNews = onView(
            allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save")));
    ViewInteraction manualInputTime = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to text input mode for the time input.")));
    ViewInteraction buttonSortingControlPanel = onView(withId(R.id.sort_news_material_button));
    ViewInteraction buttonClickNews = onView(
            withIndex(withId(R.id.news_item_material_card_view), 0));
    ViewInteraction buttonDeleteNews = onView(
            withIndex(withId(R.id.delete_news_item_image_view), 0));
    ViewInteraction buttonOkDeleteNews = onView(
            withId(android.R.id.button1));
    ViewInteraction buttonEditNews = onView(
            withIndex(withId(R.id.edit_news_item_image_view), 0));
    ViewInteraction buttonSwitcher = onView(
            withId(R.id.switcher));
    ViewInteraction buttonFilterNewsPanel = onView(
            withId(R.id.filter_news_material_button));
    ViewInteraction fieldCategoryFilter = onView(
            withId(R.id.news_item_category_text_auto_complete_text_view));
    ViewInteraction buttonFilter = onView(
            withId(R.id.filter_button));
    ViewInteraction inActiveCheckBox = onView(
            allOf(withId(R.id.filter_news_inactive_material_check_box), withText("Not active")));
    ViewInteraction activeCheckBox = onView(
            withId(R.id.filter_news_active_material_check_box));
    ViewInteraction buttonThematicQuote = onView(
            withId(R.id.our_mission_image_button));
    ViewInteraction buttonExpandThematicQuote = onView(
            withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    ViewInteraction titleThematicQuote = onView(
            withId(R.id.our_mission_title_text_view));
    ViewInteraction buttonAbout = onView(
            allOf(withId(android.R.id.title), withText("About")));
    ViewInteraction buttonPrivacyPolicy = onView(
            withId(R.id.about_privacy_policy_value_text_view));
    ViewInteraction buttonTermsOfUse = onView(
            withId(R.id.about_terms_of_use_value_text_view));
    ViewInteraction startDateFilter = onView(
            withId(R.id.news_item_publish_date_start_text_input_edit_text));
    ViewInteraction endDateFilter = onView(
            withId(R.id.news_item_publish_date_end_text_input_edit_text));
    ViewInteraction buttonOKWrongPeriod = onView(withId(android.R.id.button1));
    ViewInteraction buttonCancelFilter = onView(
            withId(R.id.cancel_button));

    @Before
    public void login() {
        SystemClock.sleep(5000);
        loginField.perform(replaceText("login2"), closeSoftKeyboard());
        passwordField.perform(replaceText("password2"), closeSoftKeyboard());
        buttonEnter.perform(click());
    }

    @After
    public void logOut() {
        SystemClock.sleep(4000);
        buttonExit.perform(click());
        SystemClock.sleep(4000);
        buttonLogOut.perform(click());
    }

    // Тест-кейсы для проведения функционального тестирования вкладки "Главная страница" (Main) мобильного приложения "Мобильный хоспис".

    //  TC - 12 - Переход на вкладку "Главная страница" (Main) через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void testOpenMain() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.check(matches(isDisplayed()));
        buttonNews.perform(click());
        panelNews.check(matches(isDisplayed()));
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonMain.check(matches(isDisplayed()));
        buttonMain.perform(click());
        SystemClock.sleep(1000);
        newsText.check(matches(isDisplayed()));
    }

    // ТС - 12 - Свернуть/развернуть вкладку "Новости" (News)  на  вкладке "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testExpandAllNews() {
        SystemClock.sleep(5000);
        buttonToExpandNews.check(matches(isDisplayed()));
        buttonToExpandNews.perform(click());
        buttonToExpandNews.perform(click());
        onView(withId(R.id.all_news_text_view)).check(matches(withText("ALL NEWS")));
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "Новости" (News) мобильного приложения "Мобильный хоспис".

    //  ТС - 14 - Переход во вкладку "Все новости" (ALL NEWS) через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void testShowAllNewsThroughMainMenu() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.check(matches(isDisplayed()));
        buttonNews.perform(click());
        SystemClock.sleep(1000);
        panelNews.check(matches(isDisplayed()));

    }

    //  ТС - 15 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный)
    @Test
    public void testShowAllNewsThroughMainPage() {
        SystemClock.sleep(5000);
        newsText.check(matches(isDisplayed()));
        buttonAllNews.check(matches(isDisplayed()));
        buttonAllNews.perform(click());
        SystemClock.sleep(1000);
        panelNews.check(matches(isDisplayed()));

    }

    //  ТС - 19 - Создание активной новости с категорией "Объявление" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис".

    @Test
    public void testCreationNewsInControlPanelAdvertisement() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Объявление"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Объявлен сбор"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Строительство бассейна"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Строительство бассейна")));
    }

    // ТС - 20 - Создание активной новости с категорией "Зарплата" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис".

    @Test
    public void testCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Зарплата"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Начислен аванс"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Перечислен аванс"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Перечислен аванс")));
    }

    //  TC - 21 - Поле "Категория" (Category) (Category) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldCategoryEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(replaceText("Пожертвования"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Собираются пожертвования"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 22 - Поле "Заголовок" (Title) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldTitleEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("День рождения"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(replaceText(""), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Петр Иванов"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    // TC - 23 - Поле "Дата публикации" (Publication date) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldDateEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Зарплата"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Начисление зарплаты"), closeSoftKeyboard());
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Зарплата перечислена"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 24 - Поле "Время" (Time) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldTimeEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Профсоюз"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Расписание собраний"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkDateCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Первое собрание"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 25 - Поле "Описание" (Description) пустое, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldDescriptionEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Праздник"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("С Новым годом!"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 26 - Ввод в поле "Категория" (Category) собственного названия категории, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testCustomCategoryName() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Пожертвования"), closeSoftKeyboard());
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Объявлен сбор"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("На модернизацию корпуса"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  TC - 27 - Поле "Категория" (Category) состоит из цифр, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldCategoryConsistsOfNumbers() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonAddNews.perform(click());
        categoryText.perform(click(), clearText(), replaceText("123456"), closeSoftKeyboard());
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Объявлен сбор"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("На модернизацию корпуса"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  TC - 28 - Поле "Категория" (Category) состоит из спецсимволов, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldCategoryConsistsOfSpecialCharacters() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonAddNews.perform(click());
        categoryText.perform(click(), clearText(), replaceText("%:?*;№%:?"), closeSoftKeyboard());
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Открытие корпуса"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Корпус построен"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    String nextYear = "15.04.2026";

    //  TC - 29 - Поле "Дата публикации" (Publication date) состоит из даты будущего года, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFieldDateConsistsOfNextYearCreatingNews() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Благодарность"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Юлии Ивановой"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("За заслуги"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText(nextYear)));
    }

    //  TC - 30 - Ручной ввод времени в поле "Время" (Time), при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testManualInputTimeCreatingNews() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Нужна помощь"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Пациентам"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        manualInputTime.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Сбор"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Сбор")));

    }

    //  TC - 32 - Сортировка новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис"
    @Test
    public void testSortingNewsControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonSortingControlPanel.perform(click());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("06.02.2025")));
    }

    //  TC - 33 - Просмотр новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testLookingForNewsControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    //  TC - 34 - Удаление активной новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testDeletingNewsControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Благодарность"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Ивану Сидорову"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("За пожертвования"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("За пожертвования")));
        SystemClock.sleep(5000);
        buttonDeleteNews.perform(click());
        buttonOkDeleteNews.perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.news_item_title_text_view), withText("Ивану Сидорову"))).check(doesNotExist());
    }

    //  TC - 35 - Редактирование новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testEditingNewsControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonEditNews.perform(click());
        categoryText.perform(click(), clearText(), replaceText("Профсоюз"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Расписание собраний"), closeSoftKeyboard());
        fieldDescription.perform(replaceText("Первое собрание"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(2000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Первое собрание")));
    }

    //  TC - 36 - Смена статуса новости, находящаяся в статусе "АКТИВНА" (Active) на статус "НЕ АКТИВНА" (Not active), во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testChangingStatusNewsControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonEditNews.perform(click());
        buttonSwitcher.perform(click());
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        buttonSaveCreatingNews.perform(scrollTo(), click());
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        buttonDeleteNews.perform(click());
        buttonOkDeleteNews.perform(click());
    }

    //  TC - 37 - Фильтрация новостей по категории "Обьвление", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsAdvertisementControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Объявление"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Концерт"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Хор Турецкого"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Хор Турецкого")));
        SystemClock.sleep(5000);
        SystemClock.sleep(10000);
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Праздник"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("8 марта"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText("22.04.2026"));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Поздравляем"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        onView(
                withIndex(withId(R.id.news_item_material_card_view), 0)).perform(doubleClick());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Поздравляем")));
        SystemClock.sleep(5000);
        buttonFilterNewsPanel.perform(click());
        fieldCategoryFilter.perform(click(), clearText(), replaceText("Объявление"), closeSoftKeyboard());
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Хор Турецкого")));
    }

    //  TC - 38 - Фильтрация новостей по категории "День рождения", во вкладке "Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsBirthdayControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("День рождения"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Аркадия Ступницкого"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Поздравляем"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Поздравляем")));
        SystemClock.sleep(5000);
        SystemClock.sleep(10000);
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Профсоюз"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Расписание собраний"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText("22.04.2026"));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Второе собрание"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        onView(
                withIndex(withId(R.id.news_item_material_card_view), 0)).perform(doubleClick());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Второе собрание")));
        SystemClock.sleep(5000);
        buttonFilterNewsPanel.perform(click());
        fieldCategoryFilter.perform(click(), clearText(), replaceText("День рождения"), closeSoftKeyboard());
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Поздравляем")));
    }

    //  TC - 45 - Фильтрация новостей без указания категории, во вкладке "Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsWithoutCategoryControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Нужна помощь"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Перевозка"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Лежачих больных"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Лежачих больных")));
        buttonFilterNewsPanel.perform(click());
        SystemClock.sleep(2000);
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Лежачих больных")));
        buttonDeleteNews.perform(click());
        buttonOkDeleteNews.perform(click());
    }

    //  TC - 46 - Поле "Категория" (Category) состоит из  букв латинского алфавита и цифр, при фильтрации новостей, во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFilteringNewsCategoryLatinAndNumberControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonAddNews.perform(click());
        SystemClock.sleep(1000);
        categoryText.perform(click(), clearText(), replaceText("Благодарность"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Олесе Кузяковой"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Работник месяца"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        buttonClickNews.perform(doubleClick());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Работник месяца")));
        buttonFilterNewsPanel.perform(click());
        fieldCategoryFilter.perform(click(), clearText(), replaceText("Ret123dsa"), closeSoftKeyboard());
        SystemClock.sleep(2000);
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Работник месяца")));
        buttonDeleteNews.perform(click());
        buttonOkDeleteNews.perform(click());
    }

    //  TC - 47 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке"Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsDatesControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonFilterNewsPanel.perform(click());
        startDateFilter.perform(replaceText("01.02.2025"));
        endDateFilter.perform(replaceText("31.03.2025"));
        SystemClock.sleep(2000);
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("16.03.2025")));
    }

    //  TC - 48 - Фильтрация новостей, без указания категории, при вводе одной даты - начальной, во вкладке"Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFilteringNewsStartDateControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonFilterNewsPanel.perform(click());
        startDateFilter.perform(replaceText("01.02.2025"));
        SystemClock.sleep(2000);
        buttonFilter.perform(click());
        onView((withId(android.R.id.message))).check(matches(withText("Wrong period")));
        buttonOKWrongPeriod.perform(click());
        buttonCancelFilter.perform(click());
    }

    //  TC - 49 - Фильтрация новостей, без указания категории, при вводе одной даты - конечной, во вкладке"Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void testFilteringNewsEndDateControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        buttonFilterNewsPanel.perform(click());
        SystemClock.sleep(2000);
        endDateFilter.perform(replaceText("31.03.2025"));
        buttonFilter.perform(click());
        onView((withId(android.R.id.message))).check(matches(withText("Wrong period")));
        buttonOKWrongPeriod.perform(click());
        buttonCancelFilter.perform(click());
    }

    //  ТС - 50 - Фильтрация новостей по критерию "Активна", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsStatusActiveControlPanel() {
        SystemClock.sleep(10000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonFilterNewsPanel.perform(click());
        inActiveCheckBox.perform(click());
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("ACTIVE")));

    }

    //  ТС - 51 - Фильтрация новостей по критерию "Не активна", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsStatusNotActiveControlPanel() {
        SystemClock.sleep(5000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonNews.perform(click());
        buttonControlPanel.perform(click());
        SystemClock.sleep(1000);
        buttonEditNews.perform(click());
        buttonSwitcher.perform(click());
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        buttonSaveCreatingNews.perform(scrollTo(), click());
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        buttonFilterNewsPanel.perform(click());
        activeCheckBox.perform(click());
        buttonFilter.perform(click());
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        buttonDeleteNews.perform(click());
        buttonOkDeleteNews.perform(click());
    }

    //  TC - 51 - Развернуть/свернуть тематическую цитату, во вкладке "Главное - жить любя", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void expandThematicQuote() {
        SystemClock.sleep(5000);
        buttonThematicQuote.check(matches(isDisplayed()));
        buttonThematicQuote.perform(click());
        SystemClock.sleep(1000);
        titleThematicQuote.check(matches(allOf(withText("Love is all"), isDisplayed())));
        buttonExpandThematicQuote.perform(click());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    //  TC - 53 - Просмотр ссылки "Политика конфиденциальности" (Privacy policy) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testWatchingPrivacyPolicy() {
        SystemClock.sleep(6000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonAbout.perform(click());
        buttonPrivacyPolicy.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/")); // Проверка Intent
        intended(hasAction(Intent.ACTION_VIEW));
        SystemClock.sleep(1000);
        //Выход
        pressBack();
    }

    //  TC - 54 - Просмотр ссылки "Пользовательское соглашение"  (Terms of use) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testWatchingTermsOfUse() {
        SystemClock.sleep(6000);
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());
        buttonAbout.perform(click());
        buttonTermsOfUse.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use")); // Проверка Intent
        intended(hasAction(Intent.ACTION_VIEW));
        SystemClock.sleep(1000);
        //Выход
        pressBack();
    }


}


