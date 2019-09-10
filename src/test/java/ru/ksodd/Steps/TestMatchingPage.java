package ru.ksodd.Steps;

import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Matching;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;

public class TestMatchingPage {

    @When("^Клик на таск  \"(.*)\"$")
    public static void clickTask(String task) throws IOException {
        sleep(5000);
        TestHelper.clickTaskPackage(task);
    }

    @When("^Выбор улицы$")
    public static void clickTask() {
        Matching.inputStreet();
    }

    @When("^Выбор ТС из списка$")
    public static void inputList() {
        Matching.inputList();
    }

    @When("^Выбор начала даты графиков$")
    public static void inputDateNow(){
        Matching.inputDateNow();
    }

    @When("^Выбор конца даты графиков$")
    public static void inputDateEnd(){
        Matching.InputDateEnd();
    }

    @When("^Выбор таска по времени$")
    public static void clickTuskDate(){
        sleep(8000);
        Matching.clickTuskDate();
    }

    @When("^Выбор таска по второму времени$")
    public static void clickTuskDate1(){
        sleep(8000);
        Matching.clickTuskDate1();
    }

}

