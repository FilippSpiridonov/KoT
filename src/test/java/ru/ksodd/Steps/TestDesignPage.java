package ru.ksodd.Steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.By;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Design;

import java.io.DataInput;

import static com.codeborne.selenide.Selenide.sleep;

public class TestDesignPage {

    @And("^выбор типа \"(.*)\"$")
    public static void selectType(String type) {
        Design.selectType(type);
    }

    @And("^выбор программы \"(.*)\"$")
    public static void selectProgramm(String program) {
        Design.selectProgramm(program);
    }

    @And("^ввод объем работ \"(.*)\"$")
    public static void volume(String metr) {
        Design.inputVolume(metr);
    }

    @And("^ввод планируемых работ \"(.*)\"$")
    public static void areatext(String areatext) {
        Design.inputBox(areatext);
    }

    @And("^Клик на чек-бокс провести натурные обследования$")
    public static void clickCheck() {
        Design.clickCheck();
    }

    @And("ввод  и выбор улицы \"(.*)\"")
    public static void selectStreet(String street) {
        sleep(500);
        Design.selectStreet(street);
    }

    @And("Загрузка  файлов \"(.*)\"")
    public static void uploadFile(String file_name) {
        Design.uploadFile(file_name, "jpg.jpg");
    }

    @When("^Клик на таск \"(.*)\"$")
    public static void clickTask(String task) {
        sleep(2000);
        TestHelper.clickTask(task);
    }

    @And("Загрузка   файлов \"(.*)\"")
    public static void uploadFile1(String file_name1) {
        Design.uploadFile1(file_name1, "jpg.jpg");
    }

    @When("^цикл$")
    public static void whileCheck() {
        Design.whileCheck("Префектура");
    }

    @And("^ввод \"(.*)\" \"(.*)\"$")
    public static void inputGoing(String inputName, String text) {
        Design.inputGoing(inputName, text);
    }

}
