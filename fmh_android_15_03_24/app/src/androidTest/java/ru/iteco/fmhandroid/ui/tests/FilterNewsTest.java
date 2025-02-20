package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.resources.Timeout.waitDisplayed;
import static ru.iteco.fmhandroid.ui.util.NewsTest.withIndex;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Flaky;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования \"Фильтра новостей\" \"Панели управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\".")
public class FilterNewsTest {
    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

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

    //  TC - 37 - Фильтрация новостей по категории "Обьвление", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("TC - 37")
    @Description("//  TC - 37 - Фильтрация новостей по категории \"Обьвление\", во вкладке \"Панель управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void filteringNewsCategoryAdvertisementControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Объявление");
        NewsControlPanelSteps.fillTitleCreatingNews("Концерт");
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Хор Турецкого");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Хор Турецкого")));
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Праздник");
        NewsControlPanelSteps.fillTitleCreatingNews("8 марта");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Поздравляем");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Поздравляем")));
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.fillCategoryFilterNews("Объявление");
        FilterSteps.clickButtonToFilterNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Хор Турецкого")));
    }

    // TC - 45 - Фильтрация новостей без указания категории, во вкладке "Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("TC - 45")
    @Description("TC - 45 - Фильтрация новостей без указания категории, во вкладке \"Панель управления\" (Control panel) новостей  мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void filteringNewsWithoutCategoryControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 10000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Нужна помощь");
        NewsControlPanelSteps.fillTitleCreatingNews("Перевозка");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Лежачих больных");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Лежачих больных")));
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.clickButtonToFilterNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Лежачих больных")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  TC - 46 - Поле "Категория" (Category) состоит из  букв латинского алфавита и цифр, при фильтрации новостей, во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 46")
    @Description("Поле \"Категория\" (Category) состоит из  букв латинского алфавита и цифр, при фильтрации новостей, во вкладке \"Панель управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void filteringNewsCategoryLatinAndNumberControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 10000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.fillInNewsCategoryField("Благодарность");
        NewsControlPanelSteps.fillTitleCreatingNews("Олесе Кузяковой");
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.fillDescriptionCreatingNews("Работник месяца");
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonToExpandNews();
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 10000));
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Работник месяца")));
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.fillCategoryFilterNews("Ret123dsa");
        FilterSteps.clickButtonToFilterNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Работник месяца")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }

    //  TC - 47 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке"Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("TC - 47")
    @Description("Фильтрация новостей, без указания категории, в определенный период времени, во вкладке\"Панель управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void filteringNewsDatesControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 10000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.fillStartDateFilterNews("01.02.2025");
        FilterSteps.fillEndDateFilterNews("31.03.2025");
        FilterSteps.clickButtonToFilterNews();
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("20.02.2025")));
    }

    //  TC - 48 - Фильтрация новостей, без указания категории, при вводе одной даты - начальной, во вкладке"Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 48")
    @Description("Фильтрация новостей, без указания категории, при вводе одной даты - начальной, во вкладке\"Панель управления\" (Control panel) новостей  мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void filteringNewsOnlyStartDateControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 10000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.fillStartDateFilterNews("01.02.2025");
        FilterSteps.clickButtonToFilterNews();
        onView((withId(android.R.id.message))).check(matches(withText("Wrong period")));
        FilterSteps.clickOKWrongPeriodFilterNews();
        FilterSteps.clickCancelFilterNews();
    }

    //  TC - 49 - Фильтрация новостей, без указания категории, при вводе одной даты - конечной, во вкладке"Панель управления" (Control panel) новостей  мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 49")
    @Description("Фильтрация новостей, без указания категории, при вводе одной даты - конечной, во вкладке\"Панель управления\" (Control panel) новостей  мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void filteringNewsOnlyEndDateControlPanel() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 10000));
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.fillEndDateFilterNews("31.03.2025");
        FilterSteps.clickButtonToFilterNews();
        onView((withId(android.R.id.message))).check(matches(withText("Wrong period")));
        FilterSteps.clickOKWrongPeriodFilterNews();
        FilterSteps.clickCancelFilterNews();
    }

    //  ТС - 50 - Фильтрация новостей по критерию "Активна", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 50")
    @Description("Фильтрация новостей по критерию \"Активна\", во вкладке \"Панель управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void filteringNewsStatusActiveControlPanel() {
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
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.clickCheckboxNotActiveToFilterNews();
        FilterSteps.clickButtonToFilterNews();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("ACTIVE")));
    }

    //  ТС - 51 - Фильтрация новостей по критерию "Не активна", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 51")
    @Description("//  ТС - 51 - Фильтрация новостей по критерию \"Не активна\", во вкладке \"Панель управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void filteringNewsStatusNotActiveControlPanel() {
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
        NewsControlPanelSteps.clickButtonToEditNews();
        NewsControlPanelSteps.clickButtonToSwitchStatusNews();
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        FilterSteps.clickButtonToFilterNewsPanel();
        FilterSteps.clickCheckboxActiveToFilterNews();
        FilterSteps.clickButtonToFilterNews();
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
        NewsControlPanelSteps.clickButtonToDeleteNews();
        NewsControlPanelSteps.clickButtonToOkDeleteNews();
    }
}
