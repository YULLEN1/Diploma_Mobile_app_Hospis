package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class NewsControlPanelPage {

    public ViewInteraction getNewsControlPanelElementsButtonControlPanel;
    public ViewInteraction getNewsControlPanelElementsAddNews;
    public ViewInteraction getNewsControlPanelElementsButtonTitleCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonDateCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonOkDateCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonTimeCreatingNews;
    public ViewInteraction getNewsControlPanelElementsDescriptionCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonOkTimeCreatingNews;
    public ViewInteraction getNewsControlPanelElementsButtonSaveCreatingNews;
    public ViewInteraction getNewsControlPanelElementsCategoryText;
    public ViewInteraction getNewsControlPanelElementsInputTime;
    public ViewInteraction getNewsControlPanelElementsButtonSortingControlPanel;
    public ViewInteraction getNewsControlPanelElementsButtonToExpandNews;
    public ViewInteraction getNewsControlPanelElementsButtonToDeleteNews;
    public ViewInteraction getNewsControlPanelElementsButtonToOkDeleteNews;
    public ViewInteraction getNewsControlPanelElementsButtonToEditNews;
    public ViewInteraction getNewsControlPanelElementsButtonToSwitchStatusNews;

    public static String categoryAdvertisement;
    public static String titleAdvertisement;
    public static String descriptionAdvertisement;
    public static String categorySalary;
    public static String titleSalary;
    public static String descriptionSalary;
    public static String titleDonations;
    public static String descriptionDonations;
    public static String categoryBirthday;
    public static String descriptionBirthday;
    public static String titleSalaryEnumerated;
    public static String descriptionSalaryEnumerated;
    public static String categoryUnion;
    public static String titleUnion;
    public static String descriptionUnion;
    public static String categoryCelebration;
    public static String titleCelebration;
    public static String customCategory;
    public static String customCategoryTitle;
    public static String customCategoryDescription;
    public static String numbersCategory;
    public static String numbersCategoryTitle;
    public static String numbersCategoryDescription;
    public static String specialCharactersCategory;
    public static String specialCharactersCategoryTitle;
    public static String specialCharactersCategoryDescription;
    public static String categoryGratitude;
    public static String titleGratitude;
    public static String descriptionGratitude;
    public static String categoryNeedHelp;
    public static String titleNeedHelp;
    public static String descriptionNeedHelp;
    public static String titleGratitudeDonations;
    public static String descriptionGratitudeDonations;
    public static String titleBirthdayEdit;
    public static String descriptionBirthdayEdit;


    public NewsControlPanelPage() {

        getNewsControlPanelElementsButtonControlPanel = onView(withId(R.id.edit_news_material_button));
        getNewsControlPanelElementsAddNews = onView(withId(R.id.add_news_image_view));
        getNewsControlPanelElementsButtonTitleCreatingNews = onView(withId(R.id.news_item_title_text_input_edit_text));
        getNewsControlPanelElementsButtonDateCreatingNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        getNewsControlPanelElementsButtonOkDateCreatingNews = onView(withId(android.R.id.button1));
        getNewsControlPanelElementsButtonTimeCreatingNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        getNewsControlPanelElementsDescriptionCreatingNews = onView(withId(R.id.news_item_description_text_input_edit_text));
        getNewsControlPanelElementsButtonOkTimeCreatingNews = onView(withId(android.R.id.button1));
        getNewsControlPanelElementsButtonSaveCreatingNews = onView(withId(R.id.save_button));
        getNewsControlPanelElementsCategoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        getNewsControlPanelElementsInputTime = onView(allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to text input mode for the time input.")));
        getNewsControlPanelElementsButtonSortingControlPanel = onView(withId(R.id.sort_news_material_button));
        getNewsControlPanelElementsButtonToExpandNews = onView(withIndex(withId(R.id.news_item_material_card_view), 0));
        getNewsControlPanelElementsButtonToDeleteNews = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
        getNewsControlPanelElementsButtonToOkDeleteNews = onView(withId(android.R.id.button1));
        getNewsControlPanelElementsButtonToEditNews = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));
        getNewsControlPanelElementsButtonToSwitchStatusNews = onView(withId(R.id.switcher));
        categoryAdvertisement = "Объявление";
        titleAdvertisement = "Объявлен сбор";
        descriptionAdvertisement = "Строительство бассейна";
        categorySalary = "Зарплата";
        titleSalary = "Начислен аванс";
        descriptionSalary = "Перечислен аванс";
        titleDonations = "Пожертвования";
        descriptionDonations = "Собираются пожертвования";
        categoryBirthday = "День рождения";
        descriptionBirthday = "Пётр Иванов";
        titleSalaryEnumerated = "Начислена зарплата";
        descriptionSalaryEnumerated = "Зарплата перечислена";
        categoryUnion = "Профсоюз";
        titleUnion = "Расписание собраний";
        descriptionUnion = "Первое собрание";
        categoryCelebration = "Праздник";
        titleCelebration = "С Новым годом";
        customCategory = "Пожертвования";
        customCategoryTitle = "Объявлен сбор";
        customCategoryDescription = "На модернизацию корпуса";
        numbersCategory = "123456";
        numbersCategoryTitle = "Объявление";
        numbersCategoryDescription = "Собрание профсоюза";
        specialCharactersCategory = "%:?*;№%:?";
        specialCharactersCategoryTitle = "Открытие корпуса";
        specialCharactersCategoryDescription = "Корпус построен";
        categoryGratitude = "Благодарность";
        titleGratitude = "Юлии Ивановой";
        descriptionGratitude = "За заслуги";
        categoryNeedHelp = "Нужна помощь";
        titleNeedHelp = "Пациентам";
        descriptionNeedHelp = "Посещение";
        titleGratitudeDonations = "Ивану Сидорову";
        descriptionGratitudeDonations = "За пожертвования";
        titleBirthdayEdit = "Пётр Иванов";
        descriptionBirthdayEdit = "Юбилей";
    }

}


