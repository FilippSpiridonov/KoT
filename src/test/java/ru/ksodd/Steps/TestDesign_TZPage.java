package ru.ksodd.Steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Design_TZ;

import static com.codeborne.selenide.Selenide.sleep;

public class TestDesign_TZPage {
    @Then("^Переход в раздел \"(.*)\"$")
    public static void clickTab(String nameTab){
        TestHelper.clickTab(nameTab);
    }

    @When("^Ввод основания \"(.*)\"$")
    public static void inputBase(String text){
        Design_TZ.inputBase(text);
    }

    @When("^Выбор основания \"(.*)\"$")
    public static void selectionBase(String base){
        Design_TZ.inputBase(base);
    }

    @When("^проверка наличия созданной карточки в тз$")
    public static void testAddCard(){
        Design_TZ.selectedLastId();
    }

    @When("^Клик на таск \"(.*)\" в ТЗ$")
    public static void clickTuskTZ(String click){
        sleep(10000);
        Design_TZ.clickTusk(click);
    }

    @When("^Ввод значения знаков$")
    public static void inputZnak(){
        Design_TZ.clickZnak("green");
        Design_TZ.clickZnak("red");
        Design_TZ.clickZnak("grey");
    }

    @When("^Выбор даты реализации$")
    public static void inputDate(){
        Design_TZ.inputDate();
    }

}
