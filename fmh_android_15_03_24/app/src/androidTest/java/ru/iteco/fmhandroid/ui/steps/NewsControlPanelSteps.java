package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryBirthday;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryCelebration;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categorySalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryUnion;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionBirthday;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionBirthdayEdit;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionGratitudeDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionSalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionUnion;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleBirthdayEdit;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleCelebration;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleGratitudeDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleSalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleUnion;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage;

public class NewsControlPanelSteps {

    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();

    public void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonControlPanel
                .perform(click());
    }

    public void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        newsControlPanelPage.getNewsControlPanelElementsAddNews
                .perform(click());
    }


    public void fillTitleCreatingNews(String text) {
        Allure.step("Ввести в поле Заголовок заголовок новости");
        newsControlPanelPage.getNewsControlPanelElementsButtonTitleCreatingNews
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonDateCreatingNews() {
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(click());
    }

    public void clickButtonOkDateCreatingNews() {
        Allure.step("Нажать кнопку ОК Дата");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkDateCreatingNews
                .perform(click());
    }

    public void clickButtonTimeCreatingNews() {
        Allure.step("В поле Время выбрать время");
        newsControlPanelPage.getNewsControlPanelElementsButtonTimeCreatingNews
                .perform(click());
    }

    public void clickButtonOkTimeCreatingNews() {
        Allure.step("Нажать кнопку ОК Время");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkTimeCreatingNews
                .perform(click());
    }

    public void fillDescriptionCreatingNews(String text) {
        Allure.step("Ввести в поле Описание описание новости");
        newsControlPanelPage.getNewsControlPanelElementsDescriptionCreatingNews
                .perform(replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonSaveCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        newsControlPanelPage.getNewsControlPanelElementsButtonSaveCreatingNews
                .perform(scrollTo(), click());
    }


    public void fillInNewsCategoryField(String text) {
        Allure.step("Поле категория - ввод данных");
        newsControlPanelPage.getNewsControlPanelElementsCategoryText.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    static String nextYear = "15.04.2026";

    public void clickButtonDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(nextYear));
    }

    public void manualInputTime() {
        Allure.step("Вручную ввести время публикации новости");
        newsControlPanelPage.getNewsControlPanelElementsInputTime
                .perform(click());
    }

    public void clickButtonSortingNews() {
        Allure.step("Нажать кнопку Сортировать новости в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonSortingControlPanel
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step("Нажать кнопку Развернуть новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToExpandNews
                .perform(click());
    }

    public void clickButtonToDeleteNews() {
        Allure.step("Нажать кнопку Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToDeleteNews
                .perform(click());
    }

    public void clickButtonToOkDeleteNews() {
        Allure.step("Нажать кнопку ОК Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToOkDeleteNews
                .perform(click());
    }

    public void clickButtonToEditNews() {
        Allure.step("Нажать кнопку Редактировать новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToEditNews
                .perform(click());
    }

    public void clickButtonToSwitchStatusNews() {
        Allure.step("Сменить статус Активная на статус Не активна (передвинуть рычажок).");
        newsControlPanelPage.getNewsControlPanelElementsButtonToSwitchStatusNews
                .perform(click());
    }

    public static String getCategoryAdvertisement() {
        return categoryAdvertisement;
    }

    public static String getTitleAdvertisement() {
        return titleAdvertisement;
    }

    public static String getDescriptionAdvertisement() {
        return descriptionAdvertisement;
    }

    public static String getCategorySalary() {
        return categorySalary;
    }

    public static String getTitleSalary() {
        return titleSalary;
    }

    public static String getDescriptionSalary() {
        return descriptionSalary;
    }

    public static String getTitleDonations() {
        return titleDonations;
    }

    public static String getDescriptionDonations() {
        return descriptionDonations;
    }

    public static String getCategoryBirthday() {
        return categoryBirthday;
    }

    public static String getDescriptionBirthday() {
        return descriptionBirthday;
    }

    public static String getTitleSalaryEnumerated() {
        return titleSalaryEnumerated;
    }

    public static String getDescriptionSalaryEnumerated() {
        return descriptionSalaryEnumerated;
    }

    public static String getCategoryUnion() {
        return categoryUnion;
    }

    public static String getTitleUnion() {
        return titleUnion;
    }

    public static String getDescriptionUnion() {
        return descriptionUnion;
    }

    public static String getCategoryCelebration() {
        return categoryCelebration;
    }

    public static String getTitleCelebration() {
        return titleCelebration;
    }

    public static String getCustomCategory() {
        return customCategory;
    }

    public static String getCustomCategoryTitle() {
        return customCategoryTitle;
    }

    public static String getCustomCategoryDescription() {
        return customCategoryDescription;
    }

    public static String getNumbersCategory() {
        return numbersCategory;
    }

    public static String getNumbersCategoryTitle() {
        return numbersCategoryTitle;
    }

    public static String getNumbersCategoryDescription() {
        return numbersCategoryDescription;
    }

    public static String getSpecialCharactersCategory() {
        return specialCharactersCategory;
    }

    public static String getSpecialCharactersCategoryTitle() {
        return specialCharactersCategoryTitle;
    }

    public static String getSpecialCharactersCategoryDescription() {
        return specialCharactersCategoryDescription;
    }

    public static String getCategoryGratitude() {
        return categoryGratitude;
    }

    public static String getTitleGratitude() {
        return titleGratitude;
    }

    public static String getDescriptionGratitude() {
        return descriptionGratitude;
    }

    public static String getCategoryNeedHelp() {
        return categoryNeedHelp;
    }

    public static String getTitleNeedHelp() {
        return titleNeedHelp;
    }

    public static String getDescriptionNeedHelp() {
        return descriptionNeedHelp;
    }

    public static String getTitleGratitudeDonations() {
        return titleGratitudeDonations;
    }

    public static String getDescriptionGratitudeDonations() {
        return descriptionGratitudeDonations;
    }

    public static String getTitleBirthdayEdit() {
        return titleBirthdayEdit;
    }

    public static String getDescriptionBirthdayEdit() {
        return descriptionBirthdayEdit;
    }
}


