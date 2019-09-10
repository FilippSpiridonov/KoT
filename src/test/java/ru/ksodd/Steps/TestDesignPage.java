package ru.ksodd.Steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Design;

import java.io.DataInput;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;

public class TestDesignPage {

    @And("^выбор типа \"(.*)\"$")
    public static void selectType(String type) throws IOException {
        Design.selectType(type);
    }

    @And("^выбор программы \"(.*)\"$")
    public static void selectProgramm(String program) throws IOException {
        Design.selectProgramm(program);
    }

    @And("^ввод объем работ \"(.*)\"$")
    public static void volume(String metr) throws IOException {
        Design.inputVolume(metr);
    }

    @And("^ввод планируемых работ \"(.*)\"$")
    public static void areatext(String areatext) throws IOException {
        Design.inputBox(areatext);
    }

    @And("^Клик на чек-бокс провести натурные обследования$")
    public static void clickCheck() {
        Design.clickCheck();
    }

    @And("ввод  и выбор улицы \"(.*)\"")
    public static void selectStreet(String street) throws IOException {
        sleep(500);
        Design.selectStreet(street);
    }

    @And("Загрузка  файлов \"(.*)\"")
    public static void uploadFile(String file_name) {
        Design.uploadFile(file_name, "jpg.jpg");
    }

    @When("^Клик на таск \"(.*)\"$")
    public static void clickTask(String task) throws IOException {
        sleep(5000);
        TestHelper.clickTask(task);
    }


    @When("^Клик на таск \"(.*)\" 2$")
    public static void clickTask1(String task) throws IOException {
        sleep(7000);
        TestHelper.clickTask1(task);
    }


    @And("Загрузка   файлов \"(.*)\"")
    public static void uploadFile1(String file_name1) {
        Design.uploadFile1(file_name1, "jpg.jpg");
    }

//    @And("Загрузка   файлов \"(.*)\"  много")
//    public static void uploadFile1(String file_name2) {
//        Design.uploadFile1(file_name2, "jpg.jpg");
//    }


    @When("^цикл \"(.*)\"$")
    public static void whileCheck(String task) {
        Design.whileCheck(task);
    }

    @And("^ввод \"(.*)\" \"(.*)\"$")
    public static void inputGoing(String inputName, String text) throws IOException {
        Design.inputGoing(inputName, text);
    }
}
