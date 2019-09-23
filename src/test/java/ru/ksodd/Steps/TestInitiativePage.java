package ru.ksodd.Steps;

import cucumber.api.java.bs.I;
import cucumber.api.java.en.*;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Initiative;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;

public class TestInitiativePage {
    @And("Проверка открытия формы$")
    public static void testOpenForm() {
        Initiative.testOpenForm("Инициатива");
    }

    @And("Ввод и выбор улицы \"(.*)\"$")
    public static void inputStreet(String street) throws IOException {
        Initiative.inputStreetInit(street);
    }

    @And("Ввод содержания работ$")
    public static void inputJobContent() {
        Initiative.inputJobContent("Залатать яму");
    }

    @And("Загрузка файлов \"(.*)\"$")
    public static void uploatFile(String name) {
        Initiative.uploadFile(name);
        sleep(500);
    }

    @And("Клик на кнопку  \"(.*)\"$")
    public static void clickSave(String button) throws IOException {
//        sleep(500);
        TestHelper.clickButton(button);
//        sleep(10000);

    }

    @And("^проверка наличия созданной карточки$")
    public static void testAddNewCart() throws IOException {
        TestHelper.testAddCard();
    }



}
