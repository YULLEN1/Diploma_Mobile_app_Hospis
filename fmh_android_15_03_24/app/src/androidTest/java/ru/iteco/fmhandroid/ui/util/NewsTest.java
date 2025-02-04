package ru.iteco.fmhandroid.ui.util;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;


import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
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

public class NewsTest extends TestCase{

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    ViewInteraction textAuthorization = onView(
            allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
    ViewInteraction loginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    ViewInteraction passwordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    ViewInteraction buttonEnter = onView(withId(R.id.enter_button));
    ViewInteraction newsText = onView(allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
    ViewInteraction buttonExit = onView(
            withId(R.id.authorization_image_button));
    ViewInteraction buttonLogOut = onView(
            allOf(withId(android.R.id.title), withText("Log out")));
    String rightLogin = "login2";
    String rightPassword = "password2";
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
    ViewInteraction buttonRefresh = onView(
            allOf(withId(R.id.news_retry_material_button), withText("Refresh")));
    ViewInteraction buttonSorting = onView(
            allOf(withId(R.id.sort_news_material_button), withContentDescription("Sort news list button")));
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
        SystemClock.sleep(1000);
        buttonAllNews.check(matches(isNotEnabled()));
        SystemClock.sleep(3000);
       // buttonToExpandNews.perform(click());
        //buttonAllNews.check(matches(isDisplayed()));
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
        categoryText.perform(replaceText("Объявление"));
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Объявлен сбор"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Строительство бассейна"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(isDisplayed()));
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
        categoryText.perform(replaceText("Зарплата"));
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Начислен аванс"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(click());
        buttonOkDateCreatingNews.perform(click());
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("Перечислен аванс"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(withText("Пациентам")));
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
        categoryText.perform(replaceText("День рождения"));
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
        categoryText.perform(replaceText("Зарплата"));
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
        categoryText.perform(replaceText("Профсоюз"));
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
        categoryText.perform(replaceText("Праздник"));
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
        categoryText.perform(replaceText("Пожертвования"));
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
        categoryText.perform(replaceText("123456"));
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
        categoryText.perform(replaceText("%:?*;№%:?"));
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
        categoryText.perform(replaceText("Благодарность"));
        SystemClock.sleep(1000);
        fieldCreatingTitle.perform(click(), clearText(), replaceText("Юлии Ивановой"), closeSoftKeyboard());
        buttonDateCreatingNews.perform(replaceText(nextYear));
        buttonTimeCreatingNews.perform(click());
        SystemClock.sleep(1000);
        buttonOkTimeCreatingNews.perform(click());
        fieldDescription.perform(replaceText("За заслуги"), closeSoftKeyboard());
        buttonSaveCreatingNews.perform(scrollTo(), click());
        SystemClock.sleep(1000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(withText("Юлии Ивановой")));
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
        categoryText.perform(replaceText("Нужна помощь"));
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
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(withText("Пациентам")));

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
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
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
        SystemClock.sleep(1000);
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
        SystemClock.sleep(1000);
        buttonClickNews.perform(click());
        buttonDeleteNews.perform(click());
        buttonOkDeleteNews.perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

}


