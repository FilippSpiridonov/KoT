package ru.ksodd.Steps;

import cucumber.api.java.en.*;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Initiative;

import static com.codeborne.selenide.Selenide.sleep;

public class TestInitiativePage {
    @And("проверка открытия формы$")
    public static void testOpenForm() {
        Initiative.testOpenForm("Инициатива");
    }

    @And("ввод и выбор улицы \"(.*)\"$")
    public static void inputStreet(String street) {
        Initiative.inputStreetInit(street);
    }

    @And("ввод содержания работ$")
    public static void inputJobContent() {
        Initiative.inputJobContent("Залатать яму");
    }

    @And("загрузка файлов \"(.*)\"$")
    public static void uploatFile(String name) {
        Initiative.uploadFile(name);
    }

    @And("Клик на кнопку  \"(.*)\"$")
    public static void clickSave(String button) {
        TestHelper.clickButton(button);
//        sleep(5000);
    }

    @And("^проверка наличия созданной карточки$")
    public static void testAddNewCart() {
        TestHelper.testAddCard();
    }



}
